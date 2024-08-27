package typesOfParameter;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
public class PathParameterTest {

	@Test
	public void sampleTest()
	{
		 given()
		.pathParam("projectId", "NH_PROJ_6885")
		.get("http://49.249.28.218:8091/project/{projectId}")
		.then().log().all();
	}
}
