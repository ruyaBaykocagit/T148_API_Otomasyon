package recap;

import baseUrl.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class C05_Put_ResponseBodyTesti extends ReqresBaseUrl {

    /*https://reqres.in/api/users/2 URL'ine
        aşağıdaki JSON body ile PUT request gönderildiğinde
            {
                "name": "Murat",
                "job": "Senior QA"
            }
            dönen Response’un:
            Status code’unun 200 olduğunu,
            Content type’ının application/json; charset=utf-8 olduğunu,
            Response Body’sini updatedAt hariç aşağıdaki expectedBody ile birebir eşleştiğini test ediniz.
            {
                "name": "Murat",
                "job": "Senior QA",
                "updatedAt": "2025-03-05T12:34:56.789Z"
            }
     */



@Test
    public void test(){
    specReqRes.pathParams("pp1","api","pp2","users","pp3","2");

    //String reqBody="{\"name\":\"Ruya\",\"job\":\"QA Tester\"}";
    //String expBody="{\"name\":\"Ruya\",\"job\":\"QA Tester\",\"updatedAt\":\"2025-03-05T12:34:56.789Z\"}";
    // iç veriler assert edilecekse bu sekilde String almayalım eski yonteme devam
    JSONObject reqBody=new JSONObject();
    reqBody.put("name","Ruya");
    reqBody.put("job","QA Tester");

    JSONObject expBody=new JSONObject();
    expBody.put("name","Ruya");
    expBody.put("job","QA Tester");
    expBody.put("updatedAt","2025-03-05T12:34:56.789Z");

    Response response=given().contentType(ContentType.JSON).spec(specReqRes)
            .when().body(reqBody.toString()).put("/{pp1}/{pp2}/{pp3}");

    Assertions.assertEquals(200,response.getStatusCode());
    Assertions.assertEquals(expBody.get("name"),response.jsonPath().get("name"));
    Assertions.assertEquals(expBody.get("job"),response.jsonPath().get("job"));



}
}
