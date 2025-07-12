package com.RestAssured.Utilities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utilities {
	
	ReUsesableMethods ReUseMeth = new ReUsesableMethods();
	RequestSpecification reqspec;
	RequestSpecification reqspec1;
	RequestSpecification reqspec2;

	public RequestSpecification AddRequest() throws IOException {

		//RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		PrintStream log = null;
		try {
			log = new PrintStream(new FileOutputStream("logging.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		reqspec = new RequestSpecBuilder().setBaseUri(ReUseMeth.GetFilepath("BaseURI")).setContentType(ContentType.JSON)
				.addQueryParam("key", "qaclick123").addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();

		return reqspec;
	}
	
	public RequestSpecification GetRequest(String PlaceId) throws IOException {

		//RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		PrintStream log = null;
		try {
			log = new PrintStream(new FileOutputStream("logging1.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		reqspec1 = new RequestSpecBuilder().setBaseUri(ReUseMeth.GetFilepath("BaseURI")).setContentType(ContentType.JSON)
				.addQueryParam("place_id", PlaceId).addQueryParam("key", "qaclick123").build();

		return reqspec1;
	}
	
	public RequestSpecification DeleteRequest() throws IOException {
		
		PrintStream log = null;
		try {
			log = new PrintStream(new FileOutputStream("logging1.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		reqspec2 = new RequestSpecBuilder().setBaseUri(ReUseMeth.GetFilepath("BaseURI")).setContentType(ContentType.JSON)
				.addQueryParam("key", "qaclick123").build();

		return reqspec2;
	}
	
	public Object getJsonPath(Response response, String Key) {
		
		String res = response.asString();
		//System.out.println(res);
		JsonPath js = new JsonPath(res);
		
		return js.get(Key).toString();
	}

}
