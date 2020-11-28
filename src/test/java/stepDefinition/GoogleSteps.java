package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSteps {
    WebDriver driver;

    @Given("The browser is launched")
    public void the_browser_is_launched() throws Throwable{
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @When("The google web page is opened")
    public void the_google_web_page_is_opened() throws Throwable{
        driver.get("https://www.google.com/");
    }

    @Then("^Search for the \"(.*?)\"$")
    public void search_for_the(String element) throws Throwable{
        driver.findElement(By.name("q")).click();
        driver.findElement(By.name("q")).sendKeys(element);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Thread.sleep(5000);

    }

    @Then("^Validate the result is displayed as \"(.*?)\"$")
    public void validate_the_result_is_displayed(String expected) throws Throwable{
        if(expected.equals("notmatch")){
            Assert.assertTrue(driver.findElement(By.xpath("//p[@style='margin-top:1em']")).isDisplayed());
        } else if (expected.equals("didyoumean")){
            Assert.assertTrue(driver.findElement(By.xpath("//p[@class='p64x9c card-section KDCVqf']")).isDisplayed());
        }

    }
}
