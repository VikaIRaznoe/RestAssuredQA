package tests;

import config.TestConfig;
import org.testng.annotations.Test;

import static constans.Constans.Actions.SWAPI_GET_PEOPLE;
import static constans.Constans.Path.SWAPI_PATH;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FirstTest extends TestConfig {

    //Просто смотрим структуру ответа и проверяем значение по ключу "people"
    @Test
    public void getSomeFieldInResponseAssertion(){
        given().spec(requestSpecificationforSwapiTests).log().uri().
        when().get(SWAPI_PATH).
        then().body("people",equalTo("https://swapi.co/api/people/1")).log().body();
    }

    //Смотрим на структуру Response,если добавить к запросу Actions - SWAPI_GET_PEOPLE
    @Test
    public void getSomeFieldInResponseWithIndexAssertion(){
        given().spec(requestSpecificationforSwapiTests).log().uri().
                when().get(SWAPI_PATH + SWAPI_GET_PEOPLE).
                then().log().body();
    }

    //Сделаем проверку поля count,что оно имеет значение 87
    @Test
    public void getSomeFieldInResponseWithIndexAssertion2(){
        given().spec(requestSpecificationforSwapiTests).log().uri().
                when().get(SWAPI_PATH + SWAPI_GET_PEOPLE).
                then()
                .body("count",equalTo(87))
                .log().body();
    }

    //Сделаем проверку поля name,что оно имеет значение Luke Skywalker и находится в results
    @Test
    public void getSomeFieldInResponseWithIndex2Assertion2(){
        given().spec(requestSpecificationforSwapiTests).log().uri().
                when().get(SWAPI_PATH + SWAPI_GET_PEOPLE).
                then()
                .body("count",equalTo(87))
                .body("results.name[0]",equalTo("Luke Skywalker"))
                .log().body();
    }
}
