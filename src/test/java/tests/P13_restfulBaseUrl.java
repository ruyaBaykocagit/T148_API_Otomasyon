package tests;

import baseUrl.RESTFULL_BaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class P13_restfulBaseUrl extends RESTFULL_BaseUrl {

    /*

     https://restful-booker.herokuapp.com/booking endpointine---- alırken com dan sonraki / alma DİKKAT
     bir GET request gonderdigimizde donen response'un
     status code'unun 200 oldugunu ve
     Response'ta 12 booking oldugunu test edin

*/
  @Test
  public void test01(){
      specRestFull.pathParam("pp1","booking");

      Response response=given().spec(specRestFull).when().get("/{pp1}");

      response.prettyPrint();

      response.then().assertThat().statusCode(200).body("bookingid", Matchers.hasItem(12));

  }

}
