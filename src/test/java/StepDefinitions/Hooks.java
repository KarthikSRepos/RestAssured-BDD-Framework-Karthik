package StepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeleteAPI")
	public void BeforeMethod() throws IOException {

		stepDefinition s = new stepDefinition();
		if (s.place_Id == null) {
			s.add_place_payload("Karthik", "English", "No 10, David street");
			s.user_calls_request_using_https_request("AddPlaceAPI", "POST");
			s.verify_whether_place_id_created_maps_to_in("Karthik", "GetPlaceAPI");
		}
	}

}
