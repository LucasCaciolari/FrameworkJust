package report;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ReportCucumber {

    public static void report(String msg){
        Reporter.addStepLog("<textarea style=\"margin: 0px; width: 593px; height: 27px;\">"+ msg + "</textarea>");
    }

    public static void report(WebDriver driver, String msg, boolean screenshot){
        Reporter.addStepLog("<textarea style=\"margin: 0px; width: 593px; height: 27px;\">"+ msg + "</textarea>");

        if (screenshot){
            printExtent(driver);
        }
    }

    private static void printExtent(WebDriver driver) {
        Reporter.addStepLog(printWebDriver(driver));
    }

    private static String printWebDriver(WebDriver driver){
        String screenshotPath = ScreenShots.image64(driver);

        return "<div align=\"right\" href=\"data:image/png;base64,"+ screenshotPath +"\" data-featherlight=\"image\"> <img src=\"data:image/png;base64," + screenshotPath +"\" height=\"15%\" width=\"15%\"/> </div>";
    }


}
