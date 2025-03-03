package testDatas;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RestfullDatas {
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

    public static JSONObject jSONDataOlustur(){

        JSONObject bookingdates=new JSONObject();
        bookingdates.put("checkin" , "2021-06-01");
        bookingdates.put("checkout" , "2021-06-10");
        JSONObject reqBody=new JSONObject();
        reqBody.put("firstname","Murat");
        reqBody.put("lastname","Yiğit");
        reqBody.put("totalprice",1500);
        reqBody.put("depositpaid",true);
        reqBody.put("bookingdate",bookingdates);
        reqBody.put("additionalneeds","wi-fi");

        return reqBody;

    }

    public static JSONObject bookingdatesOlustur(){
        JSONObject bookingdates=new JSONObject();
        bookingdates.put("checkin" , "2021-06-01");
        bookingdates.put("checkout" , "2021-06-10");
        return bookingdates;
    }


    public static JSONObject bookingDatesOlustur2(String checkin, String checkout){
        JSONObject bookingdates=new JSONObject();
        bookingdates.put("checkin" , checkin);
        bookingdates.put("checkout" , checkout);
        return bookingdates;
    }

    public static JSONObject reqBodyOlustur2(String firstname, String lastname,int totalprice, boolean depositpaid, JSONObject bookingdate,String additionalneeds){

        JSONObject bookingdates=new JSONObject();
        bookingdates.put("checkin" , "2021-06-01");
        bookingdates.put("checkout" , "2021-06-10");
        JSONObject reqBody=new JSONObject();
        reqBody.put("firstname","Murat");
        reqBody.put("lastname","Yiğit");
        reqBody.put("totalprice",1500);
        reqBody.put("depositpaid",true);
        reqBody.put("bookingdate",bookingdates);
        reqBody.put("additionalneeds","wi-fi");

        return reqBody;

    }
/*
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
 */
public static Map<String,Object> mapDataOlustur(){




    Map<String,Object>innerMapBody=new HashMap<>();
    innerMapBody.put("checkin","2021-06-01");
    innerMapBody.put("checkout","2021-06-10");


    Map<String,Object>reqMapBody=new HashMap<>();
    reqMapBody.put("firstname" , "Ahmet");
    reqMapBody.put("lastname" , "Bulut");
    reqMapBody.put("totalprice" , 500.0);
    reqMapBody.put("depositpaid" , false);
    reqMapBody.put("additionalneeds" , "wi-fi");
    reqMapBody.put("bookingdates",innerMapBody);
    return reqMapBody;
}
public static Map<String,Object>expMapDataOlustur(){

    Map<String,Object> expMapBody= new HashMap<>();
    expMapBody.put("bookingid",25);
    expMapBody.put("booking",mapDataOlustur());
    return expMapBody;
}
}
