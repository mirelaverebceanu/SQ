package stepDefinition;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import poms.WomenProductsPage;

import java.util.List;
import java.util.Map;

public class AddToCartSteps extends BaseTest {

    static WomenProductsPage womenProductsPage;
    List<Map<String, String>> reviewDetails;
    WebDriverWait wait;

    @Given("The web page of Elite Shop is launched")
    public void the_web_page_of_elite_shop_is_launched() throws Throwable {
        init();
        womenProductsPage = new WomenProductsPage(driver);
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(womenProductsPage.logo));
        Assert.assertTrue(womenProductsPage.logo.isDisplayed());
    }

    @When("Click on the Women's wear drop-down button from the top banner")
    public void click_on_the_women_s_wear_drop_down_button_from_the_top_banner() throws Throwable {
        womenProductsPage.clickOnWomenMenuDropDown();
    }

    @Then("Select the Women Clothing link text from the list")
    public void select_the_women_clothing_link_text_from_the_list() throws Throwable {
        womenProductsPage.clickOnWomenClothingBtn();

    }

    @Then("Click on the ADD TO CART button from any item")
    public void click_on_the_add_to_cart_button_from_any_item() throws Throwable {
        womenProductsPage.clickOnAddToChartBtn();
    }

    @Then("Enter in quantity box a letter")
    public void enter_in_quantity_box_a_letter() throws Throwable {
        womenProductsPage.inputQuantity();

    }

    @Then("Click on cart symbol from ban-top")
    public void click_on_cart_symbol_from_ban_top() throws Throwable {
        womenProductsPage.clickOnViewChart();

    }

    @Then("Check the quantity box")
    public void check_the_quantity_box() throws Throwable {
        Assert.assertTrue(womenProductsPage.getEmptyQtyText());

    }
}
