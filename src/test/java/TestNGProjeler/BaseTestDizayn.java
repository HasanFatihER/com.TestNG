package TestNGProjeler;

import Utilities.TestBase;
import org.testng.annotations.Test;

public class BaseTestDizayn extends TestBase {
    /* testNG'nin özelliği olarak @Test kodunu gördüğünde öncelikle @Before... koduna bakar ve
    * ilk onu çalıştırmak ister.. Bu class'ta olmadığı için parent'a gider. Test bittikten sonra da
    * @After'ı arar. O da olmadığı için yine parent'a gider.
    *
    * Bir teknik olarak @Before ve @After methodları için de bir parent oluşturabiliriz. Hangi
    * yöntem test için uygun olursa onu extends ederiz.

    * TestBase class’i abstract da yapabiliriz. Tek avantajı Abstract class'lardan obje oluşturulamaz
    bu olur. 

    * */

    @Test
    public void baseTest(){
        driver.get("https://www.amazon.com/");
    }

}
