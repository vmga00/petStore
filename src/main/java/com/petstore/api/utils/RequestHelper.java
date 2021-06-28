package com.petstore.api.utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestHelper {
    private static final String BASE_URL = ConfigManager.getInstance().getString("baseUrl");
    private static final String PORT = ConfigManager.getInstance().getString("port");
    private static final String API_VERSION =  ConfigManager.getInstance().getString("apiVersion");
    private static final String APP_CONTEXT =  ConfigManager.getInstance().getString("appContext");
    protected static String context = APP_CONTEXT + "/" + API_VERSION;

    public static RequestHelper util;

    public  static void initialize(){
        RestAssured.baseURI = BASE_URL;
        RestAssured.port = Integer.parseInt(PORT);
        RestAssured.useRelaxedHTTPSValidation();
    }

    public static Response get(String endPoint, String query){
        Response response = RestAssured.given().log().all()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .get(context + endPoint + query)
                .andReturn();
        return response;
    }

    public static Response post(String endPoint,Object body){
        Response response = RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .body(body)
                .post(context + endPoint)
                .andReturn();
        return response;
    }

    public static Response remove(String endPoint, String query){
        RequestSpecification request = RestAssured.given().contentType(ContentType.JSON);
        Response response = request.delete(context + endPoint + query);
        return response;
    }

    public static Response update(String endPoint, Object object){
        RequestSpecification request = RestAssured.given().log().all();
        request.body(object);
        Response response = request.put(endPoint);
        return response;
    }

}
