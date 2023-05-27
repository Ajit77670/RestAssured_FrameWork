package com.qa.api.gorest.restclient;

import java.io.File;
import java.util.Map;

import com.qa.api.gorest.util.TestUtil;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * This class having all the http methods which will call the apis and having generic methods
 *  for getting the response  and fetch the values from response.
 * @author Ajith Kumar
 *
 */

public class RestClient {
	
	// HTTP Methods : GET PUT POST DELETE
	
	
	/**
	 * This method is used to call GET API.
	 * @param contentType
	 * @param baseURI
	 * @param basePath
	 * @param Token
	 * @param paramsMap
	 * @param log
	 * @return This method returning response from the GET CALL 
	 */
	@Step("post call with 5 parameters {0},{1},{2},{3},{4}")
	public static Response doGet(String contentType, String baseURI,String basePath,
			Map<String, String> token,Map<String,String>paramsMap ,boolean log) {
		
		
		if(setBaseURI(baseURI)) { // calling baseURI method , if it is valid then it will get inside and gives createrequest and response method.
		RequestSpecification request = createrequest(contentType, token, paramsMap, log);// calling all request related method 
		return	getresponse("GET", request, basePath);
	}
		return null;	// if base uri is not valid it will return null.		
	}
	
	
	
	
	/**
	 * THis method is used to call POST API.
	 * @param contentType
	 * @param baseURI
	 * @param basePath
	 * @param token
	 * @param paramsMap
	 * @param log
	 * @param obj
	 * @return this method is returning response from the POST CALL.
	 */
	public static Response doPost(String contentType, String baseURI,String basePath,
			Map<String,String> token,Map<String,String>paramsMap ,boolean log, Object obj) {
		
		
		if(setBaseURI(baseURI)) { // calling baseURI method , if it is valid then it will get inside and gives createrequest and response method.
			RequestSpecification request = createrequest(contentType, token, paramsMap, log);// calling all request related method 
			addRequestPayload(request, obj);
			return	getresponse("POST", request, basePath);
	}
		return null;	// if base uri is not valid it will return null.		
	}
	
	/**
	 * 
	 * @param request
	 * @param obj
	 * @return this method will return the Payload
	 */
	public static void addRequestPayload(RequestSpecification request, Object obj) {
		
		if(obj instanceof Map) {
			request.formParams((Map<String,String>) obj);
		}else {
			String JSONPAyload =TestUtil.getSerializedJSON(obj);  // we called the POJO conversion JSON data here.
			request.body(JSONPAyload);
		}
	}
	
	/**
	 * This method is to call the baseURI and we handle with try catch in case base URI is not valid or null.
	 * @param baseURI
	 */
	private static boolean setBaseURI(String baseURI) {
		
		if(baseURI==null || baseURI.isEmpty()) {
			System.out.println("Please pass the correct URI");
			return false;
		}
		try {  
			RestAssured.baseURI= baseURI;
			return true;
		}catch(Exception e) {
		System.out.println("some exception occur while assigning the base URI with the RestAssured.");
		return false;
	}
	}
	
	
	
	
	
	/**
	 * This method is to create the RequestSpecification which have all the required field which are necessary to procees the requests. 
	 * @param contentType
	 * @param token
	 * @param paramsMap
	 * @param log
	 * @return
	 */
	private static RequestSpecification createrequest(String contentType,Map<String,String> token,Map<String,String>paramsMap ,boolean log) {
		
		//given() declaration which will give RequestSpecification
		RequestSpecification request;
		
		//if we want to generate log/or not
		if(log) {
			
			request =	RestAssured.given().log().all();
		}else {
			request =	RestAssured.given();
		}
		
		//Token Declaration
		if(token.size()>0) {
		//	request.header("Authorization","Bearer"+token);
			request.headers(token);
		}
		
		// Parameter Declaration
		if(!(paramsMap==null)) {
			request.queryParams(paramsMap); 
		}
		
		// ContentType Decalaration
		if(contentType!=null) {
			if(contentType.equalsIgnoreCase("JSON")) {
				request.contentType(ContentType.JSON);
			}
			else if(contentType.equalsIgnoreCase("XML")) {
				request.contentType(ContentType.XML);
			}
			else if(contentType.equalsIgnoreCase("TEXT")) {
				request.contentType(ContentType.TEXT);
			}	
			else if(contentType.equalsIgnoreCase("multipart")) {
				request.multiPart("image", new File ("/Users/AjitKumar/Desktop/Static_1.png"));
			}	
	}
		return request;
	}

	
	
	private static  Response getresponse(String httpMethod,RequestSpecification request, String basePath) {
		 return executeAPI(httpMethod, request, basePath);
		}
	
	
	
	
	private static Response executeAPI(String httpMethod,RequestSpecification request, String basePath) {
		
	Response response =null;
	
	switch (httpMethod) {
	
	case "GET":
		response= request.get(basePath);
		break;
		
	case "POST":
		response= request.post(basePath);
		break;
		
	case "PUT":
		response= request.put(basePath);
		break;
		
	case "DELETE":
		response= request.delete(basePath);
		break;

	default:
		
		System.out.println("Please path the correct http method...");
		break;
	}
	
		return response;
		
	}
	
	
	
	
	
	
	
	
	
	

}
