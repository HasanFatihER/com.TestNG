package TestNGProjeler;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileExistTest {
    @Test
    public void fileExistTest(){
        System.out.println(System.getProperty("user.home"));

        /*
        Selenium ile windows uygulamalarını test edemiyoruz.
        Ama test etmek için JAVA kullanabiliriz.

        Müşterek bir program çalıması yaptığınızda ya da seize verilen bir dosyada
        arama yapaarken dosya yolunu doğru seçmeniz gerekir. Burada iki kod parçası var.
         -- user.home Her bilgisayarda kuruluma göre şekillenen kısım.
         -- user/home/(.... devamındaki dosya yolu)
            System.getProperty ( "user.dir"); icinde bulunulan klasörün yolunu (Path) verir
            System.getProperty ( "user.home"); bilgisayarimizda bulunan user klasörünü verir
            Files.exists (Paths.get (filePath)); Bilgisayarınızda dosyanın olup olmadığını kontrol eder

         */
        String dosya=System.getProperty("user.home")+"/Downloads/IMG_0987.JPG";
        // Downloads klasöründeki resim.
        System.out.println(dosya);
        System.out.println(Files.exists(Paths.get(dosya)));
        System.out.println(System.getProperty("user.dir")); // Şuanki projenin yolunu gösterir.
        // projenizde pom.xml olup olmadığını test ediniz.
        // user.dir --> bize /home/hasan/IdeaProjects/com.TestNG verir. Buna pom.xml
        String pom=System.getProperty("user.dir")+"/pom.xml";
        Assert.assertTrue(Files.exists (Paths.get (pom)));
    }

}
