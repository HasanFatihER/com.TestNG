package TestNGProjeler;

import Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class KeyboardAction2 extends TestBase {

    /*  1- Bir Class olusturalim KeyboardActions2
        2- https://html.com/tags/iframe/ sayfasina gidelim
        3- video’yu gorecek kadar asagi inin
        4- videoyu izlemek icin Play tusuna basin
        5- videoyu calistirdiginizi test edin
     */

    @Test
    public void keyboardActionTest() throws InterruptedException {
       // 2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        //3- video’yu gorecek kadar asagi inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        WebElement video=driver.findElement(By.className("lazy-loaded"));
        // Video site içine gömülmüş vir iframe. driver'ı iframe'e geçirmeliyiz.
        driver.switchTo().frame(video);
        WebElement play=driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']"));
        actions.click(play).perform();
        Thread.sleep(10000);
        //5- videoyu calistirdiginizi test edin
        Assert.assertFalse(play.isDisplayed(),"Vido çalıştı mı? FAILED");

    }

}
