
package TestNGProjeler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestNGNotlar {
    /* JUnit'in gelişmiş versiyonudur.Test kütüphanesidir. Sadece Java için kullanılır.
    Ayrıntılı bilgilere
    https://testng.org/doc/documentation-main.html adresinden ulaşabilirsiniz.
    * Etkili test framework tasarlamamıza yardımcı olur.
    * priority ve dependsOnMethod'ları en önemli kavramlarıdır.
    * Testcase'leri aynı anda (paralel ve cross browser) çalıştırabilir.
    * TestNG ve JUnit teknik olarak aynı anda eklenebilir fakat karışılığı önlemek adına tavsiye
    edilmez.

    */

    WebDriver driver;

    @BeforeClass
    public void setupTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //● https://coinmarketcap.com/ adresine gidin.
        driver.get("https://coinmarketcap.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @Test(priority = 1)
    public void adresTest() {


        String expectedAdress = "https://coinmarketcap.com/";
        //  1. Test : Coinmarketcap adresine gitttiğinizi test edin
        Assert.assertEquals(expectedAdress, driver.getCurrentUrl());

    }

    @Test(priority = 3)
    public void titleTest() {
        //  2. Test : Coinmarketcap adres titlenı test edin
        String expectedTitle = "Cryptocurrency Prices, Charts And Market Capitalizations | CoinMarketCap";
        Assert.assertEquals(expectedTitle, driver.getTitle());

    }

    @Test(priority = 2)

    public void logoTest() {
        WebElement logo = driver.findElement(By.xpath("//div[@class='sc-73pwfm-0 dugElF cmc-logo cmc-logo--size-large']"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @AfterClass
    public void teardDown() {
        driver.quit();
    }
}
