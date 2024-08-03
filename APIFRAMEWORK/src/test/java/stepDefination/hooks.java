package stepDefination;

import java.io.IOException;

import io.cucumber.java.Before;

public class hooks {

	
	@Before("@deletePlace")
	public void BeforeScenario() throws IOException {
		
		stepDefination m = new stepDefination();
		if (stepDefination.place_id==null) {
			
		
		m.add_place_payload_with("Shetty", "French", "Onehunga Cape Town West");
		m.user_calls_add_place_api_with_post_http_request("addPlaceAPI", "POST");
		m.verify_place_id_created_maps_to_using("Shetty", "getplaceAPI");
	}
	}
	
}
