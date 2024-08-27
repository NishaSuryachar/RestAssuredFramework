package practice.ResponseValidate;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;
import junit.framework.Assert;

public class VerifyData_ComplexJsonXpath {

	@Test
	public void sampleTest()
	{
		Response res = given()
	    .get("http://49.249.28.218:8091/projects-paginated");
		res.then().log().all();
		List<String> lst = JsonPath.read(res.asString(),"content[*].projectName");
		for(String data:lst)
		{
		System.out.println(data);
		}
		List<String> lst1= JsonPath.read(res.asString(),".content[*].[?(@.projectName=='Airtel_2149')].projectId");
	   String actProjectId = lst1.get(0);
	  Assert.assertEquals(actProjectId,"NH_PROJ_6885");
	  
	  
	}
}
