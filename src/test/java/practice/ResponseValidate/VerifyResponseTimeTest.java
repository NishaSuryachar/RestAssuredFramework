package practice.ResponseValidate;
import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class VerifyResponseTimeTest {

	@Test
	public void verifyHeader()
	{
		Response res = given()
		.get("http://49.249.28.218:8091/projects");
		res.then().log().all();
		//milli seconds
//		long timeTaken = res.time();
//		//seconds
//		long timeTakenInSec = res.timeIn(TimeUnit.SECONDS);
//		System.out.println(timeTaken);
//		System.out.println(timeTakenInSec);
		res.then().assertThat().time(Matchers.lessThan(9000L));
		res.then().assertThat().time(Matchers.greaterThan(500L));
		res.then().assertThat().time(Matchers.both(Matchers.lessThan(9000L)).and(Matchers.greaterThan(500L)));
	}
}
