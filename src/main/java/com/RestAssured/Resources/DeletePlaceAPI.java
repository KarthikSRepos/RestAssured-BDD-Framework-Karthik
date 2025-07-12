package com.RestAssured.Resources;

import com.RestAssured.pojo.DeletePlace;

public class DeletePlaceAPI {
	DeletePlace d = new DeletePlace();

	public DeletePlace TestDataDeletePlaceAPI(String place_id) {
		d.setPlace_id(place_id);
		
		return d;
	}

}
