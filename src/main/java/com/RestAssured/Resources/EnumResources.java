package com.RestAssured.Resources;

public enum EnumResources {

	// Defining enum and 
	AddPlaceAPI("/maps/api/place/add/json"),
	GetPlaceAPI("/maps/api/place/get/json"),
	DeletePlaceAPI("/maps/api/place/delete/json");
	private String resource;

	EnumResources(String resource) {
		this.resource=resource;
	}
	
	public String getResource() {
		return resource;
	}
}
