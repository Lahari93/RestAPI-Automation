package com.studentapp.tests;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;
import com.studentapp.model.StudentPojo;

import io.restassured.http.ContentType;


//POST Call with status 201 with POJO Payload
public class CreateStudentPojoPayloadTest extends TestBase {

	@DisplayName("Create a new student by sending payload as an object")
	@Test
	void createNewStudent() {
		
		StudentPojo student = new StudentPojo();
		
		// using Faker Class to generate mock data
		Faker fake = new Faker();
		
		List<String> courses = new ArrayList<String>();
		courses.add("Java");
		courses.add("C++");
		
		student.setFirstName(fake.name().firstName());
		student.setLastName(fake.name().lastName());
		student.setEmail(fake.internet().emailAddress());
		
		student.setProgramme("Computer Science");
		student.setCourses(courses);
		
		given()
		.when()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.post()
		.then()
		.statusCode(201);
	}
}
