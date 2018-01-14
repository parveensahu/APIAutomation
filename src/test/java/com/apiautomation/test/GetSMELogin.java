package com.apiautomation.test;

import java.net.URI;
import java.net.URISyntaxException;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.apiautomation.pages.RestAssuredConfiguration;

import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;

import org.apache.http.HttpStatus;
import org.hamcrest.Matchers.*;

import common.EndPoint;

public class GetSMELogin {
	
	/*
	 * When I perform get request
	 * Given accept the response in JASON format
	 */
	@Test (groups = "demo1")
	public void validateget() throws URISyntaxException{
	//	URI uri = new URI("http://api.ofs.power2sme.com/api/v1/searchOrders?smeid=ACC455092&searchTerm=SRCR&pageindex=0&pagesize=2");
		Response response = given().accept(ContentType.JSON).when().get(new URI
				("http://api.ofs.power2sme.com/api/v1/searchOrders?smeid=ACC455092&searchTerm=SRCR&pageindex=0&pagesize=2"));
	//	Response response = RestAssured.when().get("http://api.ofs.power2sme.com/api/v1/searchOrders?smeid=ACC455092&searchTerm=SRCR&pageindex=0&pagesize=2");
		System.out.println(response.asString());
		response.then().statusCode(200);
	}

	@Test (groups = "demo")
	public void validatestatuscode() throws URISyntaxException{
	//	int actualcode = given().accept(ContentType.JSON).when().get(new URI("http://api.ofs.power2sme.com/api/v1/searchOrders?smeid=ACC455092&searchTerm=SRCR&pageindex=0&pagesize=2")).thenReturn().statusCode();
	//	Assert.assertEquals(actualcode, HttpStatus.SC_OK);
	//  There is one more way of doing it
		given().accept(ContentType.JSON).when().get(new URI(EndPoint.SEARCH_ORDER)).then().assertThat().statusCode(HttpStatus.SC_OK);
	}
/*	
	@Test (groups = "demo")
	public void validateQueryParameter(){
		
		RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification();
		requestSpecification.queryParam("smeid", "ACC455092").log().all();
		given().spec(requestSpecification).get(EndPoint.SEARCH_ORDER).then().statusCode(200).log().all();
	}
	
	@Test (groups = "demo")
	public void validatePathParameter(){
		
		RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification();
		requestSpecification.pathParam("smeid", "ACC455092").log().all();
		given().spec(requestSpecification).get(EndPoint.SEARCH_ORDER).then().statusCode(200).log().all();  
				
	}
	
	@Test (groups = "demo")
	public void validateFormParameter(){
		
		RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification();
		requestSpecification.accept(ContentType.JSON).formParams("status", "success").log().all();
		given().spec(requestSpecification).post(EndPoint.SEARCH_ORDER).then().statusCode(200).log().all();  
				
	}
*/
}
