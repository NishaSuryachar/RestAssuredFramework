package com.Training.Practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CompleteUpdateTest {

	@Test
	public void postTest()
	{
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("createdBy", "NishaMS");
		jsonObject.put("projectName", "Tekpy03");
		jsonObject.put("status", "Created");
		jsonObject.put("teamSize", "9");
		
		RequestSpecification res = RestAssured.given();
		res.contentType(ContentType.JSON);
		res.body(jsonObject.toJSONString());
		
		Response req = res.put("http://49.249.28.218:8091/project/NH_PROJ_255");
		req.then().log().all();
		req.then().assertThat().statusCode(200);
	}
}
