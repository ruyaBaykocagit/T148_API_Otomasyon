package tests;

import baseUrl.JPH_baseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class P12_baseUrl_JPH extends JPH_baseUrl {
    /*

        https://jsonplaceholder.typicode.com/posts endpointine
         bir GET request gonderdigimizde
         donen response'un status code'unun 200 oldugunu ve
         Response'ta 100 kayit oldugunu test edin


 */

    @Test //test notasyonu testNG olmalı dikkat
    public void test01(){
        //1-- endpoint hazırlama
        specJPH.pathParam("first","posts");
        //2- expectedbody yok

        //3- response kaydı
        Response response=given().spec(specJPH).when().get("/{first}");

        response.prettyPrint();

        //4 - assertion
        response.then().assertThat().statusCode(200).body("aloo.size()", Matchers.equalTo(100));


    }
    /*
    2- https://jsonplaceholder.typicode.com/posts/44 endpointine
        bir GET request gonderdigimizde donen response'un
        status code'unun 200 oldugunu ve "title" degerinin
        "optio dolor molestias sit" oldugunu test edin

     */
    @Test
    public void test02(){
     specJPH.pathParams("first","posts","second","44")   ;

     Response response=given().spec(specJPH).when().get("/{first}/{second}");

     response.then().assertThat().statusCode(200).body("title",Matchers.equalTo("optio dolor molestias sit"));
    }
}
