package TestNGProjeler;
/////*****Selenium öğrencileri için Notlar****///

/*   TestNg’de Actions class’ini kullanarak mouse ve klavye ile yapabilecegimiz
tüm islevleri gerceklestirebiliriz.
 -- Bir form doldurmak için buraya kadar öğrendiğiniz bilgilerle her alan için locate yapıyorduk.
 Bu yöntemle sadece tab yaparak bir çok iş yükünden kurtuluruz.

 -- 3 Aşamada yapılır
    1. Actions class’tan bir object oluştur.
    Actions actions= new Actions(driver);
    2. Üzerinde çalışmak istediğin WebElement öğesini bul.
       WebElement element = driver.findElement(By.id("ID"));
    3. Webelement üzerinde action gerçekleştir.
    actions.click(element).perform( );

*/

import Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/*  Mouse Base Actions
    doubleClick ( ): WebElement’e çift tıklama yapar
    clickAndHold ( ): WebElement üzerinde click basılı olarak bizden komut bekler.
    dragAndDrop ( ): WebElement’i bir noktadan diğerine sürükler ve bırakır
    moveToElement ( ): Mouse’u istedigimiz WebElement’in üzerinde tutar.
    contextClick ( ): Mouse ile istedigimiz WebElement’e sağ tıklama yapar.

     */
public class ActionClass extends TestBase {

    @Test
    public void actionTest() throws InterruptedException {
       // https://www.amazon.com/ a gidelim
       driver.get("https://www.amazon.com/");
       // Ana sayfadaki hello-sign üzerine mause getirin.
        Actions actions=new Actions(driver);
        WebElement sign=driver.findElement(By.xpath("(//a[@class='nav-a nav-a-2   nav-progressive-attribute'])[1]"));
        actions.moveToElement(sign).perform();
        Thread.sleep(3000);
        WebElement create= driver.findElement(By.xpath("//span[text()='Create a List']"));
        actions.click(create).perform();
        Thread.sleep(3000);


    }
}
