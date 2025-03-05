package recap;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C01_Get_ApiSorgu {
    /*

       https://reqres.in/api/users/2 URL'sine bir GET isteği gönderin.
           Gelen yanıtın durum kodunun 200 olduğunu doğrulayın.
           Yanıtın JSON body'sinde yer alan data.id değerinin 2 olduğunu doğrulayın.
           Yanıt süresinin 2 saniyeden kısa olduğunu kontrol edin.

 */

    @Test
    public void test(){
        String url="https://reqres.in/api/users/2";

        //Response response=given().when().get(url);
        Response response= RestAssured.get(url);// header degerleri eklenmeyecekse tercih edilmez

        response.then().assertThat().statusCode(200);

        Assert.assertEquals(response.jsonPath().getInt("data.id"),2,"data.id degeri 2 olarak tespit edildi");
        Assert.assertTrue(response.getTime()<2000,"Yanit suresi 2 snden kısadır");

    }
}
