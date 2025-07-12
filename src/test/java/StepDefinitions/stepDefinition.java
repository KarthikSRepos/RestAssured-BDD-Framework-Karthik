package StepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.RestAssured.Resources.AddPlaceAPI;
import com.RestAssured.Resources.DeletePlaceAPI;
import com.RestAssured.Resources.EnumResources;
import com.RestAssured.Utilities.Utilities;
import com.RestAssured.pojo.AddPlace;
import com.RestAssured.pojo.Location;

import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class stepDefinition extends Utilities {
	RequestSpecification req;
	RequestSpecification reqspec;
	ResponseSpecification resspec;
	static Response response;
	Response getApiresponse;
	EnumResources enums;
	static String place_Id;

	AddPlaceAPI data = new AddPlaceAPI();
	DeletePlaceAPI deletedata= new DeletePlaceAPI();

	@Given("Add Place payload with {string} {string} {string}")
	public void add_place_payload(String Name, String Language, String Address) throws IOException {

		req = given().spec(AddRequest()).body(data.TestDataAddPlace(Name, Language, Address));

		

	}

	@When("user calls {string} request using {string} Https request")
	public void user_calls_request_using_https_request(String resource, String method) {
		resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
		// Here we are calling enum to pass the resources. Enum are in Final and Static
		// by Nature. We dont have to create an object.
		enums = EnumResources.valueOf(resource);
		//System.out.println(EnumResources.AddPlaceAPI.getResource());
		System.out.println(enums.getResource());

		if (method.equalsIgnoreCase("GET")) {
			response = req.log().all().when().get(enums.getResource()).then().spec(resspec).log().all().extract().response();
		} else if (method.equalsIgnoreCase("POST")) {
			response = req.log().all().when().post(enums.getResource()).then().spec(resspec).log().all().extract().response();
		} else if (method.equalsIgnoreCase("DELETE")) {
			response = req.when().delete(enums.getResource()).then().spec(resspec).extract().response();
		}
	}

	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
		assertEquals(response.getStatusCode(), 200);
		// System.out.println(response.toString());
		// System.out.println(response);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String value) {
		System.out.println("Test");
		System.out.println(getJsonPath(response, key));

		assertEquals((getJsonPath(response, key)), value);

	}

	@Then("verify whether place_id created maps to {string} in {string}")
	public void verify_whether_place_id_created_maps_to_in(String name, String resource) throws IOException {
		// EnumResources.valueOf(resource);
		place_Id = getJsonPath(response, "place_id").toString();
		//System.out.println(place_Id);
		req = given().spec(GetRequest(place_Id));
		user_calls_request_using_https_request(resource, "GET");
		//getApiresponse = req.log().all().when().get(enums.GetPlaceAPI.getResource()).then().spec(resspec).log().all().extract().response();
		System.out.println(response.statusCode());
		System.out.println(getJsonPath(response, "name"));

		assertEquals(getJsonPath(response, "name"), name);
		System.out.println(place_Id);
	}
	

	@Given("DeletePlaceAPI Payload")
	public void delete_place_api_payload() throws IOException {
		//place_Id = getJsonPath(response, "place_id").toString();
		System.out.println(place_Id);
		//place_Id="sfaw5wtwesgdsdg";
		req = given().spec(DeleteRequest()).body(deletedata.TestDataDeletePlaceAPI(place_Id));
		System.out.println(req);
		//user_calls_request_using_https_request("DeletePlaceAPI", "POST");
		//response = req.when().post(enums.DeletePlaceAPI.getResource()).then().spec(resspec).log().all().extract().response();
		//System.out.println(response.statusCode());
		}

}
