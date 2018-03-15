package rnd;
import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lib.UtilLib;

import static org.hamcrest.Matchers.equalTo;

import org.json.JSONArray;
import org.json.JSONObject;


public class TwitterAPI {

	public static final String CONSUMER_KEY="6Xhd6HlKSwoBlF9enYcPiuKE6";
	public static final String CONSUMER_SECRET="XINSQnt7VC107iuMzWTwC6EmNZl4JxS8unNXPQF2ZXHK0ysmZS";
	public static final String ACCESS_TOKEN="970587063580946432-O4gjDtZseaMZzIc7GlwlyXx6uMYhXpO";
	public static final String ACCESS_TOKEN_SECRET="2Q3wHpSBYBoMrazIVTuecg56pfk95KaXs8fn0vt4FMYIE";
	
	@BeforeClass
	public void setUp() {
		RestAssured.baseURI = "https://api.twitter.com";
		RestAssured.basePath = "/1.1/statuses";
		
	}
	
	@Test
	public void t001() {
		String endPoint = "/home_timeline.json";

		Response res = given()
				.auth()
				.oauth(CONSUMER_KEY, CONSUMER_SECRET, ACCESS_TOKEN, ACCESS_TOKEN_SECRET)
				.when()
				.get(endPoint);
		System.out.println("response headers: " + res.getHeaders());
		System.out.println("response body: " + res.getBody().asString());
		
		res.then().statusCode(200);
		res.then().statusLine(equalTo("HTTP/1.1 200 OK"));


		
	}
	
	@Test
	public void t002_postTweet() {
		String endPoint = "/update.json";
		Response res = given()
			.auth()
			.oauth(CONSUMER_KEY, CONSUMER_SECRET, ACCESS_TOKEN, ACCESS_TOKEN_SECRET)
			.queryParam("status", "I am Using RestAssured to Tweet " + UtilLib.getTimeStamp())
		.when()
			.post(endPoint);
	
		System.out.println("response header: " + res.getHeaders().toString());
		System.out.println("response body: " + res.getBody().asString());
		
		JSONObject respBody = new JSONObject(res.getBody().asString());
		long tweetID =  respBody.getLong("id");
		System.out.println("tweet ID: " + tweetID);
		
		
		//System.out.println(res.body().jsonPath().getInt("id"));
	
	}
	
	

}
