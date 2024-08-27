package requestChaning;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Scanario_3_getPayrollInfo {
	@Test
	public void sampleTest()
	{
		//API-1 get Auth API-1
		Response res = given()
		.formParam("client_id", "ninza-client")
		.formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
		.formParam("grant_type", "client_credentials")
		.when().
	    post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
		res.then().log().all();
		
		String tokenId = res.jsonPath().get("access_token");
		
		//API-2 getpayroll Info
       given().
       auth().oauth2(tokenId)
      .get("http://49.249.28.218:8091/admin/payrolls")
      .then().assertThat().statusCode(200).log().all();
	}
}
