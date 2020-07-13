package runner;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import managers.FileReaderManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"features/Google.feature"},
        glue = {"stepdefinition", "hooks"},
        tags = {"@All"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",
                "json:target/cucumber.json"}
)

public class RunTest {

    @BeforeClass
    public static void setUp(){
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        String reportPath = "target/cucumber-reports/report.html";
        extentProperties.setReportPath(reportPath);
    }

    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
    }
}
