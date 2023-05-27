package com.qa.api.gorest.util;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import io.restassured.path.json.JsonPath;


public class Tokens {

	
	public static Map<Object, Object> appTokenMap;
	
	public static Map<String,String> tokenMap = new HashMap<String,String>();
	
	public static String ClientID ="c922ddb2f847e958f218860e4dd19e5e49d29609257670988039ac6";
	
	
	public static Map<Object,Object> getAccessToken() {
		
		Map<String,String> formParams = new HashMap<String, String>();
		formParams.put("refresh_token", "97c922ddb2f847e958faa42492218860e4dd19e5e49d29609257670988039ac6");
		formParams.put("client_id", "c922ddb2f847e958f218860e4dd19e5e49d29609257670988039ac6");
		formParams.put("client_secret", "ddb2f847e958faa42492218860e4dd19e5e49d29609257670988039ac6");
		formParams.put("grant_type", "7e958faa42492218860e4dd19e5e49d29609257670988039ac6");
		
		JsonPath tokenJson =
		given()
			.formParams(formParams)    // This formParam having overloaded other method , we take this as an formParam <Map> , as we are using HashMAP
		.when()
			.post("https://api.imgur.com/oauth2/token")
		.then()
			.extract().jsonPath();  // with extract().jsonPath we can extract all the attribute from response body. 
									// In case of extract().path() we can extract one particular attribute from response body.
		
		
		System.out.println(tokenJson.getMap("")); // will be using the token we craeted with dot map overloaded value 
												// and pass the blank double quote "" which mean we need complete response body information.
		
		
		 appTokenMap =tokenJson.getMap(""); 
		
		return appTokenMap;
	}
	
	
	
	public static Map<String, String> getAuthToken() {
		String authToken =appTokenMap.get("access_token").toString();
		System.out.println("your Auth Token is :" +authToken);
		tokenMap.put("Authorization", "Bearer"+authToken);
		return tokenMap; 
	}
	
	
	public static Map<String, String> getClientID() {
		System.out.println("your Client id is :" + ClientID);
		tokenMap.put("Authorization", "Client-ID"+ ClientID);
		return tokenMap; 
	}
	
	
	

	// This tokenJson will give you all the required tokens from response body and using any one useful response we can hit our application apis.
	//i.e we can pass the one of the token from the response body as header/bearer token and hit our APIs.
	
	
	
	
	
	
	
	
	
	
	
}
