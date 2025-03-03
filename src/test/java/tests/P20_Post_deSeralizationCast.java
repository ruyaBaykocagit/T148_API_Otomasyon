package tests;

import baseUrl.RESTFULL_BaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import testDatas.RestfullDatas;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class P20_Post_deSeralizationCast extends RESTFULL_BaseUrl {
    /*

    https://restful-booker.herokuapp.com/booking url'ine
asagidaki body'ye sahip bir POST request gonderdigimizde
donen response'un id haric asagidaki gibi oldugunu test edin.

Request body
       {
           "firstname" : "Ahmet",
           "lastname" : "Bulut",
           "totalprice" : 500,
           "depositpaid" : false,
           "bookingdates" : {
               "checkin" : "2021-06-01",
               "checkout" : "2021-06-10"
           },
           "additionalneeds" : "wi-fi"
       }

Response Body // expected data
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
    public void test01(){

     specRestFull.pathParam("pp1","booking");

     Map<String,Object> reqMapBody= RestfullDatas.mapDataOlustur();

    Map<String,Object> expMapBody=RestfullDatas.expMapDataOlustur();

        Response response=given().contentType(ContentType.JSON).spec(specRestFull).when().body(reqMapBody).post("/{pp1}");

        // response.prettyPrint();

        Map<String,Object>resMAP=response.as(HashMap.class);

        Assert.assertEquals(((Map)expMapBody.get("booking")).get("firstname"),
                ((Map) resMAP.get("booking")).get("firstname"));

        Assert.assertEquals(((Map)expMapBody.get("booking")).get("lastname"),
                ((Map) resMAP.get("booking")).get("lastname"));

        Assert.assertEquals(((Map)expMapBody.get("booking")).get("totalprice"),
                ((Map) resMAP.get("booking")).get("totalprice"));

        Assert.assertEquals(((Map)expMapBody.get("booking")).get("depositpaid"),
                ((Map) resMAP.get("booking")).get("depositpaid"));

        Assert.assertEquals(((Map)expMapBody.get("booking")).get("additionalneeds"),
                ((Map) resMAP.get("booking")).get("additionalneeds"));

        Assert.assertEquals(((Map)((Map)expMapBody.get("booking")).get("bookingdates")).get("checkin"),
                ((Map)((Map) resMAP.get("booking")).get("bookingdates")).get("checkin"));

        Assert.assertEquals(((Map)((Map)expMapBody.get("booking")).get("bookingdates")).get("checkout"),
                ((Map)((Map) resMAP.get("booking")).get("bookingdates")).get("checkout"));






    }
}
