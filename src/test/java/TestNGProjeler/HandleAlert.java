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

// Selenium öğrencileri için örnekler
/* Alert kullanıcıya bilgi vermek ya da bir işlemi gerçekleştirme izni istemek için kullanılan
     bir mesaj kutusudur.

    *  HTML Alerts ve Javascript Alert'lar vardır. HTML Alerts  click() ya da seçim ile atlanabilir.

    * Javascript Alert'lar inspect yapilamaz, ekstra islem gerekir.

    *   Javascript Alert'lar
        1.Simple Alert : Bu basit alert ekranda bazı bilgiler veya uyarılar
        görüntüler. Ok denilerek kapatilir
        2. Confirmation Alert : Bu onay uyarısı bir tür işlem yapma izni ister. Alert
        onaylaniyorsa OK, onaylanmiyorsa Cancel butonuna bas gibi işlem talep eder.
        3.Prompt Alert : Bu Prompt Uyarısı kullanıcıdan bazı bilgiler ister ve
        sendkeys ("input….") kullanmak gerekir.
            */
    /*
    * Handle Allert Methodları
    * switchTo() method alert'lere geçiş imkanı sunar.
        accept( ) => OK seçmek-kabul etmek.
        driver.switchTo( ).alert( ) .accept( );
        dismiss() => Cancel-Onaylamamak için kullanılır.
        driver.switchTo( ).alert( ) .dismiss( );
        getText() => Uyarıdaki(alert) mesajı almak için.
        driver.switchTo( ).alert( ) .getText( );
        sendKeys(“Text”) =>  Text kutusuna bilgi girmek için
        driver.switchTo( ).alert( ) .sendKeys("Text");

         */
public class HandleAlert {
    /* https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        Bir metod olusturun: acceptAlert
        1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        “You successfully clicked an alert” oldugunu test edin.
        Bir metod olusturun: dismissAlert
        2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        “successfuly” icermedigini test edin.
        Bir metod olusturun: sendKeysAlert
        3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.*/
    WebDriver driver;
    WebElement dropDown;
    Select option;

    @Test
    public void setup() {
        // https://the-internet.herokuapp.com/javascript_alerts.
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(dependsOnMethods = "setup")
    public void acceptAlert() throws InterruptedException {
        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        // “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        String expectedMessage = "You successfully clicked an alert";
        WebElement actualMessage = driver.findElement(By.id("result"));
        Assert.assertEquals(actualMessage.getText(), expectedMessage, "ExpectedMessage is FAILED");
        Thread.sleep(2000);
    }
        @Test(dependsOnMethods = "acceptAlert")
        public void dismissAlert () throws InterruptedException {
            /*2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
             “successfuly” icermedigini test edin. */
            driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
            Thread.sleep(2000);
            driver.switchTo().alert().dismiss();
            String expectedMessage = "successfuly";
            WebElement actualMessage = driver.findElement(By.id("result"));
            Assert.assertFalse(actualMessage.getText().contains(expectedMessage), "ExpectedMessage is FAILED");
            Thread.sleep(2000);


        }
    @Test(dependsOnMethods = "dismissAlert")
    public void sendKeysAlert () throws InterruptedException {
            /*Bir metod olusturun: sendKeysAlert
        3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.*/
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("Hasan");

        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        String expectedMessage = "Hasan";
        WebElement actualMessage = driver.findElement(By.id("result"));
        Assert.assertTrue(actualMessage.getText().contains(expectedMessage), "ExpectedMessage is FAILED");
        Thread.sleep(2000);


    }
        @AfterClass
        public void tearDown() {
            driver.quit();
        }

}