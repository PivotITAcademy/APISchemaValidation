package com.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isA;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import pojo.BookingDates;
import pojo.CreateBookingRequest;
import pojo.CreateBookingResponse;

public class RestFulApiTest {

	Faker faker = new Faker();

	@Test
	public void createBookingSchemaValidation() throws FileNotFoundException {
		CreateBookingRequest createBookingRequest = new CreateBookingRequest();
		String fName = faker.name().firstName();
		createBookingRequest.setFirstname(fName);
		createBookingRequest.setLastname(faker.name().lastName());
		createBookingRequest.setTotalprice(111);
		createBookingRequest.setDepositpaid(true);
		createBookingRequest.setBookingDates(new BookingDates("2018-01-01", "2018-01-05"));
		createBookingRequest.setAdditionalneeds("breakfast");

		
		String request = null;
		try {
			request = new ObjectMapper().writeValueAsString(createBookingRequest);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FileReader fileReader = new FileReader(new File("src/test/schema.json"));
		
		System.out.println(fileReader);
		
	//Schemavalidation
		given().baseUri("https://restful-booker.herokuapp.com/booking").header("Content-Type", "application/json").body(request).log().all().when().post().then().log().all()
				.statusCode(200).body(JsonSchemaValidator.matchesJsonSchema(fileReader));

	}
	
	@Test
	public void createBookingPojoParsing() throws JsonMappingException, JsonProcessingException  {
		CreateBookingRequest createBookingRequest = new CreateBookingRequest();
		String fName = faker.name().firstName();
		createBookingRequest.setFirstname(fName);
		createBookingRequest.setLastname(faker.name().lastName());
		createBookingRequest.setTotalprice(111);
		createBookingRequest.setDepositpaid(true);
		createBookingRequest.setBookingDates(new BookingDates("2018-01-01", "2018-01-05"));
		createBookingRequest.setAdditionalneeds("breakfast");

			//Converting pojo to a string
		String request = null;
		try {
			request = new ObjectMapper().writeValueAsString(createBookingRequest);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

		Response response =   given().baseUri("https://restful-booker.herokuapp.com/booking").header("Content-Type", "application/json").body(request).log().all().when().post();

		//Converting response body to pojo
		CreateBookingResponse createBookingResponse = new ObjectMapper().readValue(response.getBody().asString(), CreateBookingResponse.class);
		
		System.out.println(createBookingResponse.getBookingid());
	}
}
