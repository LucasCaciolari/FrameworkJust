package page_factory;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static drivers.DriverInit.getBrowser;
import static methods.Methods.*;

public class PFGoogle {

    public PFGoogle(){
        PageFactory.initElements(getBrowser(), this);
    }

    @FindBy(name = "q")
    private WebElement edtBarraDePesquisa;
    @FindBy(name = "btnK")
    private WebElement btnPesquisaGoogle;
    @FindBy(css = "div.kno-ecr-pt > span")
    private WebElement txtPesquisa;



    public void realizarPesquisa(String texto)
    {
        inserirTexto(edtBarraDePesquisa, texto);
        clicarElemento(btnPesquisaGoogle);
    }

    public void validarPesquisa(String texto)
    {
        Assert.assertTrue((obterTexto(txtPesquisa).contains(texto)));
    }
}
