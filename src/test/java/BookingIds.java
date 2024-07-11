import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
//import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BookingIds {


    @Test
    public void getBooking() {
//        System.out.println("hello testing");

//        given()
//                .when()
//                .get("https://restful-booker.herokuapp.com/booking")
//                .then()
//                .statusCode(200)
//                .log().all();

        Response response = given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking/");
        response
                .then()
                .statusCode(200);
        response.prettyPrint();

    }


}
