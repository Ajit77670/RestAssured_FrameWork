package com.qa.api.gorest.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.qa.api.gorest.restclient.RestClient;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;


@Epic("Get User gorest API feature implemaentation.....")
@Feature("get user api feature.....")
public class GetUserTest {

	
	String baseURI = "https://gorest.co.in";
	String basePath ="/public-api/users";
	String token = "97c922ddb2f847e958faa42492218860e4dd19e5e49d29609257670988039ac6";

	
	@Description("get all user lists api test....verify all user list from get call")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=1)
	public void getAllUserList_APITest() {
		
		Map<String, String> authTokenMap = new HashMap<String, String>();
		authTokenMap.put("Authorization", "Bearer " + token);	
		
		
	Response response = RestClient.doGet("JSON", baseURI, basePath, authTokenMap, null, true);  // calling static  doget() method by RestClient class.
	
	System.out.println(response.asPrettyString());
	System.out.println(response.statusCode());
	
	}

	@Description("get all user lists api test....verify  queryparam  from get call")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=2)
	public void getUserWith_QueryParams_APITest() {
		
		Map<String, String> authTokenMap = new HashMap<String, String>();
		authTokenMap.put("Authorization", "Bearer " + token);	
		
		Map<String,String> params = new HashMap<String,String>();
		params.put("first_name", "John");
		params.put("gender", "male");
		
		
	Response response = RestClient.doGet("JSON", baseURI, basePath, authTokenMap, params, true);  // calling static  doget() method by RestClient class.
	
	System.out.println(response.asPrettyString());
	System.out.println(response.statusCode());
	
	}

	
}