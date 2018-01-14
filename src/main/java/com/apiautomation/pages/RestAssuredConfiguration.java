package com.apiautomation.pages;


import org.testng.Assert;
import org.testng.annotations.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class RestAssuredConfiguration {
	
	@Test
	public void configure(){
		
		Response res = RestAssured.get("https://www.googleapis.com/books/v1/volumes?q=isbn:0747532699");
		int actual_code = res.getStatusCode();
		int expected_code = 200;
		Assert.assertEquals(actual_code, expected_code);
		
	}

	
}
