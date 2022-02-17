package TestNGProjeler;

import Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MouseActions extends TestBase {
    /* Yeni bir class olusturalim: MouseActions
    1- https://demoqa.com/droppable adresine gidelim
    2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin */
    @Test
    public  void mouseTest() throws InterruptedException {
        // 1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        Actions actions=new Actions(driver);
        WebElement drag=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop=driver.findElement(By.xpath("//div[@id='droppable']"));
       // 2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        actions.dragAndDrop(drag,drop).perform();
        Thread.sleep(5000);

       // 3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(drop.getText(),"Dropped!","Dropped Test FAILED");
        softAssert.assertAll();
        System.out.println(drop.getText());


    }
}
