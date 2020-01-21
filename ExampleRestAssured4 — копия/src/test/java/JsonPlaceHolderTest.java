import config.TestConfig;
import org.testng.annotations.Test;

import static constans.Constans.Actions.*;
import static io.restassured.RestAssured.given;

public class JsonPlaceHolderTest extends TestConfig {
    //Пример запроса GET
    @Test
    public void get(){
        given().queryParam("postId",1).log().uri().
                when().get(JSONPLACEHOLDER_GET).
                then().log().body().statusCode(200);
    }

    //Пример запроса PUT
    @Test
    public void put(){
        String putBodyJson = "{\n" +
                "      \"id\": 1,\n" +
                "      \"title\": \"foo\",\n" +
                "      \"body\": \"bar\",\n" +
                "      \"userId\": 1\n" +
                "    }";
        given().body(putBodyJson).log().uri().
        when().put(JSONPLACEHOLDER_PUT).
        then().log().body().statusCode(200);
    }

    //Пример запроса DELETE
    @Test
    public void delete(){
        given().log().uri().
        when().delete(JSONPLACEHOLDER_DELETE).
        then().log().body().statusCode(200);
    }


    //Пример запроса POST,где тело в формате JSON
    @Test
    public void postWithJson(){
        String postBodyJSON = "{\n" +
                "      \"title\": \"foo\",\n" +
                "      \"body\": \"bar\",\n" +
                "      \"userId\": 1\n" +
                "    }";

        given().body(postBodyJSON).log().uri().
                when().post(JSONPLACEHOLDER_POST).
                then().log().body().statusCode(201);
    }

    @Test
    public void postWithXML(){
        String postBodyXML = "<Company>\n" +
                "  <Employee>\n" +
                "      <FirstName>Tanmay</FirstName>\n" +
                "      <LastName>Patil</LastName>\n" +
                "      <ContactNo>1234567890</ContactNo>\n" +
                "      <Email>tanmaypatil@xyz.com</Email>\n" +
                "      <Address>\n" +
                "           <City>Bangalore</City>\n" +
                "           <State>Karnataka</State>\n" +
                "           <Zip>560212</Zip>\n" +
                "      </Address>\n" +
                "  </Employee>\n" +
                "</Company>";

        given().body(postBodyXML).log().uri().
                when().post("").
                then().log().body().statusCode(200);
    }
}
