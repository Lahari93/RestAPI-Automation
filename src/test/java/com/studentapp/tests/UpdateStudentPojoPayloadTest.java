package com.studentapp.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;
import com.studentapp.model.StudentPojo;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class UpdateStudentPojoPayloadTest extends TestBase {
	
	//put call 

	@DisplayName("Update a new student by sending payload as an object")
	@Test
	void updateStudent() {
		
		StudentPojo student = new StudentPojo();
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
		.put("/101")
		.then()
		.statusCode(200);
	}
}
