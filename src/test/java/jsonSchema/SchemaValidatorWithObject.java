package jsonSchema;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.Random;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.mockito.internal.matchers.InstanceOf;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.jsonschema.JsonSchema;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojoClass.utility.ProjectPojo;
import static org.hamcrest.Matchers.*;
public class SchemaValidatorWithObject {

	@Test
	public void testJsonSchemaValidation()
	{Random ran=new Random();
	int ranInt = ran.nextInt(1000);
	   //Api-1===>add a project inside server
		ProjectPojo pObj=new ProjectPojo("Airtel_"+ranInt,"Created","Nisha",12);
		String schema="{\r\n"
				+ "    \"msg\": \"Successfully Added\",\r\n"
				+ "    \"createdBy\": \"Nisha\",\r\n"
				+ "    \"projectName\": \"Airtel_313\",\r\n"
				+ "    \"projectId\": \"NH_PROJ_4810\",\r\n"
				+ "    \"createdOn\": \"05/07/2024\",\r\n"
				+ "    \"status\": \"Created\"\r\n"
				+ "}";
	     Response res = given()
	    .contentType(ContentType.JSON)
	    .body(pObj)
		.when()
		.post("http://49.249.28.218:8091/addProject");
	     res.then().assertThat().statusCode(201)
	     .log().all()
	     //.and().assertThat().body("msg", Matchers.equalTo("Successfully Added"));
	     .assertThat()
	     .body(JsonSchemaValidator.matchesJsonSchema(schema))
	     .assertThat()
	     .body("msg",instanceOf(String.class))
	     .body("projectId",instanceOf(String.class))
	     .body("status",instanceOf(String.class));
	 
	}
}
