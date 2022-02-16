package TestNGProjeler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Set;

public class WindowHandle {

    /*
       1. https://the-internet.herokuapp.com/windows adresine gidin.
       2. Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
       3. Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
       4. Click Here butonuna basın.
       5. Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
       6. Sayfadaki textin “New Window” olduğunu doğrulayın.
       7. Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu
        doğrulayın. */

    WebDriver driver;

    @BeforeClass
    public void setup() {
        // 1.https://the-internet.herokuapp.com/windows adresine gidin.
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void newWebPageTest() throws InterruptedException {
        System.out.println("herokuapp handle değeri :" + driver.getWindowHandle());
        String herokuappHandle = driver.getWindowHandle();
        // 2. Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        // Verify varsa akla softassertion gelsin.
        WebElement text = driver.findElement(By.tagName("h3"));
        SoftAssert assertion = new SoftAssert();
        assertion.assertEquals(text.getText(), "Opening a new window", "Doğrulama Testi FAILED");

        // 3. Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        assertion.assertEquals(driver.getTitle(), "The Internet", "Title Test FAILED");

        // 4. Click Here butonuna basın.
        // Buraya geçmeden önce ilk sayfanın windowhandle değerin aldığınızdan emin olun.
        driver.findElement(By.xpath("(//a[@target='_blank'])[1]")).click();
        //Clickten sonra yeni sayfa açıldı fakat driver switchTo yapmadığımız için bu sayfaya aktarılamadı.
        Set<String> handles = driver.getWindowHandles();
        System.out.println(driver.getWindowHandles());
        String clickHandle = "";
        for (String w : handles
        ) {
            if (!w.equals(herokuappHandle)) {
                clickHandle = w;
            }

        }
        System.out.println("clickHandle değeri : " + clickHandle);
        Thread.sleep(2000);
        // 5. Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        // Driver'ı bu sayfaya almalıyım.
        driver.switchTo().window(clickHandle);
        assertion.assertEquals(driver.getTitle(), "New Window", "New Window Test FAILED");
        Thread.sleep(2000);
        // 6. Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement textNew = driver.findElement(By.tagName("h3"));
        assertion.assertEquals(textNew.getText(), "New Window", "New Window Text Test FAILED");
        Thread.sleep(2000);
       // 7. Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu
       // doğrulayın.
        driver.switchTo().window(herokuappHandle);
        assertion.assertEquals(driver.getTitle(), "The Internet", "The Internet Title Test FAILED");
        Thread.sleep(2000);
        assertion.assertAll();
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}

