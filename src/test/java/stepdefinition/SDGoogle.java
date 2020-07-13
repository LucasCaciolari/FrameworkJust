package stepdefinition;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import drivers.DriverInit;
import page_factory.PFGoogle;

public class SDGoogle {
    private DriverInit driverInit = new DriverInit();
    private PFGoogle google = new PFGoogle();

    @Quando("^acesso a url: \"([^\"]*)\"$")
    public void acessoAUrl(String url) throws Throwable {
        driverInit.acessarPagina(url);
    }

    @E("^pesquiso por \"([^\"]*)\"$")
    public void pesquisoPor(String texto) throws Throwable {
        google.realizarPesquisa(texto);
    }

    @Entao("^valido se a pesquisa foi realizada com a palavra: \"([^\"]*)\" com sucesso$")
    public void validoSeAPesquisaFoiRealizadaComAPalavraComSucesso(String texto) throws Throwable {
        google.validarPesquisa(texto);
    }
}
