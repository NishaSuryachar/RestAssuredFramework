package practice.PostRequestTypes;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostReq_Vai_HashMapObject {

	@Test
	public void postDataToServer()
	{
		HashMap<String,Object> map=new JSONObject();
		map.put("createdBy", "Nisha");
		map.put("projectName", "Tek01");
		map.put("status", "Created");
		map.put("teamSize", "10");
		
	     given()
	     .contentType(ContentType.JSON)
	     .body(map)
		.when()
		.post("http://49.249.28.218:8091/addProject")
		.then()
		.assertThat().statusCode(201)
		.log().all();
    }
}
