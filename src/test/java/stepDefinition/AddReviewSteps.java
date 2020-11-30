package stepDefinition;

import base.BaseTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.CucumberOptions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import poms.WomenProductsPage;

import java.util.List;
import java.util.Map;

@CucumberOptions(plugin = {"pretty"}, features = "src/test/resources/features/", glue = {"stepDefinition"})
public class AddReviewSteps extends BaseTest {

    static WomenProductsPage womenProductsPage;
    List<Map<String, String>> reviewDetails;
    WebDriverWait wait;

    @Given("The web page is opened")
    public void the_web_page_is_opened() throws Throwable {
        init();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://adoring-pasteur-3ae17d.netlify.app/");
        womenProductsPage = new WomenProductsPage(driver);
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(womenProductsPage.logo));
        Assert.assertTrue(womenProductsPage.logo.isDisplayed());
    }

    @When("Click on Women's wear drop-down button")
    public void click_on_women_s_wear_drop_down_button() throws Throwable {
        womenProductsPage.clickOnWomenMenuDropDown();

    }

    @Then("Select Women Clothing link text")
    public void select_women_clothing_link_text() throws Throwable {
        womenProductsPage.clickOnWomenClothingBtn();

    }

    @Then("Hover over the image of any product")
    public void hover_over_the_image_of_any_product() throws Throwable {
        Actions action = new Actions(driver);
        action.moveToElement(womenProductsPage.quickView).build().perform();
    }

    @Then("Click on QUICK VIEW button")
    public void click_on_quick_view_button() throws Throwable {
        womenProductsPage.clickOnQuickViewButton();
    }

    @Then("Select the Reviews tab")
    public void select_the_reviews_tab() throws Throwable {
        womenProductsPage.clickOnReviewTab();

    }

    @Then("^In the Name box enter a valid name, in the Email box enter a ([^\"]*) email, and in the Message box a message$")
    public void in_the_name_box_enter_a_valid_name_in_the_email_box_enter_a_valid_email_and_in_the_message_box_a_message(String type, DataTable dataTable) throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(womenProductsPage.nameField));
        reviewDetails = dataTable.asMaps(String.class, String.class);
        womenProductsPage.setReviewDetails(reviewDetails.get(0));
    }

    @And("Click on the Send button")
    public void click_on_the_send_button() throws Throwable {
        womenProductsPage.clickOnSendBtn();
    }

    @And("^Review is ([^\"]*) and displayed on UI$")
    public void review_is_added_and_displayed_on_ui(String element) throws Throwable {
        if (element.equals("added")) {
            Assert.assertTrue(driver.findElement(By.xpath("//div[@class='tab2 resp-tab-content resp-tab-content-active']//p[contains(text(), '" + reviewDetails.get(0).get("message") + "')]")).isDisplayed());
        } else {
            Assert.assertEquals(1,driver.findElements(By.xpath("//div[@class='tab2 resp-tab-content resp-tab-content-active']//p")).size());
        }
    }

    @After
    public void quitDriver(){
        driver.quit();
    }

}
