import static org.junit.Assert.*;

import org.junit.Test;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;


import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import static com.jayway.restassured.RestAssured.given;

public class PromedioTest {

	String baseURL = "http://localhost:8080";
	String path = "/cloudBRT/api/ubicacion/promedio10";
	
	@Test
	public void httpPost() 
		throws JSONException,InterruptedException{
		
		String url = baseURL + path;
		
		//Inicializamos URL Rest API
		String APIUrl = url;
		
		//Inicializamos body de la API
		String APIBody = "{\"placa\": \"ZOE 101\",\"coordenada\":{\"latitud\": \"9.113633\",\"longitud\":\"-72.114842\"} }";
		
        //Solicitud de Construccion por medio de RequestSpecBuilder
		RequestSpecBuilder builder = new RequestSpecBuilder();
		
		builder.setBody(APIBody);
		builder.setContentType("application/json");
		
		RequestSpecification requestSpec = builder.build();
		


		Response response = given().spec(requestSpec).when().post(APIUrl);
		
		JSONObject JSONResponseBody= new JSONObject(response.body().asString());
		int result = JSONResponseBody.getInt("capacidad");
		
		Assert.assertEquals(result,100);
		
	}

	

}
