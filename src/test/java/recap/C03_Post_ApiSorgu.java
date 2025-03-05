package recap;

import baseUrl.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class C03_Post_ApiSorgu extends ReqresBaseUrl {

    /*

        https://reqres.in/api/users URL'sine
            header değeri "Content-Type", "application/json" olan bir POST isteği gönderin.
            İstek için JSON formatında şu bilgileri içeren bir body kullanın:
            {
               "name": "morpheus",
               "job": "leader"
               }
            Gelen yanıtın durum kodunun 201 olduğunu doğrulayın.
            Yanıtın JSON body'sinde name alanının morpheus olduğunu kontrol edin.


 */
    @Test
    public void test(){
        specReqRes.pathParams("pp1","api","pp2","users");

        //JSONObject reqBody=new JSONObject();
       // reqBody.put("name", "morpheus");
       // reqBody.put("job", "leader");

        String reqBody="{\"name\":\"morpheus\",\"job\":\"leader\"}";  // bu sekilde de reqBody olusturulur

        Response response=given().contentType(ContentType.JSON).spec(specReqRes).header("Content-Type", "application/json")
                .when().body(reqBody).post("/{pp1}/{pp2}");
        //response.prettyPrint();

        JsonPath resJP=response.jsonPath();

        Assertions.assertEquals(201,response.statusCode());
        Assertions.assertEquals("morpheus",resJP.getString("name"));
    }

}
