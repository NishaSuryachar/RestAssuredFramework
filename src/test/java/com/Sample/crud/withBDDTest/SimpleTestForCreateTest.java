package com.Sample.crud.withBDDTest;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SimpleTestForCreateTest {

	@Test
	public void postDataFromServer()
	{
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("createdBy", "Nisha");
		jsonObj.put("projectName", "TekPyramid104");
		jsonObj.put("status", "created");
		jsonObj.put("teamSize", "10");
		
	   given()
	   .contentType(ContentType.JSON)
	   .body(jsonObj.toJSONString())
	   .when()
	   .post("http://49.249.28.218:8091/addProject")
	   .then()
	   .assertThat().statusCode(201)
	   .log().all();
	}
}
