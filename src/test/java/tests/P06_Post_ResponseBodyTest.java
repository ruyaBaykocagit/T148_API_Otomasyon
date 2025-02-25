package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class P06_Post_ResponseBodyTest {

    /*

         https://jsonplaceholder.typicode.com/posts url'ine
         asagidaki body ile bir POST request gonderdigimizde
               {
               "title":"API",
               "body":"API ogrenmek ne guzel",
                "userId":10,
               }

       donen Response'un,
       status code'unun 201,
       ve content type'inin application/json
       ve Response Body'sindeki,
          "title"'in "API" oldugunu
          "userId" degerinin 100'den kucuk oldugunu
          "body" nin "API" kelimesi icerdigini
       test edin.

 */

@Test
    public void test(){
// 1- end poınt ve POST request oldugu icin request body de hazırlanır
    String url="https://jsonplaceholder.typicode.com/posts";

    JSONObject reqBody=new JSONObject();
    reqBody.put("title","API");
    reqBody.put("body","API ogrenmek ne guzel");
    reqBody.put("userId",10);

    //2- expected data verilmemis
    //3- Response kaydı
    Response response=given().contentType(ContentType.JSON).when().body(reqBody.toString())
            .post(url);

    //4- assertion islemlerini yaparız

    response.then().assertThat().statusCode(201).contentType("application/json")
            .body("title", Matchers.equalTo("API")) // Matchers ları yukarda * ile ımport edebılırız
            .body("body", Matchers.containsString("API"))
            .body("userId",Matchers.lessThan(100));
}










}
