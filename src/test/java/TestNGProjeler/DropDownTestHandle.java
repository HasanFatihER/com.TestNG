package TestNGProjeler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

/*
        * https://www.amazon.com/ adresine gidin.
        - Test 1
        Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
        oldugunu test edin
        -Test 2
        1. Kategori menusunden Books secenegini secin
        2. Arama kutusuna Java yazin ve aratin
        3. Bulunan sonuc sayisini yazdirin
       */

public class DropDownTestHandle {
    WebDriver driver;
    WebElement dropDown;
    Select option;

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
    public void Test1() {
        dropDown = driver.findElement(By.id("searchDropdownBox"));
        option = new Select(dropDown);
        Assert.assertEquals(option.getOptions().size(), 45, "TEST! FAILED");
    }

    @Test
    public void Test2() {
        //1. Kategori menusunden Books secenegini secin
        dropDown = driver.findElement(By.id("searchDropdownBox"));
        option = new Select(dropDown);
        option.selectByVisibleText("Books");
        //2. Arama kutusuna Java yazin ve aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);

        //3. Bulunan sonuc sayisini yazdirin
        System.out.println(driver.findElement(By.xpath("(//span[@dir='auto'])[1]")).getText());


    }

   @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
