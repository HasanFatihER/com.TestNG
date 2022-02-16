package TestNGProjeler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Set;

public class newWindowHandleTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        // https://www.amazon.com/ adresine gidin.
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void newWebPageTest() throws InterruptedException {
        System.out.println("Amazon handle değeri :" + driver.getWindowHandle());
        //yeni sayfa açalım.
        String amazonHandle = driver.getWindowHandle();
        // Daha sonra bu sayfaya geçiş için bize handle değeri gerekecek. Bu değerin loglanması önemlidir.

        driver.switchTo().newWindow(WindowType.WINDOW);
        // Yeni sayfa açılmasını sağlar.Üzerinde açar
        //.newWindow bize webdriver döner.
        driver.get("https://coinmarketcap.com/");
        Thread.sleep(2000);
        System.out.println("Coinmarketcap handle değeri :" + driver.getWindowHandle());
        String coinmarketHandle = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB); // Yeni sekmede pencere açar.
        driver.get("https://github.com/HasanFatihER");
        System.out.println("GitHub handle değeri :" + driver.getWindowHandle());
        String GitHub = driver.getWindowHandle();
        Thread.sleep(2000);

        //Tekrar amazon.com'a dönmek için driver'ı sayfaya gönderelim.
        driver.switchTo().window(amazonHandle);
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Java" + Keys.ENTER);
        Thread.sleep(2000);

        // Bütün Hanle değerlerini bir set içerisine atalım.
        Set<String> windowHandles = driver.getWindowHandles();  // getwindowHandles bize set döner. Bundan dolayı set.
        System.out.println(windowHandles);

        // Tekrar Coinmarketcap sayfasına geçelim.Title'ın CoinMarketCap içerdiğini test edin.
        driver.switchTo().window(coinmarketHandle);
        SoftAssert assertion=new SoftAssert();
        assertion.assertTrue(driver.getTitle().contains("CoinMarketCap"));
        Thread.sleep(2000);
        assertion.assertAll();

        // // gitHub sayfasına geçelim. Ve repositories sayfasını açalım
        driver.switchTo().window(GitHub);
        driver.findElement(By.xpath("(//a[@data-tab-item='repositories'])[1]")).click();
        Thread.sleep(2000);

    }


    @AfterClass
    public void teaarDown() {
        driver.quit();
    }

}