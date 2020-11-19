package poms;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class WomenProductsPage {

    public WebDriver driver;

    @FindBy(xpath = "//div[@class='header-bot']//a")
    public WebElement logo;

    @FindBy(xpath = "//div[@class = 'container-fluid']//li[@class='dropdown menu__item'][2]/a")
    public WebElement womenDropDown;

    @FindBy(xpath = "//a[text()='Women Clothing']")
    public WebElement womenClothingBtn;

    @FindBy(xpath = "//div[@class=\"single-pro\"]/div[1]//a[contains(text(),\"Quick View\")]")
    public WebElement quickView;

    @FindBy(xpath = "//li[contains(text(),\"Reviews\")]")
    public WebElement reviewTab;

    @FindBy(xpath = "//a[contains(text(),\"Reply\")]")
    public WebElement replayBtn;

    @FindBy(xpath = "//div[@class = \"responsive_tabs_agileits\"]//div[@class=\"resp-tabs-container\"]//input[@type=\"submit\"]")
    public WebElement sendBtn;

    @FindBy(xpath = "//div[@class = \"responsive_tabs_agileits\"]//div[@class=\"resp-tabs-container\"]//input[@name=\"Name\"]")
    public WebElement nameField;

    @FindBy(xpath = "//div[@class = \"responsive_tabs_agileits\"]//div[@class=\"resp-tabs-container\"]//input[@name=\"Email\"]")
    public WebElement emailField;

    @FindBy(xpath = "//div[@class = \"responsive_tabs_agileits\"]//div[@class=\"resp-tabs-container\"]//textarea[@name=\"Message\"]")
    public WebElement messageField;

    public WomenProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnWomenMenuDropDown() {
        womenDropDown.click();
    }

    public void clickOnWomenClothingBtn() {
        driver.get(womenClothingBtn.getAttribute("href"));
    }

    public void clickOnQuickViewButton() {
        quickView.click();
    }

    public void clickOnReviewTab() {
        scrollToElement(reviewTab);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        reviewTab.click();
        System.out.println("Reviews was clicked");
    }

    public void setReviewDetails(Map<String, String> reviewDetails) {
        nameField.sendKeys(reviewDetails.get("name"));
        emailField.sendKeys(reviewDetails.get("email"));
        messageField.sendKeys(reviewDetails.get("message"));
    }

    public void clickOnSendBtn() {
        sendBtn.click();
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }


}
