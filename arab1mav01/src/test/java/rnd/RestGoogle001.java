package rnd;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RestGoogle001 {
	
	//public static final String GOOGLE_KEY="AIzaSyC3UxHHtJ4JCP3_cyYNlzvaK00sejNrLlQ";
	public static final String GOOGLE_KEY="AIzaSyBB0GjYSOhdy6Zhrm61Stqf90rHnmm4vy4";
	
	@BeforeClass
	public void beforeClass() {
		RestAssured.baseURI = "https://maps.googleapis.com";
		RestAssured.basePath = "/maps/api";
	}

	@Test
	public void t001() {
		
		String endPoint = "/distancematrix/xml";
		
		given()
			.param("origins", "The Platina, Jayabheri Enclave, Gachibowli, Hyderabad, Telangana 500032, India")
			.param("destinations", "Hitech City Road, HITEC City, Madhapur, Hyderabad, Telangana 500081, India")
			.param("key",GOOGLE_KEY)
		.when()
			.get(endPoint)
		.then()
			.statusCode(200)
			//.body("status", equals("OK"))
			.contentType(ContentType.XML);
		
		
		
	}
	@Test
	public void t002() {
		
		String endPoint = "/distancematrix/json";
		
		given()
			.param("origins", "The Platina, Jayabheri Enclave, Gachibowli, Hyderabad, Telangana 500032, India")
			.param("destinations", "Hitech City Road, HITEC City, Madhapur, Hyderabad, Telangana 500081, India")
			.param("key",GOOGLE_KEY)
		.when()
			.get(endPoint)
		.then()
			.statusCode(200)
			//.body("status", "OK")
			.contentType(ContentType.JSON);
		
		
	}

}
