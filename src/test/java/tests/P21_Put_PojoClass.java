package tests;

import baseUrl.JPH_baseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.PojoJPH;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class P21_Put_PojoClass extends JPH_baseUrl {

    /*

        https://jsonplaceholder.typicode.com/posts/70 url'ine
asagidaki body'e sahip bir PUT request yolladigimizda
donen response'in response body'sinin
asagida verilen ile ayni oldugunu test ediniz

Request Body
{
    "title": "Ahmet",
    "body": "Merhaba",
    "userId": 10,
    "id": 70
}

Expected Data :
{
    "title": "Ahmet",
    "body": "Merhaba",
    "userId": 10,
    "id": 70
}

 */

@Test
    public void PojoClassTest(){

    specJPH.pathParams("pp1","posts","pp2","70");

    PojoJPH reqPojo=new PojoJPH("Murat","Merhaba",10,70);

    PojoJPH expPojo=new PojoJPH("Murat","Merhaba",10,70);

    Response response=given().spec(specJPH).contentType(ContentType.JSON).when().body(reqPojo).put("/{pp1}/{pp2}");
    //response.prettyPrint();

    PojoJPH resPojo=response.as(PojoJPH.class);

    assertEquals(expPojo.getTitle(),resPojo.getTitle());
    assertEquals(expPojo.getBody(),resPojo.getBody());
    assertEquals(expPojo.getUserId(),resPojo.getUserId());
    assertEquals(expPojo.getId(),resPojo.getId());



}










}
