package TestNGProjeler;

import Utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
    /*
    * Selenium 4 ile gelen özelliktir.
    * İşlem 4 adımda gerçekleştirilir.
    -- TakesScreenShot objesi oluştur. (TakesScreenshot screenshot=(TakesScreenshot)driver)
    -- Kaydetmek istediğin yerin path'ini al ve geçici File objesi oluştur.
    -- Screenshot al ve geçici bir dosya oluştur ve dosyaya at.getScreenshotAs() methodunu kullan.
    -- Kaydettiğimiz resmi saklamak istediğimiz dosyaya copyalıyoruz.
    FileUtils.copyFile(screen,gecici);

    */

public class GetScreenShot extends TestBase {

    @Test
    public void screenShotTest() throws IOException {
        driver.get("https://github.com/HasanFatihER");
        // 1.TakesScreenshot objesi oluştur.
        TakesScreenshot screenshot = (TakesScreenshot) driver; // data casting-Abstruct class

        // 2. Kaydedeceğin ekran görüntüsü için dosya yeri oluştur.
        File screenDosyaYeri = new File("/home/hasan/Pictures/screen.png");

        // 3.Alacağımız ekran görüntüsünü geçici olarak tutacağımız dosyayı
        // oluşturup screenshot'ı alalım ve geçici dosyaya atayalım.
        File tasiyiciDosya = screenshot.getScreenshotAs(OutputType.FILE); // File tipinde

        // 4. Geçici dosyayı hedef dosyaya kopyalıyoruz.
        FileUtils.copyFile(tasiyiciDosya, screenDosyaYeri);

        //Herhangi bir webelement'in screenshot2ını alalım.
        WebElement foto = driver.findElement(By.xpath("//img[@class='avatar avatar-user width-full border color-bg-default']"));
        File logoScreen = new File("/home/hasan/Pictures/");

        /* ScreenShot için utilities klasörüne bir baseclass yapılabilir. Fakat dikkat
        edilmesi gerekilem konu her screenshot'ta aynı isimle kayıt olacağı için bir öncekini siler.

        -- Bunu engellemek için için datetime methodundan faydalanırız.

        GetScreenShot2 ve ScreenShotBase class'larını inceleyiniz.
         */

    }

}
