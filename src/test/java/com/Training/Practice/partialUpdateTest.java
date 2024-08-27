package com.Training.Practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class partialUpdateTest {

	@Test
	public void postTest()
	{
		JSONObject jsonObjet=new JSONObject();
		jsonObjet.put("CreatedBy", "NishaS");
		
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jsonObjet.toJSONString());
	
		Response res = req.patch("http://49.249.28.218:8091/project/NH_PROJ_256");
		res.then().log().all();
		res.then().assertThat().statusCode(200);
	}
}
