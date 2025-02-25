package tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class P01_GET_ApiTest {
     /*
    https://restful-booker.herokuapp.com/booking/10 url’ine
    bir GET request gonderdigimizde donen Response’un,
    status code’unun 200,
    ve content type’inin application/json; charset=utf-8,
    ve Server isimli Header’in degerinin Cowboy,
    ve status Line’in HTTP/1.1 200 OK
    ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
     */

    /*
    Tum API sorguları 4 asamada yapılır
    1-EndPoint hazırlanır(url ve varsa(PUT-POST-PATCH) request Body hazırlanır)
    2- Soruda verilmişse expected data hazırnaır verilmemisse hazırlanmaz
    3- Dönen cevap kaydedilir
    4- Assertion islemleri yapılır
     */
    @Test
    public void test01(){
        //1- end point hazırla
        String url="https://restful-booker.herokuapp.com/booking/10";
        //2- verılmemıs o yuzden hazırlanmaz

        //3- Dönen cevabı kaydedilir
        Response response=given().when().get(url);//RestAssured.get(url) esıttırın yanına bu da konulabılır

        response.prettyPrint();//  sadece icerigi yazdırır ama bıraz yorar
       // response.prettyPeek();//   tum bılgılerı yazdırır

        //4- Assertion asaması
        System.out.println("Status degeri:"+response.getStatusCode()); //200
        System.out.println("Content type degeri:"+response.getContentType()); //application/json; charset=utf-8
        System.out.println("Server isimli header degeri:"+response.getHeader("Server"));//Cowboy
        System.out.println("Status Line degeri:"+response.getStatusLine());//HTTP/1.1 200 OK
        System.out.println("Response suresi degeri:"+response.getTime());// 5 sn den kısa



    }


}

