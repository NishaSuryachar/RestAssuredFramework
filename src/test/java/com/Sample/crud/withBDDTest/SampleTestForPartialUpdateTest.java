
package com.Sample.crud.withBDDTest;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForPartialUpdateTest {

	@Test
	public void patchDataFromServer()
	{
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("projectName", "TekPy");
		given()
		.contentType(ContentType.JSON)
		.body(jsonObj.toJSONString())
		.when()
		.patch("http://49.249.28.218:8091/project/NH_PROJ_262")
		.then().assertThat().statusCode(200)
		.log().all();
	
	}
}
