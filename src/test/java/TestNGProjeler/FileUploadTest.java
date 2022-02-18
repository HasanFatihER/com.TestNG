package TestNGProjeler;

import Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest extends TestBase {

    @Test
    public void uploadTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement fileChoose = driver.findElement(By.id("file-upload"));
        // Choose file 'ı locate edelim.
        Actions actions = new Actions(driver);
        actions.click(fileChoose).perform();
        Thread.sleep(1000);
        // Hangi dosyayı yükleyeceksek dosya yolunu ayarlayalım.
        String uploadFile = System.getProperty("user.home") + "/Downloads/text.txt";
        fileChoose.sendKeys(uploadFile);

        driver.findElement(By.id("file-submit")).click();
        // Yüklemenin gerçekleştiğini test edelim.
        Thread.sleep(1000);
        WebElement uploadData= driver.findElement(By.id("uploaded-files"));
        Assert.assertTrue(uploadData.getText().equals("text.txt"),"Upload Test FAILED");



    }
}
