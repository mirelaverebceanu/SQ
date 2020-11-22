package base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    public WebDriver driver;

    public void init() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://adoring-pasteur-3ae17d.netlify.app/");
    }

}
