package tests;

import baseUrl.RESTFULL_BaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import testDatas.RestfullDatas;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class P18_Post_TestDataKullanimi extends RESTFULL_BaseUrl {




     /*
       https://restful-booker.herokuapp.com/booking url’ine asagidaki body’ye sahip
        bir POST request gonderdigimizde donen response’un
        id haric asagidaki gibi oldugunu test edin.

        Request body
               {
                   “firstname” : “Ahmet”,
                   “lastname” : “Bulut”,
                   “totalprice” : 500,
                   “depositpaid” : false,
                   “bookingdates” : {
                       "checkin" : "2021-06-01",
                       “checkout” : “2021-06-10”
                   },
                   “additionalneeds” : “wi-fi”
               }
        Response Body
         {
            “bookingid”: 24,
            “booking”: {
                “firstname”: “Ahmet”,
                “lastname”: “Bulut”,
                “totalprice”: 500,
                “depositpaid”: false,
                “bookingdates”: {
                    “checkin”: “2021-06-01",
                    “checkout”: “2021-06-10"
                },
                “additionalneeds”: “wi-fi”
            }
        }
         */

    @Test
    public void test() {
        specRestFull.pathParam("pp1", "booking");
        JSONObject bookingdates = RestfullDatas.bookingDatesOlustur2("2021-06-01", "2021-06-10");
        JSONObject reqBody = RestfullDatas.reqBodyOlustur2("Murat", "Yiğit", 500, false, bookingdates, "wi-fi");


        JSONObject expData = new JSONObject();
        expData.put("bookingid", 25);
        expData.put("booking", reqBody);

        Response response = given().contentType(ContentType.JSON).spec(specRestFull).when().body(reqBody.toString()).post("/{pp1}");

        JsonPath resJP = response.jsonPath();

        assertEquals(resJP.get("booking.firstname"), expData.getJSONObject("booking").get("firstname"));
        assertEquals(resJP.get("booking.lastname"), expData.getJSONObject("booking").get("lastname"));
        assertEquals(resJP.get("booking.totalprice"), expData.getJSONObject("booking").get("totalprice"));
        assertEquals(resJP.get("booking.depositpaid"), expData.getJSONObject("booking").get("depositpaid"));
        assertEquals(resJP.get("booking.additionalneeds"), expData.getJSONObject("booking").get("additionalneeds"));
        assertEquals(resJP.get("booking.bookingdates.checkin"),
                expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"));
        assertEquals(resJP.get("booking.bookingdates.checkout"),
                expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"));
    }


    @Test


    public void test2() {
        specRestFull.pathParam("pp1", "booking");

        JSONObject bookingdates = RestfullDatas.bookingDatesOlustur2("2021-06-01", "2021-06-10");

        JSONObject reqBody = RestfullDatas.reqBodyOlustur2("Murat", "Yiğit", 500, false, bookingdates, "wi-fi");


        JSONObject expData = new JSONObject();
        expData.put("bookingid", 24);
        expData.put("bookingid", 25);
        expData.put("booking", reqBody);


        Response response = given().contentType(ContentType.JSON).spec(specRestFull).when().body(reqBody.toString()).post("/{pp1}");

        JsonPath resJP = response.jsonPath();


        assertEquals(resJP.get("booking.firstname"), expData.getJSONObject("booking").get("firstname"));
    }

}



