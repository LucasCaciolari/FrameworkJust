package methods;

import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import report.ReportCucumber;

import java.util.List;

import static drivers.DriverInit.getBrowser;

public class Methods {
    public static void inserirTexto(@NotNull WebElement element, @NotNull String texto){
        try{
            element.sendKeys(texto);
            ReportCucumber.report("Texto inserido com sucesso.");
        }catch (Exception e){
            ReportCucumber.report(getBrowser(),"Nao foi possivel inserir o texto no elemento desejado. \n Erro: " + e.getMessage(), true);
            Assert.fail("Nao foi possivel inserir o texto no elemento desejado. \n Erro: " + e.getMessage());
        }
    }

    public static void clicarElemento(@NotNull WebElement elemento)
    {
        try
        {
            elemento.click();
            ReportCucumber.report("Elemento foi clicado com sucesso");
        }catch (Exception e)
        {
            ReportCucumber.report(getBrowser(),"Nao foi possivel clicar no elemento desejado. \n Erro: " + e.getMessage(), true);
            Assert.fail("Nao foi possivel clicar no elemento desejado. \n Erro: " + e.getMessage());
        }
    }

    public static String obterTexto(@NotNull WebElement elemento) {
        String texto = null;
        try {
            texto = elemento.getText();
            ReportCucumber.report("Texto obtido com sucesso.");
        } catch (Exception e) {
            ReportCucumber.report(getBrowser(),"Nao foi possivel obter texto do elemento desejado. \n Erro: " + e.getMessage(), true);
            Assert.fail("Nao foi possivel obter texto do elemento desejado. \n Erro: " + e.getMessage());
        }

        return texto;
    }

    public static boolean validarSeOWebElementExiste(@NotNull WebElement elemento){
        try {
            elemento.getAttribute("class");
            ReportCucumber.report("O elemento procurado existe.");
            return true;
        }catch (NoSuchElementException e){
            ReportCucumber.report("O elemento procurado nao existe.");
            return false;
        }
    }

    public static void acessar_iFrame(@NotNull WebElement elemento){
        try {
            getBrowser().switchTo().frame(elemento);
            ReportCucumber.report("iFrame acessado com sucesso");
        }catch (Exception e){
            ReportCucumber.report(getBrowser(),"Nao foi possivel acessar o iFrame desjado \n Erro: " + e.getMessage(), true);
            Assert.fail("Nao foi possivel acessar o iFrame desejado \n Erro: " + e.getMessage());
        }
    }

    public static void sair_iFrame(){
        try {
            getBrowser().switchTo().defaultContent();
            ReportCucumber.report("Frame padrao acessado com sucesso.");
        }catch (Exception e){
            ReportCucumber.report(getBrowser(),"Não foi possivel retornar ao primeiro nivel da pagina. \n Erro: " + e.getMessage(), true);
            Assert.fail("Nao foi possivel retornar ao primeiro nivel da pagina. \n Erro: " + e.getMessage());
        }
    }

    public static void percorrerListaDeElementosEclicarNoTexto(@NotNull List<WebElement> listaDeElementos, @NotNull String texto){
        try{
            for (WebElement elemento : listaDeElementos){
                if (elemento.equals(texto)){
                    clicarElemento(elemento);
                    ReportCucumber.report("Texto: <"+texto+"> encontrado e clicado com sucesso.");
                }
            }
        }catch (Exception e){
            ReportCucumber.report(getBrowser(),"Nao foi possivel clicar no texto: <"+texto+"> desejado \n Erro: " + e.getMessage(), true);
            Assert.fail("Nao foi possivel clicar no texto: <"+texto+"> desejadoo \n Erro: " + e.getMessage());
        }
    }

    public static void selecionarSelectPorTexto(@NotNull WebElement elemento, @NotNull String textoVisivel){
        try {
            Select select = new Select(elemento);
            select.selectByVisibleText(textoVisivel);
            ReportCucumber.report("Select com o texto: <"+textoVisivel+"> selecionado com sucesso");
        }catch (Exception e){
            ReportCucumber.report(getBrowser(),"Nao foi possivel selecionar o texto: <"+textoVisivel+"> desejado \n Erro: " + e.getMessage(), true);
            Assert.fail("Nao foi possivel selecionar o texto: <"+textoVisivel+"> desejadoo \n Erro: " + e.getMessage());
        }
    }

    public static void selecionarSelectPorIndex(@NotNull WebElement elemento, @NotNull int index){
        try {
            Select select = new Select(elemento);
            select.selectByIndex(index);
            ReportCucumber.report("Index: <"+index+"> selecionado com sucesso");
        }catch (Exception e){
            ReportCucumber.report(getBrowser(),"Nao foi possivel selecionar o index: <"+index+"> desejado \n Erro: " + e.getMessage(), true);
            Assert.fail("Nao foi possivel selecionar o index: <"+index+"> desejadoo \n Erro: " + e.getMessage());
        }
    }
}