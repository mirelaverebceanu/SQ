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

    @FindBy(xpath = "//label[contains(text(), \"Lower Price\")]")
    public WebElement poll;

    @FindBy(xpath = "//div[@class=\"community-poll\"]//input[@type=\"submit\"]")
    public WebElement sendPoll;

    @FindBy(xpath = "//input[@value=\"Add to cart\"]")
    public WebElement addToCart;

    @FindBy(xpath = "//input[@class=\"minicart-quantity\"]")
    public WebElement addQnt;

    @FindBy(xpath = "//button[@class='w3view-cart']")
    public WebElement viewCart;

    @FindBy(xpath = "//input[@class='minicart-quantity']")
    public WebElement quantity;

    @FindBy(xpath = "//p[@class='minicart-empty-text']")
    public WebElement empty;

    @FindBy(xpath = "//a[contains(text(), 'A-line Black Skirt')]")
    public WebElement element;

    @FindBy(xpath = "//span[@class='item_price'][1]/parent::p/preceding-sibling::h3")
    public WebElement returnedElement;

    @FindBy(xpath = "//div[@class='reply']//form")
    public WebElement replyForm;

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

    public void clickOnReplayBtn() {

        replayBtn.click();
    }

    public void clickOnPollRadioBtn() {
        poll.click();
    }

    public void clickOnSendPollBtn() {
        sendPoll.click();
    }

    public void clickOnAddToChartBtn() {
        addToCart.click();
    }

    public void inputQuantity() {
        addQnt.click();
        addQnt.sendKeys("a");
    }

    public void clickOnViewChart() {
        viewCart.click();
    }

    public String getQuantity() {
        return quantity.getText();
    }

    public boolean getEmptyQtyText() {
        return empty.isDisplayed();
    }

    public String getElementName() {
        return element.getText();
    }

    public String getReturnedElemName() {
        return returnedElement.getText();
    }

    public boolean isReplyFormDisplayed() {
        return replyForm.isDisplayed();
    }

    public boolean isRadioBtnChecked() {
        return poll.isSelected();
    }

}
