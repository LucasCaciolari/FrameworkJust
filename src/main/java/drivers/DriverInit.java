package drivers;

import dataProviders.ConfigFileReader;
import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class DriverInit {

    public static WebDriver driver = null;

    public DriverInit(){

    }

    public void inicializarDriver(String navegador){
        if (navegador.toLowerCase().equals("chrome") && driver == null){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/java/web_drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }else if (navegador.toLowerCase().equals("firefox")){
            System.setProperty("webdriver.gecko.driver", "C:/Users/Lucas/Documents/Automacao/FrameworkAutomacao/FrameworkAutomacao/src/test/java/web_drivers/geckodriver.exe");
            DesiredCapabilities capabilities= DesiredCapabilities.firefox();
            capabilities.setCapability("marionette", true);
            driver = new FirefoxDriver(capabilities);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
    }

    public static WebDriver getBrowser(){
        if (driver == null){
            return driver;
        }
        else{
            return driver;
        }
    }

    public void acessarPagina(String url){
        getBrowser().get(url);
    }

    public static void closeBrowser() throws Exception{
        if (driver == null) {
            return;
        }
        driver.quit();
        driver = null;
    }
}
