//Будем использовать всю фнукциональность библиотеки RestAssured
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class FirstTest{
    @Test
    public void myFirstTest(){
        //Будем использовать подход BDD
        given().
                when().get("https://swapi.co/api/people/1").
                then().statusCode(200);
    }
}