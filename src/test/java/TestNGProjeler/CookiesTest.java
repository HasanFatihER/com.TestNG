package TestNGProjeler;

import Utilities.TestBase;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Set;

public class CookiesTest extends TestBase {
        // driver.manage(). yazdığınızda tüm cookies'ler çıkar.

    @Test
    public void cookiesTest() {
        //amazon.com 'a gidelim
        driver.get("https://www.amazon.com/");
        // Tüm cookies'leri  yazdıralım.
        Set<Cookie> cookiesSet = driver.manage().getCookies();
        System.out.println(cookiesSet);
        int count=1;
        for (Cookie w:cookiesSet) {
            System.out.println(count+".cookie : "+w);
            count++;
        }
        // Sayfadaki cookies değerinin 4 den büyük olduğunu test edin.
        SoftAssert softAssert=new SoftAssert();
        // softAssert.assertTrue(count>4, "Cookies sayı testi FAILED");
        softAssert.assertTrue(cookiesSet.size()>4, "Cookies sayı testi FAILED");
        // ismi sp-cdn olan cookie'nin değerinin L5Z9:TR olduğunu kontrol ediniz
        Cookie cookieName=driver.manage().getCookieNamed("sp-cdn");
        softAssert.assertEquals(cookieName.getValue(),"\"L5Z9:TR\"","Test sp-cdn FAILED");
        // ismi hasan, değeri java biliyor olan cookie oluşturun ve listeye ekleyin.
        Cookie hCookie=new Cookie("Hasan","Java biliyor");
        driver.manage().addCookie(hCookie);

        //Yeniden set etmemiz gerek.
        Set<Cookie> cookiesSet2 = driver.manage().getCookies();
        System.out.println(cookiesSet2);
        int count2=1;
        for (Cookie w:cookiesSet2) {
            System.out.println(count2+".cookie : "+w);
            count2++;
        }
        // Hasan cookies listeye eklenmiş mi kontrol et.
        Assert.assertTrue(cookiesSet2.contains(hCookie),"Hasan cookie Test FAILED");
        // Hasan cookies silin ve silindiğini test edin.
        driver.manage().deleteCookieNamed("Hasan");
        //Cookies'leri tekrar çağırmak gerekir.İki şekilde de yazabilirsiniz.
        //Assert.assertFalse(driver.manage().getCookies().contains(hCookie),"Hasan cookie silinmedi- Test FAILED");
        Set<Cookie> cookiesSet3 = driver.manage().getCookies();
        Assert.assertFalse(cookiesSet3.contains(hCookie),"Hasan cookie silinmedi- Test FAILED");
        softAssert.assertAll();
        //Tüm cookies'leri silin. Silindiğini test edin.
        driver.manage().deleteAllCookies();

       Assert.assertTrue(driver.manage().getCookies().isEmpty());
        System.out.println(driver.manage().getCookies());



    }

}
