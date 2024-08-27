package com.Sample.crud.withBDDTest;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForDeleteTest {

	@Test
	public void DeleteDataFromServer()
	{
		given()
		.delete("http://49.249.28.218:8091/project/NH_PROJ_262")
		.then().assertThat().statusCode(204)
        .log().all();
		
	}
}
