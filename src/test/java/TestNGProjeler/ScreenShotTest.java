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
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShotTest extends TestBase
// extends ScreenShotBase  yazarak da kolay bir şekilde alabilir.
        // Tüm bilgileri tek çatıda görmeniz için burada yazmayı tercih ediyorum.
{

    @Test
    public void screenShotTestAllPage() throws IOException, InterruptedException {
        driver.get("https://github.com/HasanFatihER");
        //TakesScreenshot sınıfından obje oluştur..
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        //Kayıt için File sınıfından dosya oluştur. Ekran görüntüsünü nereye kaydetmek istersen ona göre dosya yolunu ayarla.
        // Date formatında bir isim düzenlemesi yaparak aynı isimde kaydolmasını engellemiş oluruz.
        String scrname = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
        File screenFile = new File("/home/hasan/IdeaProjects/com.TestNG/src/test/java/Screenshots/" + scrname + ".png/");
        // Geçici bir File dosyası aç ve ekran kaydını al.OutputType'ı File olsun.
        File gecici = screenshot.getScreenshotAs(OutputType.FILE);
        // FileUtils ile gecici klasörden elran kaydı klasörüne kopyala.
        FileUtils.copyFile(gecici, screenFile);
       Thread.sleep(1000); // Diğer test'de hızlı olacağı için 2 kayıt almaz. Bu yüzden en az
        // 1 sn gecikme yapmak gerekir.
    }

    @Test
    public void screenShotTestWebElements() throws IOException {
        driver.get("https://github.com/HasanFatihER");
        //  WebElement'ti locate edelim.
        WebElement photo = driver.findElement(By.xpath("//img[@class='avatar avatar-user width-full border color-bg-default']"));
        //Kayıt için File sınıfından dosya oluştur. Ekran görüntüsünü nereye kaydetmek istersen ona göre dosya yolunu ayarla.
        // Date formatında bir isim düzenlemesi yaparak aynı isimde kaydolmasını engellemiş oluruz.
        String scrname2 = new SimpleDateFormat("yyyy-MM-dd-hh-mm").format(new Date());
        File screenFile = new File("/home/hasan/IdeaProjects/com.TestNG/src/test/java/Screenshots/" + scrname2 + ".png/");
        // Geçici bir File dosyası aç ve ekran kaydını al.OutputType'ı File olsun.
        File gecici = photo.getScreenshotAs(OutputType.FILE);
        // FileUtils ile gecici klasörden elran kaydı klasörüne kopyala.
        FileUtils.copyFile(gecici, screenFile);

    }
}
