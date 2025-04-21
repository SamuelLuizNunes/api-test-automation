package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

public class RestUtils {

    private static Response response;

    public static Response getResponse() {
        return response;
    }

    public static void setBaseURI(String uri){
        RestAssured.baseURI = uri;
    }

    public static String getBaseURI(){
        return RestAssured.baseURI;
    }

    public static void post(Object json, ContentType contentType, String endpoint) {
        response = RestAssured.given()
                .relaxedHTTPSValidation()
                .contentType(contentType)
                .body(json)
                .when()
                .post(endpoint)
                .thenReturn();
    }

    public static void post(Map<String, String> header, Object json, ContentType contentType, String endpoint) {
        response = RestAssured.given()
                .relaxedHTTPSValidation()
                .contentType(contentType)
                .headers(header)
                .body(json)
                .when()
                .post(endpoint)
                .thenReturn();
    }

    public static void get(Map<String, String> header, String endpoint) {
        response = RestAssured.given()
                .relaxedHTTPSValidation()
                .headers(header)
                .when()
                .get(endpoint)
                .thenReturn();
    }

    public static void get(Map<String, String> header, Map<String, Object> param, String endpoint) {
        response = RestAssured.given()
                .relaxedHTTPSValidation()
                .headers(header)
                .params(param)
                .when()
                .get(endpoint)
                .thenReturn();
    }

    public static void put(Map<String, String> header, Object json, ContentType contentType, String endpoint) {
        response = RestAssured.given()
                .relaxedHTTPSValidation()
                .contentType(contentType)
                .headers(header)
                .body(json)
                .when()
                .put(endpoint)
                .thenReturn();
    }

    public static void delete(Map<String, String> header, String endpoint) {
        response = RestAssured.given()
                .relaxedHTTPSValidation()
                .headers(header)
                .when()
                .delete(endpoint)
                .thenReturn();
    }
}