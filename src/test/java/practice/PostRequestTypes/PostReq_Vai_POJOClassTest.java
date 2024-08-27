package practice.PostRequestTypes;
import static io.restassured.RestAssured.*;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoClass.utility.ProjectPojo;

public class PostReq_Vai_POJOClassTest {

	@Test
	public void postDataToServer()
	{
		Random ran=new Random();
		int ranInt = ran.nextInt(1000);
		//create an object to pojo class
		ProjectPojo pObj=new ProjectPojo("NNNN"+ranInt,"Created","Nisha",12);

		given()
		.contentType(ContentType.JSON)
		.body(pObj)
		.when()
		.post("http://49.249.28.218:8091/addProject")
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
	}
}
