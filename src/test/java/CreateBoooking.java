import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CreateBoooking extends BaseTests{

    @Test
    public void createBooking1(){
createBooking2();
        Response response=createBooking2();

        response
                .then()
                .statusCode(200);
        Assertions.assertEquals("ilkin",response.jsonPath().getJsonObject("booking.firstname"));

    }

}

//
// "firstname" : "Jim",
//         "lastname" : "Brown",
//         "totalprice" : 111,
//         "depositpaid" : true,
//         "bookingdates" : {
//         "checkin" : "2018-01-01",
//         "checkout" : "2019-01-01"
//         },
//         "additionalneeds" : "Breakfast"
//         }'