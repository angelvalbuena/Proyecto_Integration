package Angel;

import static org.junit.Assert.*;

import org.junit.Test;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PosiurlTest{

	@Test
    public void basicPingTest() {
        given().when().get("http://localhost:8080/cloudBRT/api/Enviar/posicion")
        .then().statusCode(200);
    }
	
	@Test
    public void invalidParkingSpace() {
        given().when().get("/cloudBRT/slots/999")
            .then().statusCode(404);
    }

}
