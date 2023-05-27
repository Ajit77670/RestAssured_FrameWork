package com.qa.api.gorest.tests;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.api.gorest.pojo.User;
import com.qa.api.gorest.restclient.RestClient;
import com.qa.api.gorest.util.ExcelUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;

public class CreateUserTest {
	
	
	String baseURI = "https://gorest.co.in";
	String basePath ="/public-api/users";
	String token = "97c922ddb2f847e958faa42492218860e4dd19e5e49d29609257670988039ac6";

	
	@DataProvider
	public Object[][] getUserData() {
	Object userData[][] = ExcelUtil.getTestData("userdata"); // userdata is excel sheet name
	 return userData; 
	}  
	
	@Description("Create the user using doPost call")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProvider="getUserData")
	public void createUserAPI_POST_Test(String first_name, String last_name, String gender, String dob, String email, String phone,
			String website, String address, String status) {
		
//		User user = new User("Aditya","Kumar","male","06-12-1999","aditya@gmail.com","90444334118","https://www.aditya.com"
//				,"123,Bangalore,Singsandra","active");
//		
		
		Map<String, String> authTokenMap = new HashMap<String, String>();
		authTokenMap.put("Authorization", "Bearer " + token);
		
		User user = new User( first_name,  last_name,  gender,  dob,  email,  phone, website,  address,  status);
		
		Response response =RestClient.doPost("JSON", baseURI, basePath, authTokenMap, null, true, user);
		
		
		System.out.println(response.statusCode());
		System.out.println(response.prettyPrint());
		
	}
	
	
	
	

}
