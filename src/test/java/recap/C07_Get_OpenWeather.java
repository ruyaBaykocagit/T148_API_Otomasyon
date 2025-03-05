package recap;

import baseUrl.OpenWeatherBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class C07_Get_OpenWeather extends OpenWeatherBaseUrl {
    public static String myApiKey="8be3cfd5a6f39e4f75e8673fd16eb2d0";

    /*
    https://home.openweathermap.org/users/sign_up
11:16
:pushpin: Endpoint: https://api.openweathermap.org/data/2.5/weather?q=Istanbul&appid=YOUR_API_KEY
:pushpin: HTTP Metodu: GET
Senaryo:

Bu endpoint'e bir GET request gönderdiğimizde dönen Response’un:

Status code’unun 200,
Content-Type’ının application/json; charset=utf-8,
Response Body’sinde "name" alanının "Istanbul" olduğunu,
Response Body’sinde "main.temp" değerinin -50 ile 50 arasında olmadıgını
test ediniz.(negatif senaryo)
     */


@Test
    public void test01(){
    specOpenWeather.pathParams("pp1","data","pp2","2.5","pp3","weather")
            .queryParams("q","Istanbul","appid",myApiKey);

    Response response=given().spec(specOpenWeather).when().get("/{pp1}/{pp2}/{pp3}");

    response.then().assertThat().statusCode(200)
            .contentType("application/json")
            .body("name", Matchers.equalTo("Istanbul"));

    Assertions.assertFalse(response.jsonPath().getDouble("main.temp")>-50
            &&response.jsonPath().getDouble("main.temp")>50);



}
}
