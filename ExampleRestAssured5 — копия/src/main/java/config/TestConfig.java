package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

import static constans.Constans.RunVariable.path;
import static constans.Constans.RunVariable.server;

public class TestConfig {

    @BeforeClass
    public void setUp(){
        RestAssured.baseURI = server;
        RestAssured.basePath = path;

        RequestSpecification requestSpecificationFor = new RequestSpecBuilder()
                .addHeader("Content-Type","application/json")
                .addCookie("testCookie")
                .build();

        //Для того,чтобы RequestSpecification использовался для каждого запроса,
        // тоесть чтобы добавлялись headers and cookies,нужно
        RestAssured.requestSpecification = requestSpecificationFor;
    }
}