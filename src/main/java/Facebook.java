import Utils.Array;
import Utils.ForTry;
import Utils.Logare;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;


public class Facebook {

    public static WebDriver driver;
    public static ChromeOptions options;
    Logare log = new Logare();
    ForTry client = new ForTry();
    PrintStream Totext;
    @Before
    public void Configure()throws IOException{
//Path to chrome driver, set here your path
        String path_to_chrome_driver = "C:\\Users\\nasui\\Desktop\\Selenium_Tat\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path_to_chrome_driver);
        options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-web-security");
        options.addArguments("--no-proxy-server");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        File file = new File("D:\\Data_Collection\\info.txt");
        file.getParentFile().mkdirs();
        file.createNewFile();
        Totext = new PrintStream(new File("D:\\Data_Collection\\info.txt"));


    }
    @Test
    public void FB()  {
        log.logare(driver);


        Array ar = new Array();
        String arr[] = ar.returnArray();
        try{
            int z = 0;
            while (z <= arr.length) {
                driver.get("https://www.facebook.com/search/people/?q="+arr[z]+"");
                try {
                    client.owerViewStringere(driver, arr[z],Totext);
                    Thread.sleep(2000);
                    client.contactsView(driver, arr[z],Totext);
                    Thread.sleep(2000);
                    z++;
                }
                catch (Exception err) {
                    Totext.println("For the number '"+arr[z]+"' does not have info");
                      z++;
                }
                Thread.sleep(2000);}
        }
        catch (Exception ex)
        {
         System.out.println("Exit");
        }
    }

    @After
    public void Close(){
        driver.close();
    }
}
