package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

import static constans.Constans.RunVariable.path;
import static constans.Constans.RunVariable.server;
import static constans.Constans.Servers.REQUESTBIN_URL;
import static constans.Constans.Servers.SWAPI_URL;

public class TestConfig {

    protected RequestSpecification requestSpecificationforSwapiTests = new RequestSpecBuilder()
            .setBaseUri(SWAPI_URL).
            build();

    //Запрос на сервер
    protected RequestSpecification requestSpecificationXML = new RequestSpecBuilder()
            .addHeader("Content-Type","application/json")
            .addCookie("testCookieXML")
            .setBaseUri(REQUESTBIN_URL)
            .build();

    protected RequestSpecification requestSpecificationJSON = new RequestSpecBuilder()
            .addHeader("Content-Type","application/json")
            .addCookie("testCookieJSON")
            .build();

    //Ответ с сервера
    protected ResponseSpecification responseSpecificationForGet = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();

    protected ResponseSpecification responseSpecificationForPost = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .build();

    @BeforeClass
    public void setUp(){
        RestAssured.baseURI = server;
        RestAssured.basePath = path;


        //Для того,чтобы RequestSpecification использовался для каждого запроса,
        // тоесть чтобы добавлялись headers and cookies,нужно
        //RestAssured.requestSpecification = requestSpecificationJSON;
    }
}