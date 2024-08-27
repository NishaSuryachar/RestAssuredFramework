package com.Sample.crud.withBDDTest;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForCompleteUpdateTest {

	@Test
	public void putDataFromServer()
	{
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("createdBy", "Nisha");
		jsonObj.put("projectName", "TekPyramids");
		jsonObj.put("status", "created");
		jsonObj.put("teamSize", "8");
		
		given()
		.contentType(ContentType.JSON)
		.body(jsonObj.toJSONString())
		.when()
		.put("http://49.249.28.218:8091/project/NH_PROJ_262")
		.then()
		.assertThat().statusCode(200)
		.log().all();
	}
}
