package TestNGProjeler;

import Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitStrategies extends TestBase {
    /*
        1. Bir class olusturun : WaitStrategies
        2. Iki tane metod olusturun : implicitWait() , explicitWait()
        Iki metod icin de asagidaki adimlari test edin.
        3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        4. Remove butonuna basin.
        5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        6. Add buttonuna basin
        7. It’s back mesajinin gorundugunu test edin  */

    @Test
    public void implicitWait() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        /*
            Aşağıdaki sayfaya gittiğinizde add ve remove yaptığımızda belirli bir bekleme süresi
         olacaktır.implicitlyWait her webelement'ine ulaşmak ya da driver yönlendirmelerinde
         kaybedilecek zamanda testin Failed olmaması için ihtiyaç duyalacağı kadar bekleme yapar.

         -implicitlyWait ve explicitWait bir selenium methodlarıdır ve dinamik wait'tir.
         implicitlyWait genel tüm program için kullanılır.
         Explicitly Wait: Belirli bir koşul(expected condition) için kullanılır.
         - implicitlyWait eğer bizim için çözüm oluyorsa explicitlyWait kullanmamıza gerek yok.
         - ExplicitlyWait için İlk olarak belirli miktarda bekleme süresi ile wait object oluşturulur.
         -Thread.sleep() ise bir Java methodudur ve hard wait'tir. Girilen değer kadar kodu bekletir,
         alt satıra geçmez.


         Duration.ofSeconds(15) süreyi 1 sn yaptığınızda testin failed olacağını gözlemleyebilirsiniz.

         */
        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //  4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        WebElement message = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(message.isDisplayed());
        System.out.println(message.getText()); // Bizde teyit edelim :)
        // 5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        Thread.sleep(3000);

        // Değişikliği gözümüzle görelim.Thread.sleep(3000); ile zorunlu bekletelim.
        // 6. Add buttonuna basin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        WebElement message2 = driver.findElement(By.xpath("//p[@id='message']"));
        // 7. It’s back mesajinin gorundugunu test edin
        Assert.assertTrue(message2.isDisplayed());
        System.out.println(message2.getText());


    }

    @Test
    public void explicitlyWait() throws InterruptedException {
        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        /* ExplicitlyWait için öncelikle bir WebDriverWait objesi oluşturmalıyız.
         * Burada driver bekletilir. */
        WebDriverWait explicitlyWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        //  4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        /* Mesajın görülmesini beklememiz gerekecek fakat  burda locate ve bekleme sekronizasyon
        içinde olmalı. Görünmeyen bir element locate edilemez. (özel izin verilmezse )*/
        WebElement message = driver.findElement(By.xpath("//p[@id='message']"));
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

        Assert.assertTrue(message.isDisplayed());
        System.out.println(message.getText());
        // 5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        Thread.sleep(3000);

        // Değişikliği gözümüzle görelim.Thread.sleep(3000); ile zorunlu bekletelim.
        // 6. Add buttonuna basin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        WebElement message2 = driver.findElement(By.xpath("//p[@id='message']"));
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        // 7. It’s back mesajinin gorundugunu test edin
        Assert.assertTrue(message2.isDisplayed());
        System.out.println(message2.getText());


    }

}
