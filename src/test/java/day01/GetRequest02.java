package day01;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest02 {

    @Test
    public void test02() {

        //set the url
        String url="https://reqres.in/api/users";

        //send the request and get response
        Response response=given().when().get(url);
        response.prettyPrint();

        //Header Test
        response.then().assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .contentType(ContentType.JSON);

        //Body Test
        /* idsi 1 olanın datalarınının aşağıdaki gibi olduğunu test ediniz
             "email": "george.bluth@reqres.in",
            "first_name": "George",
            "last_name": "Bluth",
         */

        //Matcher class kullanarak
        response.then().
                body("data[0].email", equalTo("george.bluth@reqres.in")
                        , "data[0].first_name", equalTo("George"),
                        "data[0].last_name", equalTo("Bluth"));




    }
}
