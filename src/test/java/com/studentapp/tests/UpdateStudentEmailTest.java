package com.studentapp.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;
import com.studentapp.model.StudentPojo;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class UpdateStudentEmailTest extends TestBase {
	
	
//Patch call
	@DisplayName("Update student email")
	@Test
	void updateStudentEmail() {
		
		StudentPojo student = new StudentPojo();
		Faker fake = new Faker();
		
		
		student.setEmail(fake.internet().emailAddress());
			
		
		given()
		.when()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.patch("/101")
		.then()
		.statusCode(200);
	}
}
