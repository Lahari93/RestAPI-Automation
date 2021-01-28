package com.studentapp.tests;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateStudentStringPayloadTest extends TestBase {

	
	//POST Call with status 201 with String as Payload

	@DisplayName("Create a new student by sending payload as String")
	@Test
	void createNewStudent() {
		
		String payload = "{\"firstName\":\"test2\",\"lastName\":\"User\",\"email\":\"test5@gmail.com\",\"programme\":\"ComputerScience\",\"courses\":[\"C++\",\"JAVA\"]}";
		
		given()
		.when()
		.contentType(ContentType.JSON)
		.when()
		.body(payload)
		.post()
		.then()
		.statusCode(201);
	}
}
