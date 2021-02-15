package com.studentapp.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class StudentGetRequestTests extends TestBase{
	
	private void styles(){
		
		RestAssured.given()
		         .queryParam("", "")
				.when()
				.get("https://www.google.com/")
				.then();
		
		
		RestAssured.given()
					.expect()
					.when();
		
	}

	
	@DisplayName("Getting all the student from the database")
	@Test
	void getAllStudents() {
		
		
		RestAssured.given()
				   .when()
		           .get("/list")
		           .then()
		           .statusCode(200);
		
		RestAssured.given()
					.expect()
					.statusCode(200)
					.when()
					.get("/list");
		
		given()
		   .when()
		   .get("/list")
		   .then()
		   .statusCode(200);//Validation 
		
	}
	
	
	@DisplayName("Get a single CS student from the list")
	@Test
	void getSingleCSStudent() {
		
		Map<String,Object> params =  new HashMap<String, Object>();
		params.put("programme", "Computer Science");
		params.put("limit",1);
		
		
		Response response = 
		given()
		.queryParams(params)
		.when()
		.get("/list");
		
		response.prettyPrint();
			
	}
	
	@DisplayName("PathParameterExample: Get the firstStudent")
	@Test
	void getTheFirstStudent() {
		
		Response response = 
				given()
				.pathParam("id", 2)
				.when()
				.get("/{id}");
		
		response.prettyPrint();
		
		
	}
	
	@DisplayName("HamcrestMatchers")
	@Test
	void test001() {
		
		
		 given()
			.queryParam("query", "ipod")	
			.when()
			.get("/search")
			.then()
			.body("numId", hasItem("Appleipod"));
				given()
				.queryParam("query", "ipod")	
				.when()
				.get("/search")
				.then()
				.body("numId", equalTo(10));
		
		
			
		
	}
	@DisplayName("Check Single Name in Array List")
	@Test
	void test002() {
		 given()
		.queryParam("query", "ipod")	
		.when()
		.get("/search")
		.then()
		.body("items.name", hasItem("Appleipod"));
		
		
	}
	
	@DisplayName("Check hashmap values in a list ")
	@Test
	void test003() {
		
				given()
				.queryParam("query", "ipod")	
				.when()
				.get("/search")
				.then()
				.body("items.findAll{it.name==''}", hasItems(hasEntry("name ","APPLEIpod")));
		
		
	}
	@DisplayName("Multiple Assertions")
	@Test
	void test004() {
		
		
				given()
				.queryParam("query", "ipod")	
				.when()
				.get("/search")
				.then()
				.body("numId", equalTo(10))
				.body("items.findAll{it.name==''}", hasItems(hasEntry("name ","APPLEIpod")));
			    
		
	}
	
	
	
}
