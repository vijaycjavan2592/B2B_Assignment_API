package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

public class AddUser_StepDefination extends Utils {

	RequestSpecification resp;
	public static Response response;
	public static Response get_response;
	

	public double ID;

	@Given("Add user payload with {string} and {string} and {string} and {string}")
	public void add_user_payload_with_and_and_and(String name, String username, String email, String phone)
			throws IOException {

		resp = given().spec(requestSpecification()).body(TestDataBuild.createUserPayload(name, username, email, phone));

	}

	@When("user call {string} with Post http request")
	public void user_call_with_Post_http_request(String resource) {
		//constructor will call with value of resources which you pass	
		APIResources resourceAPI = APIResources.valueOf(resource);
		//System.out.println(resourceAPI.getResource());

		response = resp.when().post(resourceAPI.getResource());
	}

	@Then("API call is sucess with status code {int}")
	public void api_call_is_sucess_with_status_code(Integer int1) {
		// Verify the response code
		assertEquals(response.getStatusCode(), 201);
		
	}

	@Then("verify {string} and {string} and {string} and {string} in response")
	public void verify_and_and_and_in_response(String name, String username, String email, String phone) {
		// Verify name field
		String actualName = jsonPath(response, "name");
		assertEquals(name, actualName);

		// Verify username field
		String actualUserName = jsonPath(response, "username");
		assertEquals(username, actualUserName);

		// Verify email field
		String actualEmail = jsonPath(response, "email");
		assertEquals(email, actualEmail);

		// Verify phone field
		String actualPhone = jsonPath(response, "phone");
		assertEquals(phone, actualPhone);

	}

	// ******************************GET added User*****************************************

	@Given("Get the id of new added user")
	public void get_the_id_of_new_added_user() {
		//Get the id of added user from response
		ID = jsonPath_int(response, ("id"));
		System.out.println("ID is : " + ID);
	}

	@When("user call {string} with Get http request")
	public void user_call_with_Get_http_request(String resource) throws IOException {
		APIResources resourceAPI = APIResources.valueOf(resource);
		get_response = given().spec(requestSpecification()).when().get(resourceAPI.getResource()+"1");  //Here pass id=1 becz when we pass dynamic id then response is not getting
	}

	@Then("then API call is sucess with status code {int}")
	public void then_API_call_is_sucess_with_status_code(Integer int1) {
		// Verify the response code
		assertEquals(get_response.getStatusCode(), 200);
	}

	// *************************Delete added user******************

}
