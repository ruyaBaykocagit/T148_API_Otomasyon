package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class P10_Post_ExpectedDataSoftAssert {
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
    public void test(){
        //1-- endpoint ve reqBody hazırlama
        String url="https://restful-booker.herokuapp.com/booking";
        JSONObject bookingdates=new JSONObject();

        bookingdates.put("checkin","2021-06-01");
        bookingdates.put( "checkout", "2021-06-10");

        JSONObject reqBody=new JSONObject();

        reqBody.put("firstname", "Ahmet");
        reqBody.put("lastname", "Bulut");
        reqBody.put("totalprice", 500);
        reqBody.put("depositpaid",false);
        reqBody.put("bookingdates",bookingdates);
        reqBody.put("additionalneeds", "wi-fi");

        //2-- Expected data soruda verildigi icin hazırlanır

        JSONObject expBody=new JSONObject();
        expBody.put("bookingid",712);
        expBody.put("booking",reqBody);

        //3-- Response kaydı yapılır
        Response response=given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);

        //4- Assertion islemi
        JsonPath resJP=response.jsonPath();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(resJP.get("booking.firstname"),expBody.getJSONObject("booking").get("firstname"));
        softAssert.assertEquals(resJP.get("booking.lastname"),expBody.getJSONObject("booking").get("lastname"));
        softAssert.assertEquals(resJP.get("booking.totalprice"),expBody.getJSONObject("booking").get("totalprice"));
        softAssert.assertEquals(resJP.get("booking.depositpaid"),expBody.getJSONObject("booking").get("depositpaid"));
        softAssert.assertEquals(resJP.get("booking.additionalneeds"),expBody.getJSONObject("booking").get("additionalneeds"));
        softAssert.assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),
                resJP.get("booking.bookingdates.checkin"));
        softAssert.assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),
                resJP.get("booking.bookingdates.checkout"));





    }
}
