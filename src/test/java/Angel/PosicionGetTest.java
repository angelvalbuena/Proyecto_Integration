package Angel;

import static org.junit.Assert.*;

import org.junit.Test;
import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
//import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

import clasesDelBRT.Coordenadas;

public class PosicionGetTest {

	String baseURL = "http://localhost:8080";
	String path = "/cloudBRT/api/Enviar/posicion";

		@Test
		public void getEnviarPosicion() throws JSONException {
		
			String url = baseURL + path;
			
			//make get request 
		Response resp = get(url);
			
			//Fetching response in JSON
			JSONObject jsonResponse = new JSONObject(resp.asString());
			
			
			//Fetching value 
			String Ruta = jsonResponse.getString("Ruta");
			String id = jsonResponse.getString("id");
			int Buses = jsonResponse.getInt("Buses");
			JSONObject Coordenada = jsonResponse.getJSONObject("Coordenada");
			Object latitud = Coordenada.get("latitud");
			Object longitud = Coordenada.get("longitud");
			
			//Asserting value
			Assert.assertEquals(Ruta, "Ruta1");
			Assert.assertEquals(Buses, 2);
			Assert.assertEquals(id, "P10XYZ325");
			//Assert.assertEquals(latitud, "8.811419390119175");
			//Assert.assertEquals(longitud, "-71.3639097579193");
		}

		
		@Test
		public void getEnviarPosicion2() throws JSONException {
			
			String url = baseURL + path;
			
			given().when().get(url).then().body(containsString("Ruta"));
			given().when().get(url).then().body(containsString("Buses"));
			given().when().get(url).then().body(containsString("Tiempo"));
			given().when().get(url).then().body(containsString("id"));
			given().when().get(url).then().body(containsString("Coordenada"));
		}
		
		@Test
		public void testStatusOK(){
			
		String url = baseURL + path;
		Response response = get(url); 
		
		String status = response.path("Ruta");
		assertNotNull(status);
		
		int stat = response.path("Buses");
		assertNotNull(stat);
		
		String sta = response.path("id");
		assertNotNull(sta);
		
		
		String statu = response.path("Tiempo");
		assertNotNull(statu);
		
		Object st = response.path("Coordenada");
		assertNotNull(st);
		
		
		JSONObject jsonResponse = new JSONObject(response.asString());
		JSONObject Coordenada = jsonResponse.getJSONObject("Coordenada");
		Object lat = Coordenada.get("latitud");
		assertNotNull(lat);
		
		Object lon = Coordenada.get("longitud");
		assertNotNull(lon);
		
	}
}
