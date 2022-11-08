package day01;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest03 {

/* Matchers ile dataları doğrulayınız
             "id": 5,
            "email": "charles.morris@reqres.in",
            "first_name": "Charles",
            "last_name": "Morris",
            "avatar": "https://reqres.in/img/faces/5-image.jpg"
     */


    @Test
    public void test03() {

        //set the url
        String url="https://reqres.in/api/users";

        //set the expected data

        //send the request and get response
        Response response=given().when().get(url);

        //Do assertion
        response.then().body("data[4].email", equalTo("charles.morris@reqres.in"),
                            "data[4].first_name", equalTo("Charles"),
                            "data[4].last_name", equalTo("Morris"),
                            "data[4].avatar", equalTo("https://reqres.in/img/faces/5-image.jpg"));


    }
}
