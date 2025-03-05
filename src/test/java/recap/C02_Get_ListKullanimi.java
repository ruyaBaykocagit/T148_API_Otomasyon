package recap;

import baseUrl.ReqresBaseUrl;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class C02_Get_ListKullanimi extends ReqresBaseUrl {
    /*

        https://reqres.in/api/users?page=2 URL'sine bir GET isteği gönderin.
        Gelen yanıtın durum kodunun 200 olduğunu doğrulayın.
        Liste içerisindeki kullanıcı sayısının en az 1 olduğunu doğrulayın.
        İlk kullanıcının email adresinin boş olmadığını kontrol edin.

 */

    @Test
    public void test(){
        specReqRes.pathParams("pp1","api","pp2","users");
        specReqRes.queryParam("page",2);

        Response response= given().spec(specReqRes).when().get("/{pp1}/{pp2}");
        Assertions.assertEquals(200,response.getStatusCode());
        Assertions.assertTrue(response.jsonPath().getList("data").size()>0);
        Assertions.assertNotNull(response.jsonPath().get("data[0].email"));

        System.out.println("\nAssert Durumu Basarili!");

    }
}
