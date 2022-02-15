package TestNGProjeler;
// Selenium öğrenmek isteyenler için örnek çalışmalardır.
 /* Assertion-verification yani doğrulamadır.
    * Hard ve soft assertion olarak 2 tanedir. Hard assertion JUnit ile aynıdır.
    * Hard Assertion'lar
    -- Assert.assertEquals()
    -- Assert.assertTrue()
    -- Assert.assertFalse()
    * SoftAssertion
    -- softAssert kullandigimizda, assert FAILED olsa bile test devam eder. İf else statement gibi.
    3 adımda softassert yapılır
    * 1- SoftAssert objesi olustur.
        SoftAssert softAssert = new SoftAssert( );
      2-Verification’lari yap.
        softAssert.assertTrue( );
        softAssert.assertFalse( );
      3-SoftAssert’in durumu raporlamasini isteyelim
        softAssert.assertAll();
     * Görüldüğü gibi tüm assertion'lar alt alta yazılır. softAssert.assertAll(); bu koda kadar
     çalışmaya devam eder. Eğer her hangi birinde hata varsa son noktaya kadar bekleyecek.
     Bundan dolayı her bir teste mesaj yazmak çok önemli.
     * Hata varsa softAssert.assertAll(); komutundan sonra program çalışmayı durdurur.

     */

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
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class SoftAssertion {

    int a =10;
    int b=20;
    int c=45;
    int d=100;


    @Test
    public void Test1() {
        SoftAssert assertion=new SoftAssert();


        assertion.assertEquals(a,b,"Eşitlik Failed"); // hata verir
        assertion.assertTrue(a>b,"a>b Failed"); // Hata verir
        assertion.assertFalse(c<b,"c<b Failed");
        assertion.assertTrue(d>b,"d>b Failed");
        assertion.assertAll();
        System.out.println("Bu satır çalışmaz. Çünkü  assertion.assertAll() exception fırlatır.");
    }


}



