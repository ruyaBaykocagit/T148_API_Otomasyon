package recap;

import baseUrl.ReqresBaseUrl;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class C06_Delete extends ReqresBaseUrl {
    /*

        https://reqres.in/api/users/57 URL'sine bir DELETE isteği gönderin.
       Gelen yanıtın durum kodunun 204 olduğunu doğrulayın.

 */
    @Test
    public void test(){
       specReqRes.pathParams("pp1","api","pp2","users","pp3","57");

        Response response=given().spec(specReqRes).when().delete("/{pp1}/{pp2}/{pp3}");

        response.then().statusCode(204);

    }
}
