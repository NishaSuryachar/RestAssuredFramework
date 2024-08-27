package practice;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class Sample2 {

	@Test
	public void sample2()
	{
		get("https://reqres.in/api/users?page=2").then().log().all();
	}
}
