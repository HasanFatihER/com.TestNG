package TestNGProjeler;

import Utilities.TestBase;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaFaker extends TestBase {
    /* Öncelikle https://mvnrepository.com/ adresinden javafaker dependency'leri pom.xml sayfasına ekleyin.
      --  Faker class’i fake değerler üretmemiz için kullanılan kütüphanedir.
      --  Faker class’indan bir obje uretip,methodları kullanılır.
    */

     /*
        "https://facebook.com" Adresine gidin
        “create new account” butonuna basin
        “firstName” giris kutusuna bir isim yazin
        “surname” giris kutusuna bir soyisim yazin
        “email” giris kutusuna bir email yazin
        “email” onay kutusuna emaili tekrar yazin
        Bir sifre girin
        Tarih icin gun secin
        Tarih icin ay secin
        Tarih icin yil secin
        Cinsiyeti secin
        Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        Sayfayi kapatin

        */
    @Test
    public void facebookTest() throws InterruptedException {
        //"https://facebook.com" Adresine gidin
        driver.get("https://facebook.com");
        //“create new account” butonuna basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        // Bilgileri doldurun
       WebElement isim= driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        Actions actions=new Actions(driver);
       // isim.click(); ya da aşağıdaki gibi
        Faker faker=new Faker();
        // E-mail'i 2 defa sorduğu için bir değişkene atamalıyız.
        String email=faker.internet().emailAddress("12d");
        actions.click(isim).sendKeys(faker.name().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .sendKeys("9"+Keys.ENTER)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.ENTER)
                .sendKeys("jan"+Keys.ENTER)
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .sendKeys("1991"+Keys.ENTER)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.RIGHT)
                .sendKeys(Keys.ENTER)
                .click()
                .perform();
        // Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
            WebElement cinsiyetE=driver.findElement(By.xpath("//input[@value='2']"));
            Assert.assertTrue(cinsiyetE.isSelected());
        WebElement cinsiyetK=driver.findElement(By.xpath("//input[@value='1']"));
         Assert.assertFalse(cinsiyetK.isSelected());

        //Sayfayi kapatin
        driver.close();
        Thread.sleep(5000);
    }


}
