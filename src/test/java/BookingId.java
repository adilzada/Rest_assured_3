//import org.testng.annotations.Test;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class BookingId extends BaseTests{
    String base_url="https://restful-booker.herokuapp.com/booking/";
    String path="3";
    String url=base_url+path;

    @Test
    public void getBookingid(){
        Response response =given(spec)
                .when()
                .get("/booking/"+getID());
        response
                .then()
                .statusCode(200);
        response.prettyPrint();

        String fname=response.jsonPath().getJsonObject("firstname");
        String lastname=response.jsonPath().getJsonObject("lastname");
        int totalPrice=response.jsonPath().getJsonObject("totalprice");
//        System.out.println(totalPrice);
        Assertions.assertEquals(109,totalPrice);
    }


}

