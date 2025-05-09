package steps;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import org.junit.Assert;
import utils.RestUtils;

import java.util.ArrayList;

public class GenericSteps {

    @Entao("valido que recebo status {int} no response")
    public void validoQueReceboStatusNoResponse(int status) {
        Assert.assertEquals(status, RestUtils.getResponse().statusCode());
    }

    @Entao("valido que no campo {string} possui o valor {string}")
    public void validoQueNoCampoPossuiOValor(String key, String value) {
        Assert.assertEquals(value, RestUtils.getResponse().jsonPath().get(key));
    }

    @E("valido que recebo uma lista vazia o response")
    public void validoQueReceboUmaListaVaziaOResponse() {
        Assert.assertEquals(new ArrayList<>(0), RestUtils.getResponse().jsonPath().get());
    }
}
