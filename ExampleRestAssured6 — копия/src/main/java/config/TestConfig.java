package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

import static constans.Constans.RunVariable.path;
import static constans.Constans.RunVariable.server;
import static constans.Constans.Servers.REQUESTBIN_URL;

public class TestConfig {

    protected RequestSpecification requestSpecificationXML = new RequestSpecBuilder()
            .addHeader("Content-Type","application/json")
            .addCookie("testCookieXML")
            .setBaseUri(REQUESTBIN_URL)
            .build();

    @BeforeClass
    public void setUp(){
        RestAssured.baseURI = server;
        RestAssured.basePath = path;

        RequestSpecification requestSpecificationJSON = new RequestSpecBuilder()
                .addHeader("Content-Type","application/json")
                .addCookie("testCookieJSON")
                .build();

        //Для того,чтобы RequestSpecification использовался для каждого запроса,
        // тоесть чтобы добавлялись headers and cookies,нужно
        RestAssured.requestSpecification = requestSpecificationJSON;
    }
}