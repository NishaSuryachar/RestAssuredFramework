package requestChaning;
import static io.restassured.RestAssured.*;

import java.util.Random;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.utility.ProjectPojo;

public class Scanario_1_Delete_Project {

	@Test
	public void postDataToServer()
	{
		//create an object to pojo class
		Random ran=new Random();
		int ranInt = ran.nextInt(1000);
	   //Api-1===>add a project inside server
		ProjectPojo pObj=new ProjectPojo("Airtel_"+ranInt,"Created","Nisha",12);
		
	     Response res = given()
	    .contentType(ContentType.JSON)
	    .body(pObj)
		.when()
		.post("http://49.249.28.218:8091/addProject");
	     res.then().assertThat().statusCode(201)
	     .log().all()
	     .and().assertThat().body("msg", Matchers.equalTo("Successfully Added"));
	     
	     //capture project name from the response
	    String projectId = res.jsonPath().get("projectId");
	    System.out.println(projectId);
	    
	    //api2-delete the project
	    given().delete("http://49.249.28.218:8091/project/"+projectId)
	    .then().assertThat().statusCode(204);
	    
	    
}
}
