package com.Sample.crud.withoutBDD;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SimpleTestForReadTest {

	@Test
	public void getDataFromServer()
	{
		Response res = RestAssured.get("http://49.249.28.218:8091/projects");
		res.then().assertThat().statusCode(200);
		res.then().log().all();
	}
}
