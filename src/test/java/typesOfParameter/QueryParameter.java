package typesOfParameter;
import static io.restassured.RestAssured.*;


import org.testng.annotations.Test;

public class QueryParameter {
     @Test
	public void sampleTest()
	{
		given()
		.queryParam("teamSize", 10)
		.get("http://49.249.28.218:8091/project")
		.then().log().all();
	}
}
