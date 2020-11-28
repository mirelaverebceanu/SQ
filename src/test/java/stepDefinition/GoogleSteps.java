package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class GoogleSteps {
    WebDriver driver;
    String results;
    public DesiredCapabilities caps;
    public String AUTOMATE_USERNAME = "verebceanumirela1";
    public String AUTOMATE_ACCESS_KEY = "TjUG48zSxxSfqd24hyBC";
    public String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Given("The browser is launched")
    public void the_browser_is_launched() throws Throwable{
        caps = new DesiredCapabilities();
        caps.setCapability("browserName",System.getProperty("browser"));
        caps.setCapability("browserVersion",System.getProperty("browser_version"));
        caps.setCapability("os",System.getProperty("os"));
        caps.setCapability("os_version",System.getProperty("os_version"));
        caps.setCapability("device",System.getProperty("device"));
        caps.setCapability("name", "BStack-[Java] Cucumber-Tests"); // test name
        caps.setCapability("build", "Cucumber-Tests"); // CI/CD job or build name
        driver = new RemoteWebDriver(new URL(URL), caps);
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
    }

    @When("The google web page is opened")
    public void the_google_web_page_is_opened() throws Throwable{
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
    }

    @Then("^Search for the \"(.*?)\"$")
    public void search_for_the(String element) throws Throwable{
        WebElement searchBox =driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys(element);
        searchBox.submit();

        results = driver.getTitle().trim();
    }

    @Then("^Validate the result is displayed as \"(.*?)\"$")
    public void validate_the_result_is_displayed(String expected) throws Throwable{
        if(expected.equals("notmatch")){
            Assert.assertTrue(driver.findElement(By.xpath("//p[@style='margin-top:1em']")).isDisplayed());
        } else if (expected.equals("didyoumean")){
            Assert.assertTrue(driver.findElement(By.xpath("//p[@class='p64x9c card-section KDCVqf']")).isDisplayed());
        }
        driver.quit();
    }

}
