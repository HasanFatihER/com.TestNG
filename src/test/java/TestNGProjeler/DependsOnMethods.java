package TestNGProjeler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.time.Duration;
/* DependsOnMethod'lardan her hangi bir problem oluştuğunda devamındaki testleri ignore eder.
*
*  */
public class DependsOnMethods {

    WebDriver driver;
    WebElement dropDown;
    Select option;

    @Test
    public void setup() {
        // https://www.trendyol.com/ adresine gidin.
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.trendyol.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    // Sadece mainTest çalıştırıldığında depensOn'dan kaynaklı olarak setup testte çalışacaktır.
    @Test(dependsOnMethods = "setup")
    public void mainTest() {
        // Trendyol sitesine gittiğimizi test edelim
        Assert.assertEquals("https://www.trendyol.com/", driver.getCurrentUrl(), "Main TEST FAILED");
    }
    // Burada sadece logoTest'i çalıştırırsak 1.teste gitmez. Üst üste 2 dependsOnMethod çalışabilir.
    @Test(dependsOnMethods = "mainTest")
    public void logoTest() {
        driver.findElement(By.xpath("//img[@style='width:111px;height:100%;margin-bottom:8px']")).isDisplayed();
    }

    @Test (dependsOnMethods = "setup")
    public void titleTest() {
        Assert.assertTrue(driver.getTitle().contains("Trend"),"titleTest : FAILED");

    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
