package tests;

import config.TestConfig;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

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

    //Получение всего ответа с помощью функции Extract
    @Test
    public void getAllDataFromRequest(){
        Response response = given().spec(requestSpecificationforSwapiTests).log().uri().
                when().get(SWAPI_PATH).
                then().extract().response();

        String jsonResponseAsString = response.asString();
        System.out.println(jsonResponseAsString);
    }

    //Получение Cookie
    @Test
    public void getCookieFromResponse(){
        Response response = given().spec(requestSpecificationforSwapiTests).log().uri().
                when().get(SWAPI_PATH).
                then().extract().response();
        //Для получения всех кук
        Map<String, String> allCookies = response.getCookies();
        System.out.println("allCookie-->" + allCookies);

        //Для получения определенной куки
        //__cfduidм - это имя куки,которое берется из "sout" выше
        String someCookie = response.getCookie("__cfduid");
        System.out.println("someCookie-->"+someCookie);
    }

    //Получение Headers
    @Test
    public void getHeadersFromResponse(){
        Response response = given().spec(requestSpecificationforSwapiTests).log().uri().
                when().get(SWAPI_PATH).
                then().extract().response();
        //Пробуем получит все Headers
        Headers headers = response.getHeaders();
        //System.out.println("headers--> " + headers);

        //Получение значения определенного заголовка
        String contentType = response.getHeader("Content-Type");
        System.out.println(contentType);
    }
}
