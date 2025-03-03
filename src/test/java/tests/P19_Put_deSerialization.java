package tests;

import baseUrl.JPH_baseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import testDatas.JPHDatas;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class P19_Put_deSerialization extends JPH_baseUrl {


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
    public void test02() {
        specJPH.pathParams("pp1", "posts", "pp2", "70");
        Map<String, Object> reqMAPBody = JPHDatas.MapDataOlustur();

        Map<String, Object> expMAPBody = JPHDatas.MapDataOlustur();

        Response response = given().contentType(ContentType.JSON).spec(specJPH).when().body(reqMAPBody).put("/{pp1}/{pp2}");

        //response.prettyPrint();//bir kontrol yaptık

        Map<String, Object> resMap = response.as(HashMap.class);

        Assert.assertEquals(resMap.get("title"), expMAPBody.get("title"));
        Assert.assertEquals(resMap.get("body"), expMAPBody.get("body"));
        Assert.assertEquals(resMap.get("id"), expMAPBody.get("id"));
        Assert.assertEquals(resMap.get("userId"), expMAPBody.get("userId"));
    }

    @Test
    public void test3(){
        specJPH.pathParams("pp1", "posts", "pp2", "70");
        Map<String,Object>reqMapBody=JPHDatas.MAPDataOLusturPli("Ahmet","Merhaba",10.0,70.0);
        Map<String,Object>expMapBody=JPHDatas.MAPDataOLusturPli("Ahmet","Merhaba",10.0,70.0);
        Response response=given().contentType(ContentType.JSON).spec(specJPH).when().body(reqMapBody).put("/{pp1}/{pp2}");

        Map<String,Object> resMap=response.as(HashMap.class);

        Assert.assertEquals(resMap.get("title"),expMapBody.get("title"));
        Assert.assertEquals(resMap.get("body"),expMapBody.get("body"));
        Assert.assertEquals(resMap.get("id"),expMapBody.get("id"));
        Assert.assertEquals(resMap.get("userId"),expMapBody.get("userId"));


    }
}
