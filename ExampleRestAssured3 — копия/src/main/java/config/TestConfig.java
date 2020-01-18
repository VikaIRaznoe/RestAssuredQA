package config;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import static constans.Constans.RunVariable.path;
import static constans.Constans.RunVariable.server;

public class TestConfig {

    @BeforeClass
    public void setUp(){
        RestAssured.baseURI = server;
        RestAssured.basePath = path;
    }
}