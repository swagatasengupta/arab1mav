package rnd;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HoverFlyDemo1 {
	public static final String URI = "http://www.my-test.com";
	public static final String BASE_PATH = "/api";

	@BeforeMethod
	public void setup() {
		RestAssured.baseURI = URI;
		RestAssured.basePath = BASE_PATH;

	}

	@Test
	public void test1() {
		Response res = given().proxy("127.0.0.1",8989).get("/bookings/1");
		System.out.println("HEADER: " + res.getHeaders().toString());
		System.out.println("BODY: " + res.body().asString());
	}


	@Test
	public void test2() {
		Response res = given().proxy("127.0.0.1",8989).get("/bookings/2");
		System.out.println("HEADER: " + res.getHeaders().toString());
		System.out.println("BODY: " + res.body().asString());
		
	}
}
