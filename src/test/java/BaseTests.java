import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;

import java.awt.geom.RectangularShape;
import java.util.Arrays;

//import static com.sun.tools.doclint.Entity.and;
import static io.restassured.RestAssured.given;

public class BaseTests {
    RequestSpecification spec;

    @BeforeEach
            public void setUp() {
         spec = new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com")
                .addFilters(Arrays.asList(new RequestLoggingFilter(),new ResponseLoggingFilter()))
                .build();

    }

    public String getJsonObject(){
        JSONObject body =new JSONObject();
        JSONObject bookingdate= new JSONObject();
        //bookingdate obyekti yaradiriq
        bookingdate.put("checkin","2020-10-10");
        bookingdate.put("checkout","2022-10-10");

        body.put("firstname","ilkin");
        body.put("lastname","adil");
        body.put("totalprice",2000);
        body.put("depositpaid",false);
        body.put("bookingdates",bookingdate);
        body.put("additionalneeds","dinner");

        return body.toString();
    }


    public String getJsonObject2(String newName, String newSurname) {
        JSONObject body = new JSONObject();
        JSONObject bookingdate = new JSONObject();
        //bookingdate obyekti yaradiriq
        bookingdate.put("checkin", "2020-10-10");
        bookingdate.put("checkout", "2022-10-10");

        body.put("firstname", newName);
        body.put("lastname", newSurname);
        body.put("totalprice", 2000);
        body.put("depositpaid", false);
        body.put("bookingdates", bookingdate);
        body.put("additionalneeds", "dinner");

        return body.toString();
    }
    public Response createBooking2(){

        Response response=given(spec)
                .when()
                .contentType(ContentType.JSON)
                .body(getJsonObject())
                .post("/booking");
        response.prettyPrint();
        return response;
    }
public int getID() {
    Response response = createBooking2();
    return response.jsonPath().getJsonObject("bookingid");
}
    public String createToken(){
        JSONObject body= new JSONObject();
        body.put("username","admin");
        body.put("password","password123");

        Response response=given(spec)
                .when()
                .contentType(ContentType.JSON)
                .body(body.toString())
                .post("/auth");
        response
                .then()
                .statusCode(200);
        return response.jsonPath().getJsonObject("token");
//    return token.toString();
    }
}
