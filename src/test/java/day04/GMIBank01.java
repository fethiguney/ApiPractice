package day04;

import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import pojos.Customer;
import utilities.GMIBankBaseUrl;
import utilities.ObjectMapperUtils;

import java.io.IOException;
import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class GMIBank01 extends GMIBankBaseUrl {

    /*
http://www.gmibank.com/api/tp-customers end point'ine
request gönderin
 1) Tüm Customer bilgilerini ekrana yazdırın.
 2) Tüm Customer SSN lerini ekrana yazdırın.
 3) Tüm Customer SSN lerini text dosyası olarak kaydedin
 4) Olusturduğunuz text dosyasından  SSNleri okuyarak
    "531-95-8437", "049-43-2360", "123-34-3434" SSNlerinin olduğunu doğrulayın
 */

    @Test
    public void test() throws IOException {

        Customer [] customers;

        spec.pathParam("first", "tp-customers");

        Response response=given().spec(spec).
                headers("Authorization", "Bearer "+generateToken()).
                when().get("/{first}");


        Customer [] actualData=ObjectMapperUtils.convertJsonToJava(response.asString(), Customer [].class);
        System.out.println(Arrays.toString(actualData));
    }
}
