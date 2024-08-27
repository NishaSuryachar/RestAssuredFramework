package practice;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.minidev.json.JSONObject;

public class RequestChaining {

	@Test
	public void addAddress()
	{
		JSONObject jobj=new JSONObject();
		jobj.put("addressId", 0);
		jobj.put("buildingInfo", "j.p nagar");
		jobj.put("city", "Bng");
		jobj.put("country", "India");
		jobj.put("addressId", 0);
		jobj.put("name", "Nisha");
		jobj.put("pincode", 432102);
		jobj.put("state", "karnataka");
		
        Response res = given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.post("https://www.shoppersstack.com/shopping/shoppers/{shopperId}/address");
		
		 
            given()
			.get("https://www.shoppersstack.com/shopping/shoppers/shoppers/{shopperId}/address");
			
		 
	}
}
