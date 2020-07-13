package methods;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import report.ReportCucumber;

import static drivers.DriverInit.getBrowser;

public class Methods {
    public static void inserirTexto(WebElement element, String texto){
        try{
            element.sendKeys(texto);
        }catch (Exception e){
            ReportCucumber.report(getBrowser(),"Não foi possível inserir o texto no elemento: " + element.getLocation(), true);
            Assert.fail("Não foi possível inserir o texto no elemento: " + element.getLocation());
        }
    }

    public static void clicarElemento(WebElement element)
    {
        try
        {
            element.click();
        }catch (Exception e)
        {
            ReportCucumber.report(getBrowser(),"Não foi possível clicar no elemento: " + element.getLocation(), true);
            Assert.fail("Não foi possível clicar no elemento: " + element.getLocation());
        }
    }

    public static String obterTexto(WebElement element) {
        String texto = null;
        try {
            texto = element.getText();
        } catch (Exception e) {
            ReportCucumber.report(getBrowser(), "Não foi possível obter texto do elemento: " + element.getLocation(), true);
            Assert.fail("Não foi obter texto do elemento: " + element.getLocation());
        }

        return texto;
    }

    public static boolean validarSeOWebElementExiste(WebElement element){
        try {
            element.getAttribute("class");
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }
}
