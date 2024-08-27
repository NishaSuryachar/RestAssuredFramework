package authtest;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Auth2_0_Test {

	@Test
	public void sampleTest()
	{
		Response res=given()
		.formParam("client_id", "ninza-client")
		.formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
		.formParam("grant_type", "client_credentials")
		.log().all()
		.when()
		.post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
		res.then().log().all();
		
		String token=res.jsonPath().get("access_token");
		
		given()
		.auth().oauth2(token)
		.log().all()
		.when()
		.get("http://49.249.28.218:8091/projects")
		.then()
		.log().all();
	}
}
