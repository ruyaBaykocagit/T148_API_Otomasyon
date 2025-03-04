package tests;

import baseUrl.CollectApiBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class P24_CollectApi_NöbetciEczaneler extends CollectApiBaseUrl {

    /*
       https://api.collectapi.com/health/dutyPharmacy?il=istanbul&ilce=Üsküdar
       adresine aşağıdaki bilgilerler bir GET request yapınca
       dönen cevabı yazdırınız.

       header
       Content-Type : application/json
       Authorization: apiKeyiniz

 */
    @Test
    public void test01(){

        specCollectApi.pathParams("pp1","health","pp2","dutyPharmacy")
                .queryParams("il","istanbul","ilce","Üsküdar");

        Response response=given().spec(specCollectApi).when().header("content-type","application/json")
                .header("Authorization","apikey 4SqHDUtRQl34v4pw1Jvt8Z:5zlnaVsMnLJlwrlZwLzNud")
                .get("/{pp1}/{pp2}");

        response.prettyPrint();
    }
}
