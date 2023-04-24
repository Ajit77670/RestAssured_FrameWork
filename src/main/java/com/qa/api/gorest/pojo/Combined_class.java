package com.qa.api.gorest.pojo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.qa.api.gorest.restclient.RestClient;
import com.qa.api.gorest.util.TestUtil;
import com.qa.api.gorest.util.Tokens;

import io.restassured.response.Response;

public class Combined_class {

	
	@Test
	public void createUserwithFull_JSON() {
		
	String token ="bc86553992chdfdhdjdjkdkakajah";
	
	Self sf = new Self("http://sf.com");
	
	Edit ed = new Edit("http://ed.com");
	
	Avatar av = new Avatar("http://av.com");
	
	Links ln = new Links(sf, ed, av);
	
	
	UserInfo user = new UserInfo("Tom", "P", "male", "09--09-1998", "tom@gmail.com", "8989898989", 
			"http://www.tom.com", "test address", "active", ln);
	
	
	String UserJSON_Payload =	TestUtil.getSerializedJSON(user);
	
	System.out.println(UserJSON_Payload);
	
	
	Map<String, String> authTokenMap = new HashMap<String, String>();
	authTokenMap.put("Authorization", "Bearer " + token);
	
	Response response =RestClient.doPost("JSON", "https://gorest.co.in", "/public-api/users", null, null, false, UserJSON_Payload);
	
	System.out.println(response.getStatusCode());
	System.out.println(response.prettyPrint());
	
	
	
	//Importand and Helpful to Remember:
	// Note : For complex JSON , use this site: jsonschema2pojo , it will generate all desired typical json classes in zip file. 
	
	// Also we dont do desearalization , because for response we get additional class as meta from server in response body
	//which will not match the schema if we do deseralization using any converter.
		
	// Better will used jsonPath().meta.sucess like that.
	
	
	}
	
}
