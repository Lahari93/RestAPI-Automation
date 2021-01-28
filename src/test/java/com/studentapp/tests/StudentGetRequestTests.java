package com.studentapp.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

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
	
}
