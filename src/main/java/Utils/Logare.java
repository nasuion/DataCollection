package Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Logare {

    public void logare(WebDriver driver) {
        driver.get("https://www.facebook.com");
// Email\Phone
        driver.findElement(By.cssSelector("#email")).sendKeys("alexandru.moraru@ipdeer.com");
// Password
        driver.findElement(By.cssSelector("#pass")).sendKeys("V123456789v");
        driver.findElement(By.cssSelector("#loginbutton > input")).click();
    }
}
