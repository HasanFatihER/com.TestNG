package TestNGProjeler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class HandleDropDown {
    /* Aşağı açılır pencelere DropDown denir. Dropdown pencereleri genelde selectle başlar ve
     option'lar vardır.

       DropDown pencerelerin Locate işlemi 3 adımda yapılır.

       1- Dropdown menuyu herhangi bir locator ile locate et.
       2- Select sınıfından obje oluştur ve drodown webelementini parametre olarak gönder.
       3- Dropdown menusundeki elementleri Select Class’indan kullanacagimiz 3 yöntemi kullan.

        -- Index kullanarak selectByIndex();
        -- Deger kullanarak selectByValue();
        -- Gorunen degerini kullanarak selectByVisibleText();

     */
    WebDriver driver;

    @BeforeClass
    public void setup() {
        // "https://www.amazon.com/" adresine git.
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @Test
    public void dropDownTest() throws InterruptedException {
        //DropDown locate edelim ve selecet objesi oluştualım. Select selenium'dan gelir.
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Select option = new Select(dropDown);
        // DropDown'daki seçenekleri 3 yöntemle bulalım.
        option.selectByVisibleText("Books");
        Thread.sleep(2000);
        option.selectByValue("search-alias=baby-products-intl-ship");
        Thread.sleep(2000);
        option.selectByIndex(7);
        // Select için kullandığımız bu methodlar void'dir. Hiç bir değer dönmezler.
        Thread.sleep(2000);

        // Tüm seçenekleri yazdırma
        List<WebElement> options=new ArrayList<>(); {
            options=option.getOptions();
            for (WebElement w:options ) {
                System.out.println(w.getText());
            }

            }
        }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
