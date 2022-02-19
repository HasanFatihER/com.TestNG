package TestNGProjeler;

import Utilities.ScreenShotBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class ScreenShotTest extends ScreenShotBase {

    @Test
    public void screenShotTest() throws IOException {
        driver.get("https://github.com/HasanFatihER");
        screenShot();

    }
}
