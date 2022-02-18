package TestNGProjeler;

import Utilities.TestBase;
import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class DownloadExistTest extends TestBase {

    /*  1. Tests packagenin altina bir class oluşturun. DownloadExistTest
        2. Iki tane metod oluşturun : isExist() ve downloadTest()
        3. downloadTest () metodunun icinde aşağıdaki testi yapın.
        - https://the-internet.herokuapp.com/download adresine gidelim.
        - text.txt dosyasını indirelim
        4. Ardından isExist() methodunda dosyanın başarıyla indirilip indirilmediğini test edin
    */

    @Test
    public void downloadTest() throws InterruptedException {
    driver.get("https://the-internet.herokuapp.com/download");
   driver.findElement(By.xpath("//a[text()='text.txt']")).click();
   Thread.sleep(4000);
    }

    @Test
    public void isExist() throws InterruptedException {
    String txt=System.getProperty("user.home")+"/Downloads/text.txt";
        System.out.println(txt);
    Thread.sleep(4000);
        Assert.assertTrue(Files.exists(Paths.get(txt)));

    }


}
