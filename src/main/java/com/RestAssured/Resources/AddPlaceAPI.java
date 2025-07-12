package com.RestAssured.Resources;

import java.util.ArrayList;
import java.util.List;

import com.RestAssured.pojo.AddPlace;
import com.RestAssured.pojo.Location;

public class AddPlaceAPI {

	public AddPlace TestDataAddPlace(String Name, String Language, String Address) {

		AddPlace p = new AddPlace();
		p.setAccuracy(50);
		p.setAddress(Address);
		p.setLanguage(Language);
		p.setPhone_number("(+91) 983 893 3937");
		p.setWebsite("https://rahulshettyacademy.com");
		p.setName(Name);
		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");

		p.setTypes(myList);
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);

		p.setLocation(l);
		
		return p;
	}

}
