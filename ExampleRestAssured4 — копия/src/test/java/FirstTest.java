//Будем использовать всю фнукциональность библиотеки RestAssured
import config.TestConfig;
import org.testng.annotations.Test;

import static constans.Constans.Actions.JSONPLACEHOLDER_GET;
import static io.restassured.RestAssured.*;

public class FirstTest extends TestConfig {
    @Test
    public void GET(){
        given().log().uri().
        when().get(JSONPLACEHOLDER_GET).
        then().log().body().statusCode(200);
    }
}
