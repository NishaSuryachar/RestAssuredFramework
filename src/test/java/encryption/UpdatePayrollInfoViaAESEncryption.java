package encryption;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
public class UpdatePayrollInfoViaAESEncryption {

	@Test
	public void sampleTest() throws Exception
	{
		EncrypAndDecryptUtility ed=new EncrypAndDecryptUtility();

		String jBody="{ \"employee\": { \"empId\":\"NH_00195\", \"designation\": \"TestEngineer\", \"dob\": \"09/10/1994\", \"email\": \"nishams228@gmail.com\", \"empName\": \"user10_306\", \"experience\":  4.0, \"mobileNo\": \"9123456789\", \"project\": \"Airtel_306\", \"role\": \"ROLE_EMPLOYEE\", \"username\": “user10_306” }, \"basicPlusVda\": 0, \"hra\": 200, \"insurance\": 200, \"lta\": 200, \"lwf\": 200, \"netPay\": 200, \"payroll_id\": 160, \"pf\": 100, \"pt\": 333, \"stat_bonus\": 3333, \"status\": “Active” }";
		String jsonReqBody = ed.encrypt(jBody, "Ac03tEam@j!tu_#1");
		System.out.println(jsonReqBody);
		Response res = given().body(jsonReqBody)
				.when()
				.put("http://49.249.28.218:8091/payroll");
		res.then().log().all();

		String resBody = ed.decrypt(jsonReqBody, "Ac03tEam@j!tu_#1");
		System.out.println(resBody);
	}

}
