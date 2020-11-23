package stepDefinition;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import poms.WomenProductsPage;

import java.util.List;
import java.util.Map;

public class ReplayOnReviewSteps extends BaseTest {

    static WomenProductsPage womenProductsPage;
    List<Map<String, String>> reviewDetails;
    WebDriverWait wait;

    @Given("The web page is launched")
    public void the_web_page_is_opened() throws Throwable {
        init();
        womenProductsPage = new WomenProductsPage(driver);
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(womenProductsPage.logo));
        Assert.assertTrue(womenProductsPage.logo.isDisplayed());
    }

    @When("Click on Women's wear dropdown button")
    public void click_on_women_s_wear_drop_down_button() throws Throwable {
        womenProductsPage.clickOnWomenMenuDropDown();

    }

    @Then("Select WomenClothing link text")
    public void select_women_clothing_link_text() throws Throwable {
        womenProductsPage.clickOnWomenClothingBtn();

    }

    @Then("Hover over the image of a product")
    public void hover_over_the_image_of_any_product() throws Throwable {
        Actions action = new Actions(driver);
        action.moveToElement(womenProductsPage.quickView).build().perform();
    }

    @Then("Click on QUICK VIEW link button")
    public void click_on_quick_view_button() throws Throwable {
        womenProductsPage.clickOnQuickViewButton();
    }

    @Then("Select from tabs the Reviews tab")
    public void select_the_reviews_tab() throws Throwable {
        womenProductsPage.clickOnReviewTab();

    }

    @Then("Click on Replay button")
    public void click_on_replay_button() throws Throwable {
        womenProductsPage.clickOnReplayBtn();
        Assert.assertTrue(womenProductsPage.isReplyFormDisplayed());
    }

    @After
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
