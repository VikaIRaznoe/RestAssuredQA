//Будем использовать всю фнукциональность библиотеки RestAssured
import config.TestConfig;
import org.testng.annotations.Test;

import static constans.Constans.Actions.SWAPI_GET_PEOPLE;
import static io.restassured.RestAssured.*;

public class FirstTest extends TestConfig {
    @Test
    public void myFirstTest(){
        //Будем использовать подход BDD
        given().
                when().get(SWAPI_GET_PEOPLE+"1").
                then().statusCode(200);
    }
}
