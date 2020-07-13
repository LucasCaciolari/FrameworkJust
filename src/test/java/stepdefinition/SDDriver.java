package stepdefinition;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Quando;
import drivers.DriverInit;

public class SDDriver {

    @Dado("^a abertura do \"([^\"]*)\"$")
    public void aAberturaDo(String navegador) throws Throwable {
        DriverInit driverInit = new DriverInit();

        driverInit.inicializarDriver(navegador);
    }

    @Quando("^acesso o dealer: \"([^\"]*)\"$")
    public void acessoAUrl(String url) throws Throwable {
        DriverInit driverInit = new DriverInit();

        driverInit.acessarPagina(url);
    }
}
