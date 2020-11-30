package stepDefinition;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import poms.WomenProductsPage;

import java.util.List;
import java.util.Map;

public class CommunityPollSteps extends BaseTest {

    static WomenProductsPage womenProductsPage;
    List<Map<String, String>> reviewDetails;
    WebDriverWait wait;

    @Given("The page is opened")
    public void the_page_is_opened() throws Throwable {
        init();
        womenProductsPage = new WomenProductsPage(driver);
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(womenProductsPage.logo));
        Assert.assertTrue(womenProductsPage.logo.isDisplayed());
    }

    @When("Click on the Women's wear dropdown button from the top banner")
    public void click_on_the_women_s_wear_dropdown_button_from_the_top_banner() throws Throwable {
        womenProductsPage.clickOnWomenMenuDropDown();
    }

    @Then("Select Women Clothing link text from the list")
    public void select_women_clothing_link_text_from_the_list() throws Throwable {
        womenProductsPage.clickOnWomenClothingBtn();

    }

    @Then("Click on any non selected radio button")
    public void click_on_any_non_selected_radio_button() throws Throwable {
        womenProductsPage.clickOnPollRadioBtn();

    }

    @Then("Click the SEND button")
    public void click_the_send_button() throws Throwable {
        womenProductsPage.clickOnSendPollBtn();

    }

    @And("Validate that the COMMUNITY POLL is updated")
    public void validate_that_the_community_poll_is_updated() throws Throwable {
        Assert.assertTrue(womenProductsPage.isRadioBtnChecked());

    }

}
