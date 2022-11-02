package day01;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest01 {


    @Test
    public void test01() {

        //set the url
        String url="https://restful-booker.herokuapp.com/booking";

        //send the request and get response
        Response response=given().when().get(url);
        response.prettyPrint();

        // 1) JUnit Assert leri ile API testi yapabiliriz.
        Assert.assertEquals("Status Kod Hatalı",200, response.getStatusCode());
        Assert.assertEquals("HTTP/1.1 200 OK", response.statusLine());
        Assert.assertEquals("application/json; charset=utf-8", response.contentType());

        // 2) assertThat ile
        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .statusLine("HTTP/1.1 200 OK");

    }
}
