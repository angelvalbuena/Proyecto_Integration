package Angel;

import static org.junit.Assert.*;

import org.junit.Test;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;


import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import static com.jayway.restassured.RestAssured.given;


public class ProximidadTest {

	String baseURL = "http://localhost:8080";
	String path = "/cloudBRT/api/Proximidad/estaDentro";
	
	@Test
	public void httpPost() 
		throws JSONException,InterruptedException{
		
		String url = baseURL + path;
		
		//Inicializamos URL Rest API
		String APIUrl = url;
		
		//Inicializamos body de la API
		String APIBody = "{\"coordenada1\": { \"latitud\": \"7.137157\",  \"longitud\":\"-73.122247\"}, \"coordenada2\": { \"latitud\": \"7.136681\", \"longitud\":\"-73.122551\" } }";
		
        //Solicitud de Construccion por medio de RequestSpecBuilder
		RequestSpecBuilder builder = new RequestSpecBuilder();
		
		builder.setBody(APIBody);
		builder.setContentType("application/json");
		
		RequestSpecification requestSpec = builder.build();
		


		Response response = given().spec(requestSpec).when().post(APIUrl);
		
		JSONObject JSONResponseBody= new JSONObject(response.body().asString());
		
		
		double result = JSONResponseBody.getDouble("distancia");
		boolean resul = JSONResponseBody.getBoolean("Ubicacion");
		
		Assert.assertEquals(result,62.661620265493795,0.00001);
		Assert.assertEquals(resul,false);
		
	}

}
