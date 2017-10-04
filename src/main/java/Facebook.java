import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Facebook {

    public static WebDriver driver;
    public static ChromeOptions options;
    @Before
    public void Configure(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nasui\\Desktop\\Selenium_Tat\\chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-web-security");
        options.addArguments("--no-proxy-server");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);


    }
    @Test
    public void FB(){
        driver.get("https://www.facebook.com");
        driver.findElement(By.cssSelector("#email")).sendKeys("nasuion@gmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("");
        driver.findElement(By.cssSelector("#loginbutton > input")).click();

    }

    @After
    public void Close(){
        driver.close();
    }
}
