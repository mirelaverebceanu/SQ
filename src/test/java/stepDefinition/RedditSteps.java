package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.CucumberOptions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@CucumberOptions(plugin = {"pretty"}, features = "src/test/resources/features/", glue = {"stepDefinition"})
public class RedditSteps {

    WebDriver driver;

    @Given("^The chrome browser is launched$")
    public void the_chrome_browser_is_launched() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "D://SQ//chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @When("^The reddit web page is opened$")
    public void the_reddit_web_page_is_opened() throws Throwable {
        driver.get("https://www.reddit.com/");

    }

    @Then("^Search for \"(.*?)\"$")
    public void search_for(String element) throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"SHORTCUT_FOCUSABLE_DIV\"]/div[1]/header/div/div[1]//input")).sendKeys(element);
        driver.findElement(By.xpath("//*[@id=\"SHORTCUT_FOCUSABLE_DIV\"]/div[1]/header/div/div[1]//input")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        Assert.assertEquals(true, driver.findElement(By.xpath("//*[@id=\"SHORTCUT_FOCUSABLE_DIV\"]/div[2]/div/div/div/div[2]/div[1]//span[contains(text(), '" + element + "')]")).isDisplayed());
    }

    @Then("^Validate the logo presence$")
    public void validate_the_logo_presence() throws Throwable {
        boolean logoPresence = driver.findElement(By.xpath("//*[@id=\"SHORTCUT_FOCUSABLE_DIV\"]/div[1]/header/div/div[1]/a")).isDisplayed();
        Assert.assertEquals(true, logoPresence);
    }

    @And("^Close browser$")
    public void close_browser() throws Throwable {
        driver.quit();

    }

}
