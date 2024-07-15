import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DeleteMethod extends BaseTests{

    @Test
    public void deleteMethod(){
        String token=createToken();
        Response response = given(spec)
                .contentType(ContentType.JSON)
                .header("Cookie","token="+token)
                .delete("/booking/"+getID());
        System.out.println();

    }

}
