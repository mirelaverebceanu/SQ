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

public class QuickViewSteps extends BaseTest {
    static WomenProductsPage womenProductsPage;
    List<Map<String, String>> reviewDetails;
    WebDriverWait wait;
    String expectedName;

    @Given("The shop web page is opened")
    public void the_shop_web_page_is_opened() throws Throwable {
        init();
        womenProductsPage = new WomenProductsPage(driver);
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(womenProductsPage.logo));
        Assert.assertTrue(womenProductsPage.logo.isDisplayed());
    }

    @When("Click on Women section dropdown")
    public void click_on_women_section_dropdown() throws Throwable {
        womenProductsPage.clickOnWomenMenuDropDown();
    }

    @Then("Click on Women Clothing option")
    public void click_on_women_clothing_option() throws Throwable {
        womenProductsPage.clickOnWomenClothingBtn();
    }

    @Then("Select one of the products")
    public void select_one_of_the_products() throws Throwable {
        Actions action = new Actions(driver);
        action.moveToElement(womenProductsPage.quickView).build().perform();
        expectedName = womenProductsPage.getElementName();
    }

    @Then("Click on Quick View button on the selected element")
    public void click_on_quick_view_button_on_the_selected_element() throws Throwable {
        womenProductsPage.clickOnQuickViewButton();
    }

    @Then("Validate that the name of returned product is the same as for requested one")
    public void validate_that_the_name_of_returned_product_is_the_same_as_for_requested_one() throws Throwable {
        Assert.assertEquals(expectedName, womenProductsPage.getReturnedElemName());

    }
}
