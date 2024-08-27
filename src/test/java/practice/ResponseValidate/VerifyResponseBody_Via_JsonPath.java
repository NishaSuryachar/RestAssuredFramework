package practice.ResponseValidate;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class VerifyResponseBody_Via_JsonPath {

	@Test
	public void sampleTest()
	{
		Response res = given()
			          .get("http://49.249.28.218:8091/projects-paginated");
		               res.then().log().all();
		
		res.then().assertThat().body("numberOfElements", Matchers.equalTo(20));
		res.then().assertThat().body("empty", Matchers.equalTo(false));
		res.then().assertThat().body("pageable.sort.sorted", Matchers.equalTo(false));
		res.then().assertThat().body("content[2].projectId", Matchers.equalTo("NH_PROJ_8688"));
	    res.then().assertThat().body("totalPages", Matchers.equalTo(21));
		res.then().assertThat().body("content[0].createdBy", Matchers.equalTo("Rajesh"));
		ArrayList<String> lst = res.jsonPath().get("content.projectName");
		System.out.println(lst);
		
		
//		int data = res.jsonPath().get("numberOfElements");
//		System.out.println(data);
//		
//		boolean data1=res.jsonPath().get("empty");
//		System.out.println(data1);
//		
//		boolean data2=res.jsonPath().get("pageable.sort.sorted");
//		System.out.println(data2);
//		
//	   Object projectId1 = res.jsonPath().get("content[0].projectId");
//	    System.out.println(projectId1);
	}
}
