package utilities;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

public class ScreenshotUtil {
    public static String captureScreenshot(WebDriver driver, String screenshotName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        String path = "test-output/screenshots/" + screenshotName + ".png";
        File dest = new File(path);
        FileUtils.copyFile(src, dest);
        return path;
    }
}
