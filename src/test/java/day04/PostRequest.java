package day04;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.CountryPost;
import utilities.GMIBankBaseUrl;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PostRequest extends GMIBankBaseUrl {

    @Test
    public void test10() {
        //https://www.gmibank.com/api/tp-countries
        //adresine yeni bir ulke ekleyin

    //set the url
    spec.pathParam("first", "tp-countries");

    //set the expected data
        CountryPost countryPost=new CountryPost("Batch81");

    //send the request and get the response
    Response response=given().headers("Authorization", "Bearer "+generateToken()).
    spec(spec).contentType(ContentType.JSON).
            body(countryPost).when().post("/{first}");
    response.prettyPrint();

    //do assertion
    CountryPost actualData=response.as(CountryPost.class);
    System.out.println(actualData);


    //do assertion
     assertEquals(countryPost.getName(), actualData.getName());



    }
}
