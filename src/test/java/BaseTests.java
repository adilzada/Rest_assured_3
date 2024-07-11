import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.awt.geom.RectangularShape;

import static io.restassured.RestAssured.given;

public class BaseTests {


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
        body.put("bookindate",bookingdate);
        body.put("additionalneeds","dinner");

        return body.toString();
    }
    public Response createBooking2(){

        Response response=given()
                .when()
                .contentType(ContentType.JSON)
                .body(getJsonObject())
                .post("https://restful-booker.herokuapp.com/booking");
        response.prettyPrint();
        return response;
    }
public int getID(){
      Response response=createBooking2();
      return response.jsonPath().getJsonObject("bookingid");
}
}
