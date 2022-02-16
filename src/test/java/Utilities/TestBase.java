package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

/* Utilities klasörü test dosyamızda hızlıca ulamak istediğimiz dataları koyduğumuz yerdir.

   BaseTest class'ında temel setup ayarlarımı yapıp, bundan sonraki testlerimde bu class'ı parent
   class olarak kullanacağız.
*/
public class TestBase {
    protected WebDriver driver;  // package TestNGProjeler den ya da başka bir package'tan erişeceğim için
                                    // ya public ya aa protected olmalı.

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
