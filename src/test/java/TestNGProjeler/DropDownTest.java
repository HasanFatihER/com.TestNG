package TestNGProjeler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DropDownTest {

    /*  ● Bir class oluşturun: DropDownTest
        ● https://the-internet.herokuapp.com/dropdown adresine gidin.
        1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        4.Tüm dropdown değerleri(value) yazdırın
        5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
        False yazdırın.

    */


    WebDriver driver;

    @BeforeClass
    public void setup() {
        // https://the-internet.herokuapp.com/dropdown adresine git.
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @Test
    public void dropDownTest()  {
        //DropDown locate edelim ve selecet objesi oluştualım. Select selenium'dan gelir.
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        Select option = new Select(dropDown);
        // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        option.selectByIndex(1);  // Bu değeri direk yazdıramayız. Bu method sadece seçim içindir ve void'tir.

        System.out.println(option.getFirstSelectedOption().getText());
        // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın.
        option.selectByValue("2");
        System.out.println(option.getFirstSelectedOption().getText());
        // 3. Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        option.selectByVisibleText("Option 1");
        System.out.println(option.getFirstSelectedOption().getText());
        // 4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> list=new ArrayList<>();
        list=option.getOptions();
        for (WebElement w: list) {
            System.out.println(w.getText());
        }

        // 5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
            //False yazdırın.

            int expectedSize=4;
        Assert.assertEquals(list.size(),expectedSize,"False");


    }


   @AfterClass
    public void tearDown() {
        driver.quit();
    }

}


