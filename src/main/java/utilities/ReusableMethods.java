package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

    public class ReusableMethods {


        public static void waitFor(int seconds) {
            try {
                Thread.sleep(seconds * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Verilen WebElement’in sayfada görünür olmasını bekler. Özellikle senkronizasyon sorunlarını çözmek için.

        public static void waitForVisibility(WebElement element, int timeoutInSeconds) {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeoutInSeconds));
            wait.until(ExpectedConditions.visibilityOf(element));
        }


        // Testlerde hata olduğunda ekran görüntüsü almanı sağlar.

        public static String getScreenshot(String name) {
            String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            File source = ts.getScreenshotAs(OutputType.FILE);
            String target = System.getProperty("user.dir") + "/screenshots/" + name + date + ".png";
            try {
                File finalDestination = new File(target);
                FileUtils.copyFile(source, finalDestination);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return target;
        }

        // secondTabSwitch bu method, yeni açılan sekmeye geçiş yapmanı aynı zamanda bir link tıklanınca yeni sekme açıldığında onu kontrol etmek için kullanılabilir.

        public static void switchToSecondTab() {
            List<String> windowHandles = new ArrayList<>(Driver.getDriver().getWindowHandles());
            if (windowHandles.size() > 1) {
                Driver.getDriver().switchTo().window(windowHandles.get(1));
            } else {
                System.out.println("İkinci bir sekme bulunamadı.");
            }
        }


























    }


