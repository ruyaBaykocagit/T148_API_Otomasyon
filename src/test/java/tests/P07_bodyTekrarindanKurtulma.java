package tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class P07_bodyTekrarindanKurtulma {

    /*

    https://restful-booker.herokuapp.com/booking/100 url'ine
    bir GET request gonderdigimizde donen Response'un,
        status code'unun 200,
        ve content type'inin application-json,
        ve response body'sindeki
           "firstname"in, "John",
        ve "lastname"in, "Smith",
        ve "totalprice"in, 111,
        ve "depositpaid"in, true,
        ve "additionalneeds"in, "Breakfast"
   oldugunu test edin

 */
    @Test
    public void test() {
        //1- end point hazırlama
        String url = "https://restful-booker.herokuapp.com/booking/100";

        //2- expected data hazırlama

        //3- Response kaydı
        Response response = given().when().get(url);

        //4- Assertion islemleri
        response.then().assertThat().statusCode(200).contentType("application/json")
                .body("firstname", equalTo("John"),
                        "lastname", equalTo("Smith"),
                        "totalprice", equalTo(111), "depositpaid", equalTo(true),
                        "additionalneeds", equalTo("Breakfast"));


    }
}
