package com.Sample.crud.withoutBDD;

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
		jsonObj.put("projectName", "TekPyramid10");
		jsonObj.put("status", "created");
		jsonObj.put("teamSize", "10");
		
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jsonObj.toJSONString());
		
		Response res = req.post("http://49.249.28.218:8091/addProject");
		res.then().log().all();
		res.then().assertThat().statusCode(201);
	}
}
