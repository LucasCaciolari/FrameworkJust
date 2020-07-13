package hooks;

import com.cucumber.listener.Reporter;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import managers.FileReaderManager;
import report.ReportCucumber;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static drivers.DriverInit.closeBrowser;
import static drivers.DriverInit.getBrowser;

public class Hook {

    @Before
    public void BeforeSteps() {
         try{
             Reporter.getExtentReport().setGherkinDialect(FileReaderManager.getInstance().getConfigReader().getReportLanguage());
         }catch (UnsupportedEncodingException e){
             Logger logger = Logger.getLogger("ImfoLogging");
             logger.log(Level.SEVERE, e.getMessage());
         }
    }

    @After(order = 1)
    public void afterScenario(Scenario scenario) {
        String msg = scenario.getName();
        if (scenario.isFailed()) {
            ReportCucumber.report(getBrowser(),"Erro no step: " + msg, true);
        }
    }

    @After(order = 0)
    public void AfterSteps() throws Exception {
        closeBrowser();
    }
}
