package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;
import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class ScreenShotBase {
    protected WebDriver driver;

    @BeforeClass
    public void screenShotBase(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();


    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public void screenShot() throws IOException {
        TakesScreenshot screenshot=(TakesScreenshot)driver;
        //Aynı isimle kaydetmemesi adına bu şekilde çözüm buluyoruz.
        String scrname=new SimpleDateFormat("yy/MM/dd/hh/mm").format(new Date());
        File screenShotsFile=new File("/home/hasan/IdeaProjects/com.TestNG/src/test/java/Screenshots/"+scrname+".png/");
        File tasiyiciDosya=screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tasiyiciDosya,screenShotsFile);
    }
}
