package recap;

import baseUrl.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pojo.ReqresPojo;

import static io.restassured.RestAssured.given;

public class C04_Put_Pojo extends ReqresBaseUrl {
    /*

    https://reqres.in/api/users/2 URL'sine
    header değeri "Content-Type","application/json" olan bir PUT isteği gönderin.
        Kullanıcıyı şu şekilde güncelleyin:
                 {
                 "name": "John Doe",
                 "job": "Manager"
                  }
        Yanıtın durum kodunun 200 olduğunu doğrulayın ve name alanının John Doe olduğunu doğrulayın.

 */

    @Test
    public void test(){
        specReqRes.pathParams("pp1","api","pp2","users","pp3","2");

        ReqresPojo reqBody=new ReqresPojo("John Doe","Manager");

        Response response=given().contentType(ContentType.JSON).spec(specReqRes).when().
                          header("Content-Type","application/json").body(reqBody).put("/{pp1}/{pp2}/{pp3}");

        Assertions.assertEquals(200,response.getStatusCode());
        Assertions.assertEquals("John Doe",response.jsonPath().getString("name"));

    }
}
