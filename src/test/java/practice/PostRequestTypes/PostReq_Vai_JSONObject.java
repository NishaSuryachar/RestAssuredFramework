package practice.PostRequestTypes;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostReq_Vai_JSONObject {

	@Test
	public void postDataToServer()
	{
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("createdBy", "Nisha");
		jsonObject.put("projectName", "Teky");
		jsonObject.put("status", "Created");
		jsonObject.put("teamSize", "10");
		
	     given()
	     .contentType(ContentType.JSON)
	     .body(jsonObject.toJSONString())
		.when()
		.post("http://49.249.28.218:8091/addProject")
		.then().assertThat().statusCode(201)
		.log().all();
	
}
}
