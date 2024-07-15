import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UpdateBooking extends BaseTests{



@Test
    public void updateBooking(){
    String token=createToken();
    Response response = given(spec)
            .contentType(ContentType.JSON)
            .header("Cookie","token="+token)
            .body(getJsonObject2("newName","newLastname"))
            .put("/booking/"+ getID());


}



}
