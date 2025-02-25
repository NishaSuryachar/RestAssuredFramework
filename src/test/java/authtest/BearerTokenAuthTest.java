package authtest;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class BearerTokenAuthTest {

	@Test
	public void sampleTest()
	{
		given()
		.auth().oauth2("eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJsZUN3YUNPai00RXVlbzJkTFFrTmZuLXh2M0F3Nm5ZdWZtS0pINXBFWkNNIn0.eyJleHAiOjE3MTkzMDAwNDQsImlhdCI6MTcxOTI5ODMxNCwianRpIjoiMmNiNjIzNTEtZTE4MC00NmUzLTg2M2ItYmQ4NGEyMDNlMmQ3IiwiaXNzIjoiaHR0cDovLzQ5LjI0OS4yOC4yMTg6ODE4MC9hdXRoL3JlYWxtcy9uaW56YSIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiI0ODVlYTJhYi1kY2MzLTQwOGItOTUxZi04NGMwM2JmZDAwMmYiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJuaW56YS1jbGllbnQiLCJzZXNzaW9uX3N0YXRlIjoiZmEwYmVhYTMtY2M1OC00NzA1LWJlZGQtMjc1YWIxNTE4ZTI0IiwiYWNyIjoiMSIsImFsbG93ZWQtb3JpZ2lucyI6WyJodHRwOi8vNDkuMjQ5LjI4LjIxODo4MDkxIl0sInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJkZWZhdWx0LXJvbGVzLW5pbnphIiwib2ZmbGluZV9hY2Nlc3MiLCJhZG1pbiIsInVtYV9hdXRob3JpemF0aW9uIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJlbWFpbCBwcm9maWxlIiwic2lkIjoiZmEwYmVhYTMtY2M1OC00NzA1LWJlZGQtMjc1YWIxNTE4ZTI0IiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJybWd5YW50cmEifQ.inQ566a439F7V2VdH4THtf6Bcdmqk1pY6j23iyxjP2EnOSIGUOMI9NtqKhZUoSx-6bMamfHgU6oMWkgk1WXnztJCtg6JTKlW0CEILzh3B2MqUp5bFKbPk7JEEBQoyQXuPK4Fjv7oFlXSV3y75aVNYSXqHFmiMbxwjiAspvcizhP2yA0qb3c926WOfV05MBTPxCbMFxkG1Pp5Wmj_i4cbiWlx3xj2kUiRB5ykBu9VNqRX3PSLMadWHzyP-LmvGTAeuQDUjckorzvHxFWwFbOq26vbgs1iEkY9WxYcdJgqNEMRCkTet6SbDRBYXF3hDxdrMIYPLNV2znaC1GHGuxYXvg")
		.log().all()
		.when()
		.get("http://49.249.28.218:8091/projects")
		.then().log().all();
	}
}
