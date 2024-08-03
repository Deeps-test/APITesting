package stepDefination;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.builder.ResponseSpecBuilder;


import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resourses.APIResourses;
import resourses.TestDataBuild;
import resourses.Utils;

import static org.junit.Assert.*;

import java.io.IOException;


public class stepDefination extends Utils{
	RequestSpecification res; 
	ResponseSpecification respnseSpec;
	Response response;
	TestDataBuild data = new TestDataBuild();
	Utils reuse= new Utils();
	static String place_id;
	
	//@Given("Add place payload")
//	public void add_place_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete action
		 //Old
		 //res=given().spec(requestSpecififcation()).body(data.addPlacePayLoad(name, null, null));
	//}
	@Given("Add place payload with {string} {string} {string}")
	public void add_place_payload_with(String name , String language, String address) throws IOException {
	   
		 res=given().spec(requestSpecififcation()).body(data.addPlacePayLoad(name, language, address));
	    
	}
	
	@When("user calls {string} with {string} http request")
	public void user_calls_add_place_api_with_post_http_request(String resourse ,String method) {
		APIResourses resourseAPI =APIResourses.valueOf(resourse);
		System.out.println(resourseAPI.getResource()); 
		respnseSpec =new ResponseSpecBuilder().expectStatusCode(200)
				.expectBody("scope", equalTo("APP"))
				.expectHeader("Server", equalTo("Apache/2.4.52 (Ubuntu)"))
				.build();
		
		if (method.equalsIgnoreCase("POST"))
				 response =res.when().post(resourseAPI.getResource());
		else if (method.equalsIgnoreCase("GET"))
			 response =res.when().get(resourseAPI.getResource());
		else if (method.equalsIgnoreCase("DELETE"))
			 response =res.when().delete(resourseAPI.getResource());
		//then().spec(respnseSpec).extract().response();
				
	}
	
	
	
	@Then("API call call is success with status code {int}")
	public void api_call_call_is_success_with_status_code(Integer int1) {
	 
	    assertEquals(response.getStatusCode(),200);
	}
	@Then("{string}  in response body is {string}")
	public void in_response_body_is(String keyValue, String Expectedvalue) {
	 
		
		
		assertEquals(getJsonPath(response, keyValue),Expectedvalue);
		
	}
	
	
	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String resourse) throws IOException {
		 place_id =getJsonPath(response, "place_id");
		res=given().spec(requestSpecififcation()).queryParam("place_id", place_id);
		user_calls_add_place_api_with_post_http_request(resourse,"GET");
		String actualName =getJsonPath(response, "name");
		assertEquals(actualName,expectedName);
		
	   
	}
	
	@Given("Deleteplace payload")
	public void deleteplace_payload() throws IOException {
		res = given().spec(requestSpecififcation()).body(data.DeleteplacePayload(place_id));


	}
	
	/*@Then("{string} in response body is {string}")
	public void in_response_body_is(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
*/
}
