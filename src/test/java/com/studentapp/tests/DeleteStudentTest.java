package com.studentapp.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;
import com.studentapp.model.StudentPojo;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class DeleteStudentTest extends TestBase {
	
	//Delete Information of the student with status code 204

	@DisplayName("Delete Student from the system")
	@Test
	void deleteStudent() {
		
	
		given()
		.when()
		.contentType(ContentType.JSON)
		.when()
		.delete("/101")
		.then()
		.statusCode(204);
		
	}
}
