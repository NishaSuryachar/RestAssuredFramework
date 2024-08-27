package com.Training.Practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteTest {

	@Test
	public void postTest()
	{
		
		Response req = 	RestAssured.delete(" http://49.249.28.218:8091/project/NH_PROJ_256");
		req.then().log().all();
		req.then().assertThat().statusCode(204);
	}
}
