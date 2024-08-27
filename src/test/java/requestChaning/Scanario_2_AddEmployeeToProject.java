package requestChaning;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.utility.EmployeePojo;
import pojoClass.utility.ProjectPojo;

public class Scanario_2_AddEmployeeToProject {

	@Test
	public void sampleTest()
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
			    String projectName = res.jsonPath().get("projectName");
			    System.out.println(projectName);
			    
			    //API-2 add employee to same project
			    EmployeePojo empObj=new EmployeePojo("TestEngineer","09/10/1994","nishams228@gmail.com",
			    		"user10_"+ranInt,4,"9123456789",projectName,"ROLE_EMPLOYEE","user10_"+ranInt);
			   given().contentType(ContentType.JSON).body(empObj)
			   .when()
			   .post("http://49.249.28.218:8091/employees")
			   .then().assertThat().statusCode(201)
			   .log().all();
			    
	}
}
