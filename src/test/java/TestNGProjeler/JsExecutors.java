package TestNGProjeler;

import Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
/*  Javascript executors selenium'un yetersiz kalddığı noktalarda yardım aldığımız
 kod parçacıklarıdır.
    2 tane sık kullanılan methodlar
    -- click() ve scrollIntoView(true)
    Click-tıklama, scroolIntoWiev ise page down locate ettiğimiz yere kadar aşağı inmek için kullanılır.

    Javascript executors'ı kullanmak için 3 adımı uyguluyoruz.

    1.JavascriptExecutor jsExecutors = (JavascriptExecutor) driver; JavascriptExecutor objesi oluştur.
    2. Webelementini locate et.
    3.executeScript() methodunu kullan.
    Parametreler String olduğu için 1 harf hatasında bile kod hata verir. Yazıma dikkat etmelisiniz.
    

  */

public class JsExecutors extends TestBase {


    @Test
    public void JsExecutorsTest() throws InterruptedException {

        driver.get("https://amazon.com");

        JavascriptExecutor jsExecutors = (JavascriptExecutor) driver;

        WebElement customerService= driver.findElement(By.xpath("(//a[@class='nav-a  '])[2]"));

        jsExecutors.executeScript("arguments[0].click()",customerService);
        Thread.sleep(2000);


        WebElement amazonAssistant= driver.findElement(By.xpath("(//a[@class='nav_a'])[25]"));
        // Sayfanın sağ altında amazonAssistant'ı bulmasını sağlayalım.
        jsExecutors.executeScript("arguments[0].scrollIntoView(true)",amazonAssistant);
        Thread.sleep(3000);
        jsExecutors.executeScript("arguments[0].click()",amazonAssistant);
    }
}
