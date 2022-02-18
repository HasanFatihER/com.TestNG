package TestNGProjeler;

import Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
      /* Keyboard Action Class’indan kullanacagimiz method’lar

       sendKeys ( ): Öğeye bir dizi anahtar gönderir
       keyDown ( ): Klavyede tuşa basma işlemi gerçekleştirir
       keyUp ( ): Klavyede tuşu serbest bırakma işlemi gerçekleştirir   */

public class KeyboardActionTest extends TestBase {
    @Test
    public void keyboardActionTest() throws InterruptedException {
        /*
        *   1- https://www.facebook.com adresine gidelim
            2- Yeni hesap olustur butonuna basalim
            3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
            4- Kaydol tusuna basalim */
        // Bekleme süreleri her kodun çalışma şeklini görmeniz içindir.

        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        Thread.sleep(1000);
        WebElement isim=driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        isim.sendKeys("Hasan");



       Thread.sleep(1000);
        Actions actions=new Actions(driver);
        /* Bunu tek sıra halinde de yazabiliriz.
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("ER").perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("alivelitest@gmil.com").perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("alivelitest@gmil.com").perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("password1").perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        */
        actions.sendKeys(Keys.TAB)
                .sendKeys("ER")
                .sendKeys(Keys.TAB)
                .sendKeys("alivelitest@gmil.com")
                .sendKeys(Keys.TAB)
                .sendKeys("alivelitest@gmil.com")
                .sendKeys(Keys.TAB)
                .sendKeys("password1")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .sendKeys("9",Keys.ENTER)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .sendKeys("1",Keys.ENTER)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .sendKeys("1995",Keys.ENTER)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.RIGHT)
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        Thread.sleep(2000);







    }
}
