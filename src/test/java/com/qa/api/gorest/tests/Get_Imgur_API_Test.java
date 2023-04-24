package com.qa.api.gorest.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.scribejava.core.model.Token;
import com.qa.api.gorest.restclient.RestClient;
import com.qa.api.gorest.util.Tokens;

import io.restassured.response.Response;

public class Get_Imgur_API_Test {

	Map<Object,Object> tokenMap;   // Decalaring the returntype of getAccessToken Map at Class level and used its tokenMap refernce in methods.
	String accessToken; // This line remember will be seen in all the projects, i.e before hitting the APIs of application get the Token.
	String accountUserName;
	String refreshToken;
	
	@BeforeMethod
	public void setup() {
		tokenMap =Tokens.getAccessToken(); //we are getting all these values from getAccessToken() method from Tokens Util class.
		accessToken= tokenMap.get("accessToken").toString(); // we are converting toString because all token.get() methods are coming fromMAP intreface. 
		accountUserName = tokenMap.get("accountUserName").toString();
		refreshToken =tokenMap.get("refreshToken").toString();
	}
	
	@Test	
	public void getAccountBlockStatusTest() {   
		
	Map<String,String> authTokenMap =Tokens.getAuthToken();	
	Response response =	RestClient.doGet(null, "https://api.imgur.com", "/account/v1"+accountUserName+"/block", authTokenMap, null, true);
		
	System.out.println(response.statusCode());
	System.out.println(response.prettyPrint());
	
	}
	
	
	@Test
	public void getAccountImageTest() {
		
	Map<String,String> authTokenMap =Tokens.getAuthToken();		
	Response response =	RestClient.doGet(null, "https://api.imgur.com", "3/account/me/images", authTokenMap, null, true);
	
	System.out.println(response.statusCode());
	System.out.println(response.prettyPrint());
	
	}
	
	@Test
	public void UploadImage_Post_APITest() {
		
		Map<String,String> clientIdMap = Tokens.getClientID();
		
		Map<String,String> formMap = new HashMap<String, String>();  // POST Upload images need parameter formType so we initialized as MAP.
		formMap.put("title", "test title API");
		formMap.put("description", "test description API");
		
		
		Response response =	RestClient.doPost("multipart", "https://api.imgur.com", "/3/image/", clientIdMap, null, true, formMap);
	
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
