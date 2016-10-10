package Angel;

import static org.junit.Assert.*;

import org.junit.Test;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;


import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;





public class DistanciaTest {
	String baseURL = "http://localhost:8080";
	String path = "/cloudBRT/api/distR";
	
	@Test
	public void httpPost() 
		throws JSONException,InterruptedException{
		
		String url = baseURL + path;
		
		//Inicializamos URL Rest API
		String APIUrl = url;
		
		//Inicializamos body de la API
		String APIBody = "{\"coordenada1\": { \"latitud\": \"7.113633\",  \"longitud\":\"-73.114842\"}, \"coordenada2\": {                   \"latitud\": \"7.107283\", \"longitud\":\"-73.114035\" } }";
		
        //Solicitud de Construccion por medio de RequestSpecBuilder
		RequestSpecBuilder builder = new RequestSpecBuilder();
		
		builder.setBody(APIBody);
		builder.setContentType("application/json");
		
		RequestSpecification requestSpec = builder.build();
		


		Response response = given().spec(requestSpec).when().post(APIUrl);
		
		
		JSONObject JSONResponseBody= new JSONObject(response.body().asString());
		double result = JSONResponseBody.getDouble("distancia");
		
		Assert.assertEquals(result,711.6802842860806,0.0001);
		
	}
	
	@Test
	public void testStatusOK(){
		
	String url = baseURL + path;
	String APIUrl = url;
	
	RequestSpecification json = given();
	//RequestSpecBuilder builder = new RequestSpecBuilder();
	
	
	//builder.setContentType("application/json");
	//RequestSpecification requestSpec = builder.build();
	//Response response = given().spec(requestSpec).when().post(APIUrl);
    JsonPath jsonpath = new JsonPath(json).setRoot("results");
    
	
	 
	}

	
	

}