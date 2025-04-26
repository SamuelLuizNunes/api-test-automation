package plataformaFilmes;


import io.restassured.http.ContentType;
import maps.LoginMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.RestUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlataformaFilmesTest {

    @BeforeAll
    public static void validarLoginMap() {
        LoginMap.initLogin();

        RestUtils.post(LoginMap.getLogin(), ContentType.JSON, "auth");

        assertEquals(200, RestUtils.getResponse().statusCode());

        LoginMap.token = RestUtils.getResponse().jsonPath().get("token");

        System.out.println(LoginMap.getLogin());
        System.out.println(LoginMap.token);
    }

    @Test
    public void validarConsultaCategorias() {
        Map<String, String> header = new HashMap<>();
        header.put("Authorization", "Bearer " + LoginMap.token);

        RestUtils.get(header, "categorias");
        assertEquals(200, RestUtils.getResponse().statusCode());

        assertEquals("Terror", RestUtils.getResponse().jsonPath().get("tipo[2]"));

        List<String> listaTipo = RestUtils.getResponse().jsonPath().get("tipo");
        assertTrue(listaTipo.contains("Terror"), "Não foi encontrado a categoria Terror na lista categorias");

    }
}