package TestNGProjeler;
/*  - IFrame, web sayfası icine yerlestirilmis baska bir web sayfasıdır. Bir HTML dosyasının içine
     yerleştirilmiş baska bir HTML yerleştirilmesi

    - IFrame genellikle bir Web sayfasına dokuman, video veya interaktif media gibi başka bir kaynaktan içerik
     eklemek için kullanılır.

    - <iframe> tag'ı kullanılır.

    - Iframe geçiş için önce locate yapılır sonra da switchTo() uygulanır.

    - 3 şekilde Iframe geçiş yapılır.

        1 ) index
        driver.switchTo( ).frame(index of the iframe);
        index 0’dan baslar.
        2 ) id veya name value
        driver.switchTo( ).frame("id of the iframe");
        3 ) WebElement
        driver.switchTo( ).frame(WebElement of the iframe);

     - Iframe’den cikmak icin 2 komut kullanılır.
        driver.switchTo( ).parentFrame( );  --> 1 ust seviyedeki frame’e geçiş.

        driver.switchTo( ).defaultContent( ); En üstteki frame’e geçiş icin kullanılır.
*/

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class IframeHandleTest {

    /* https://the-internet.herokuapp.com/iframe adresine gidin.
       Bir metod olusturun: iframeTest
       “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda
        yazdirin.
       Text Box’a “Selenium'u seviyorum!” yazin.
       TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
       dogrulayin ve konsolda yazdirin.

 */
    WebDriver driver;

    @BeforeClass
    public void setup() {
        // https://the-internet.herokuapp.com/iframe adresine gidin.
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void iframeTest() throws InterruptedException {
    // “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
       SoftAssert assertion=new SoftAssert();
       WebElement anIframe=driver.findElement(By.tagName("h3"));
       assertion.assertTrue(anIframe.isEnabled(),"Test isEnable FAILED");
       System.out.println(anIframe.getText());
       Thread.sleep(2000);

       //Text Box’a “Selenium'u seviyorum!” yazin.
       WebElement iFrame=driver.findElement(By.tagName("iframe"));
       // Text alanı ıframe'dir. Bu sebeple iframe geçiş yapmalıyız.
       driver.switchTo().frame(iFrame);
       WebElement text=driver.findElement(By.tagName("p"));
       text.clear();
       text.sendKeys("Selenium'u seviyorum!");
        Thread.sleep(2000);

       //TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
       //dogrulayin ve konsolda yazdirin.
        driver.switchTo().parentFrame();
        // Bu alan ana sayfada bu yüzden driver'ı ıframe'den dişarı çıkarmalıyız.
        WebElement text2=driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        assertion.assertTrue(text2.isDisplayed(),"isDisplayed FAILED");
        System.out.println(text2.getText());
        assertion.assertAll();
    }
   @AfterClass
    public void teaarDown(){
        driver.quit();
   }

}
