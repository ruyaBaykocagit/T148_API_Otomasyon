package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class P04_PutResponseInformationAssertion {
    /*
   https://jsonplaceholder.typicode.com/posts/70 url’ine asagidaki
   Json formatindaki body ile bir PUT request gonderdigimizde
{
"title":"Ahmet",
"body":"Merhaba",
"userId":10,
"id":70
}
donen Response’un,
    status code’unun 200,
    ve content type’inin application/json; charset=utf-8,
    ve Server isimli Header’in degerinin cloudflare,
    ve status Line’in HTTP/1.1 200 OK


     */

    @Test
    public void test(){
        //1- end poınt hazırlanır(Put oldugu ıcın request body olacak)
        String url="https://jsonplaceholder.typicode.com/posts/70";

        JSONObject reqBody=new JSONObject();
        reqBody.put("title","Ahmet");
        reqBody.put("body","Merhaba");
        reqBody.put("userId",10);
        reqBody.put("id",70);

        // 2- expected data verilmemis
        //3- Response kayıt edilir
        Response response=given().contentType(ContentType.JSON).when().body(reqBody.toString()).put(url);

        response.then().assertThat().statusCode(200)
                .contentType("application/json; charset=utf-8")
                .statusLine("HTTP/1.1 200 OK")
                .header("Server","cloudflare");

    }
}
