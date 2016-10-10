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

public class PosicionGetTest {

	String baseURL = "http://localhost:8080";
	String path = "/cloudBRT/api/Enviar/posicion";

		@Test
		public void getEnviarPosicion() throws JSONException {
		
			String url = baseURL + path;
			
			//make get request to fetch capital of norway
		Response resp = get(url);
			
			//Fetching response in JSON
			JSONObject jsonResponse = new JSONObject(resp.asString());
			
			
			//Fetching value of capital parameter
			String Ruta = jsonResponse.getString("Ruta");
			String id = jsonResponse.getString("id");
			int Buses = jsonResponse.getInt("Buses");
			//double Coordenada = jsonResponse.getDouble("Coordenada");
			
			//Asserting that Ruta is Ruta1
			Assert.assertEquals(Ruta, "Ruta1");
			Assert.assertEquals(Buses, 2);
			Assert.assertEquals(id, "P10XYZ325");
			
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
		
		/*double st = response.path("Coordenada");
		assertNotNull(st);*/
		
	}
}
