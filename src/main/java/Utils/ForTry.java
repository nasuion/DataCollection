package Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.PrintStream;
import java.util.List;

public class ForTry {
   private String pseudonim;
   private String general_info = null;
   private List<WebElement> myElements;
   private List<WebElement> basicInf;
   public int m;


    public void owerViewStringere(WebDriver driver, String s,PrintStream Totext) throws InterruptedException {

        Thread.sleep(2000);
//Click on photo
        driver.findElement(By.cssSelector("a.\\_uvc.lfloat.\\_ohe > img.img")).click();
        Thread.sleep(4000);
        pseudonim(driver);
        general_info = driver.findElement(By.xpath("//*[@id=\"fb-timeline-cover-name\"]")).getText();
        Totext.println("Name: "+general_info+"\nPseudonim: "+pseudonim+" \nPhone Number: "+s+"");
//Out href for redirect to about
        String about = driver.findElement(By.cssSelector("ul.clearfix > li:nth-of-type(2) > a")).getAttribute("href");
        driver.get(about);
        myElements = driver.findElement(By.cssSelector("#pagelet_timeline_medley_about > div:nth-of-type(2) > div > ul.uiList > li > div > div:nth-of-type(2) > div")).findElements(By.tagName("li"));
        m=0;
        for(WebElement e : myElements) {
            Totext.println("Info "+ m +"=" + e.getText().replaceAll("\\n", " "));
            m++;
            myElements.indexOf(e);
        }
        Thread.sleep(2000);
    }


    public void contactsView(WebDriver driver,String s,PrintStream Totext) throws InterruptedException {
        String url = driver.getCurrentUrl();
        String urlfinal = url+"&pnref=about&section=contact-info";
        driver.get(urlfinal);
        basicInf = driver.findElement(By.cssSelector("#pagelet_timeline_medley_about > div:nth-of-type(2) > div > ul.uiList > li:nth-of-type(2) > div > div:nth-of-type(2) > div")).findElements(By.tagName("li"));
        int k=m;
        for(WebElement b : basicInf) {
            Totext.println("Info "+k+"=" + b.getText().replaceAll("\\n", " "));
             k++;
            basicInf.indexOf(b);
        }
        Thread.sleep(2000);

    }

    private void pseudonim(WebDriver driver){
        String urlpseu = driver.getCurrentUrl();
        String[] urlpse = urlpseu.split("com/");
        pseudonim = urlpse[1];
    }
}
