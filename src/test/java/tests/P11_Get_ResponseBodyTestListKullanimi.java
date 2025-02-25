package tests;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class P11_Get_ResponseBodyTestListKullanimi {


    /*

    https://api.collectapi.com/health/dutyPharmacy?il=Kırıkkale url'ine
    bir GET request yolladigimizda
    donen Response'in
    status code'unun 200,
    ve content type'inin Aplication.JSON,
    ve response body'sindeki
        eczane sayısıın sayisinin 6
        ve eczane'lerden birinin "ENES ECZANESİ"
        ve eczanele ilçelerinde icinde Yahsihan ,Karakecili ve Keskin degerinin oldugunu test edin.
 */

    @Test
    public void test() {
        String url = "https://api.collectapi.com/health/dutyPharmacy?il=Kirikkale";

        // get methodu oldugu ve soruda verilmedıgı ıcın expected body yok ve reqBody yok

        String apikey = "apikey 4SqHDUtRQl34v4pw1Jvt8Z:5zlnaVsMnLJlwrlZwLzNud";// tanımlamazsak 401 hatası verir
        Response response = given().when().header("authorization", apikey).get(url);
        //response.prettyPrint();-- bir baktık cevaba

        response.then().assertThat().statusCode(200).contentType("application/json")
                .body("result.dist", Matchers.hasSize(6),"result.name",Matchers.hasItem("ENES ECZANESİ"),
                        "result.dist",Matchers.hasItems("yahşihan","karakeçili","keskin"));// Matchersları yukarda import edebılırız


    }


}
