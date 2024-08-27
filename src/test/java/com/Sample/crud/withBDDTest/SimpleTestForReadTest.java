   package com.Sample.crud.withBDDTest;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SimpleTestForReadTest {

	@Test
	public void getDataFromServer()
	{
		 given()
		.get("http://49.249.28.218:8091/projects")
		.then().assertThat().statusCode(200)
		.log().all();
	}
}
