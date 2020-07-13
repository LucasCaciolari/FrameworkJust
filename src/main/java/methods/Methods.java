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
            ReportCucumber.report(getBrowser(),"Não foi possível inserir o texto no elemento desejado. \n Erro: " + e.getMessage(), true);
            Assert.fail("Não foi possível inserir o texto no elemento desejado. \n Erro: " + e.getMessage());
        }
    }

    public static void clicarElemento(WebElement element)
    {
        try
        {
            element.click();
        }catch (Exception e)
        {
            ReportCucumber.report(getBrowser(),"Não foi possível clicar no elemento desejado. \n Erro: " + e.getMessage(), true);
            Assert.fail("Não foi possível clicar no elemento desejado. \n Erro: " + e.getMessage());
        }
    }

    public static String obterTexto(WebElement element) {
        String texto = null;
        try {
            texto = element.getText();
        } catch (Exception e) {
            ReportCucumber.report(getBrowser(),"Não foi possível obter texto do elemento desejado. \n Erro: " + e.getMessage(), true);
            Assert.fail("Não foi possível obter texto do elemento desejado. \n Erro: " + e.getMessage());
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

    public static void acessar_iFrame(WebElement element){
        try {
            getBrowser().switchTo().frame(element);
        }catch (Exception e){
            ReportCucumber.report(getBrowser(),"Não foi acessar o iFrame desjado \n Erro: " + e.getMessage(), true);
            Assert.fail("Não foi possível acessar o iFrame desejado \n Erro: " + e.getMessage());
        }
    }

    public static void sair_iFrame(){
        try {
            getBrowser().switchTo().defaultContent();
        }catch (Exception e){
            ReportCucumber.report(getBrowser(),"Não foi possível retornar ao primeiro nível da pagina. \n Erro: " + e.getMessage(), true);
            Assert.fail("Não foi possível retornar ao primeiro nível da pagina. \n Erro: " + e.getMessage());
        }
    }
}
