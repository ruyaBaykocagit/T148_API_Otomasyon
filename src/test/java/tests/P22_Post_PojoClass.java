package tests;

import baseUrl.RESTFULL_BaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.RestfullBookingDatesPojo;
import pojo.RestfullExpBodyPojo;
import pojo.RestfullReqBodyPojo;

import static io.restassured.RestAssured.given;

public class P22_Post_PojoClass extends RESTFULL_BaseUrl {

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
    RestfullBookingDatesPojo bookingdates=new RestfullBookingDatesPojo("2025-06-01","2025-06-10");
    RestfullReqBodyPojo reqBody=new RestfullReqBodyPojo("Murat","Yigit",1750,"wi-fi",true,bookingdates);
    RestfullExpBodyPojo expBody=new RestfullExpBodyPojo(24,reqBody);

    Response response=given().spec(specRestFull).contentType(ContentType.JSON).when().body(reqBody).post("/{pp1}");

RestfullExpBodyPojo resPojo=response.as(RestfullExpBodyPojo.class);
    Assert.assertEquals(resPojo.getBooking().getFirstname(),expBody.getBooking().getFirstname());
    Assert.assertEquals(resPojo.getBooking().getLastname(),expBody.getBooking().getLastname());
    Assert.assertEquals(resPojo.getBooking().getTotalprice(),expBody.getBooking().getTotalprice());
    Assert.assertEquals(resPojo.getBooking().getAdditionalneeds(),expBody.getBooking().getAdditionalneeds());
    Assert.assertEquals(resPojo.getBooking().isDepositpaid(),expBody.getBooking().isDepositpaid());
    Assert.assertEquals(resPojo.getBooking().getBookingdates().getCheckin(),expBody.getBooking().getBookingdates().getCheckin());
    Assert.assertEquals(resPojo.getBooking().getBookingdates().getCheckout(),expBody.getBooking().getBookingdates().getCheckout());


}









}
