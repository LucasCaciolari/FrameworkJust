package report;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShots {

    public ScreenShots(){

    }

    public static String image64(WebDriver driver){
        return driver != null ? (String)((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64) : null;
    }
}
