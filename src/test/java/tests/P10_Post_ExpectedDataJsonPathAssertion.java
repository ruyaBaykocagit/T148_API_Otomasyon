package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class P10_Post_ExpectedDataJsonPathAssertion {

    /*

https://restful-booker.herokuapp.com/booking url'ine
asagidaki body'ye sahip bir POST request gonderdigimizde
donen response'un id haric asagidaki gibi oldugunu test edin.

Request body
      {
        "firstname": "Ahmet",
        "lastname": "Bulut",
        "totalprice": 500,
        "depositpaid": false,
        "bookingdates": {
            "checkin": "2021-06-01",
            "checkout": "2021-06-10"
        },
        "additionalneeds": "wi-fi"
    }

Response Body - Expected Data
 {
    "bookingid": 24,
    "booking": {
        "firstname": "Ahmet",
        "lastname": "Bulut",
        "totalprice": 500,
        "depositpaid": false,
        "bookingdates": {
            "checkin": "2021-06-01",
            "checkout": "2021-06-10"
        },
        "additionalneeds": "wi-fi"
    }
}

 */

    @Test
    public void test() {
        //1 - endpoint ve reqBody hazırlama
        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject innerData = new JSONObject();//olusturmaya icerden basla
        innerData.put("checkin", "2021-06-01");
        innerData.put("checkout", "2021-06-10");

        JSONObject reqBody = new JSONObject();
        reqBody.put("firstname", "Ahmet");
        reqBody.put("lastname", "Bulut");
        reqBody.put("totalprice", 500);
        reqBody.put("depositpaid", false);
        reqBody.put("bookingdates", innerData);
        reqBody.put("additionalneeds", "wi-fi");

        //2- expected data olustur

        JSONObject expBody = new JSONObject();
        expBody.put("bookingid", 499);
        expBody.put("booking", reqBody);

        //3- response kaydet
        Response response = given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);

        //4- Assertion yap
        // donen cevabı JsonPath formatına cevır

        JsonPath resJP = response.jsonPath();

        Assertions.assertEquals(expBody.getJSONObject("booking").get("firstname"), resJP.get("booking.firstname"));
        Assertions.assertEquals(expBody.getJSONObject("booking").get("lastname"), resJP.get("booking.lastname"));
        Assertions.assertEquals(expBody.getJSONObject("booking").get("totalprice"), resJP.get("booking.totalprice"));
        Assertions.assertEquals(expBody.getJSONObject("booking").get("depositpaid"), resJP.get("booking.depositpaid"));
        Assertions.assertEquals(expBody.getJSONObject("booking").get("additionalneeds"), resJP.get("booking.additionalneeds"));

        Assertions.assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),
                resJP.get("booking.bookingdates.checkin"));
        Assertions.assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),
                resJP.get("booking.bookingdates.checkout"));


    }


}











