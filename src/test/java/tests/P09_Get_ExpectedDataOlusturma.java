package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class P09_Get_ExpectedDataOlusturma {
   /*

        https://jsonplaceholder.typicode.com/posts/22 url'ine
        bir GET request yolladigimizda donen response body'sinin
         asagida verilen ile ayni oldugunu test ediniz

  Response body :(EXPECTED DATA)
{
    "userId": 3,
    "id": 22,
    "title": "dolor sint quo a velit explicabo quia nam",
    "body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
            um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
}

 */

    @Test
    public void test(){
        //1 end point
        String url="https://jsonplaceholder.typicode.com/posts/22";
        //2 expected data olustur
        JSONObject expBody=new JSONObject();
        expBody.put("userId", 3);
        expBody.put("id", 22);
        expBody.put("title", "dolor sint quo a velit explicabo quia nam");
        expBody.put("body","eos qui et ipsum ipsam suscipit aut\n" +
                "sed omnis non odio\n" +
                "expedita earum mollitia molestiae aut atque rem suscipit\n" +
                "nam impedit esse");
//3 response
        Response response=given().when().get(url);
        //4-assertion
        // Expected Data hazırlanmıssa bu verilerle donen cevabı karsılastırmak ıstersek
        // donen cevabında JSONPath seklınde ulasılabılır olması gerek


        JsonPath resJP=response.jsonPath(); // bu asama cok onemlı dnusturme gerek unutma

        Assertions.assertEquals(expBody.get("userId"),resJP.get("userId"));
        Assertions.assertEquals(expBody.get("id"),resJP.get("id"));
        Assertions.assertEquals(expBody.get("title"),resJP.get("title"));
        Assertions.assertEquals(expBody.get("body"),resJP.get("body"));
















    }
}
