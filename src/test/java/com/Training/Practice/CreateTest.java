package com.Training.Practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateTest {

	@Test
	public void postTest()
	{
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("createdBy", "Nisha");
		jsonObject.put("projectName", "Tekpy01");
		jsonObject.put("status", "Created");
		jsonObject.put("teamSize", "10");
		
		RequestSpecification res = RestAssured.given();
		res.contentType(ContentType.JSON);
		res.body(jsonObject.toJSONString());
		
		Response req = res.post(" http://49.249.28.218:8091/addProject");
		req.then().log().all();
		req.then().assertThat().statusCode(201);
	}
}
