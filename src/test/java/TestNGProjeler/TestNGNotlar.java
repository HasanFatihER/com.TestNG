
package TestNGProjeler;
        import io.github.bonigarcia.wdm.WebDriverManager;
        import org.checkerframework.checker.units.qual.A;
        import org.openqa.selenium.By;
        import org.openqa.selenium.Keys;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.testng.Assert;
        import org.testng.annotations.AfterClass;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.Test;
        import java.time.Duration;
 public class TestNGNotlar {
     //● Bir class oluşturun: DependsOnTest

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

     @Test(priority =1)
     public void adresTest() {


         String expectedAdress = "https://coinmarketcap.com/";
         //  1. Test : Coinmarketcap adresine gitttiğinizi test edin
         Assert.assertEquals(expectedAdress, driver.getCurrentUrl());

     }
     @Test (priority = 3)
     public void titleTest(){
         //  1. Test : Coinmarketcap adres titlenı test edin
        String expectedTitle="Cryptocurrency Prices, Charts And Market Capitalizations | CoinMarketCap";
        Assert.assertEquals(expectedTitle,driver.getTitle());

     }

     @Test (priority = 2)

     public void logoTest(){
        WebElement logo=driver.findElement(By.xpath("//div[@class='sc-73pwfm-0 jZUHEB cmc-logo cmc-logo--size-large']"));
        Assert.assertTrue(logo.isDisplayed());
     }
     @AfterClass
     public void teardDown(){
         driver.quit();
     }
 }
