import config.TestConfig;
import org.testng.annotations.Test;

import static constans.Constans.Actions.JSONPLACEHOLDER_GET;
import static constans.Constans.Actions.JSONPLACEHOLDER_GET2;
import static io.restassured.RestAssured.given;

public class JsonPlaceHolderTest extends TestConfig {
    @Test
    public void GET(){
        given().queryParam("postId",1).log().uri().
                when().get(JSONPLACEHOLDER_GET).
                then().log().body().statusCode(200);
    }

    //@Test
    //public void GETTemp(){
    //    given().log().uri().
    //            when().get(JSONPLACEHOLDER_GET).
    //            then().log().body().statusCode(200);
    //}

    //@Test
    //public void GETTemp2(){
    //    given().log().uri().
    //    queryParam(JSONPLACEHOLDER_GET2).
    //    given().queryParam("p")
    //}
}
