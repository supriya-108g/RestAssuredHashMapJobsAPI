package com.lms.test.restapi18;

import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.lms.test.utils18.ReadExcel_Supriya_AllDataTypes;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutRequestJobsAPI {

@Test
	
	public void HardCoded_JobsTestPutspecificPrograms()
	{
	
		
	    RestAssured.baseURI ="https://jobs123.herokuapp.com/Jobs";
		RequestSpecification httprequest = RestAssured.given();
		HashMap data=new HashMap();
		data.put("Job Title","Testing PUT");
	   // data.put("Job Company Name","RestAssuredSDET18");
	    data.put("Job Location","Pune1");
		//data.put("Job Type","NumpyNinja");
		//data.put("Job Posted time","6 hours later");
		//data.put("Job Description","Tough One");
	    data.put("Job Id","1003");
		
		
		httprequest.header("Content-Type","application/json");
		httprequest.body(data);
		Response response_1=httprequest.request(Method.PUT,"https://jobs123.herokuapp.com/Jobs");
		
		int statusCode_1 = response_1.getStatusCode();
		System.out.println("The status code recieved: " + statusCode_1);
		Reporter.log("The status code received for hard coded post"+statusCode_1);
	  
	    String responseBody_1 = response_1.getBody().asString();
		System.out.println("Hard Coded Put response Body using hash map" + responseBody_1);
		Reporter.log("Hard Coded Put response Body using hash map" + responseBody_1);
     
	} 
@Test
public void JSONParamsPUTHardCoded()

{


RequestSpecification httpRequest = RestAssured.given();

//Request payload(body value) sending along with post request

JSONObject requestParams = new JSONObject();


requestParams.put("Job Title","SDET2");
requestParams.put("Job Location","Florida");
requestParams.put("Job Id","1011");

httpRequest.header("Content-Type","application/json");
httpRequest.body(requestParams.toJSONString());


 Response response=httpRequest.request(Method.PUT,"https://jobs123.herokuapp.com/Jobs");
 int status = response.getStatusCode();
  System.out.println("Status code for PUT Method is :"+ status);
  
String statusLine = response.getStatusLine();
System.out.println("Status line is: "+ statusLine);


   System.out.println(response.asString());
   String responseBody = response.getBody().asString();
  Reporter.log("response Body" + responseBody);
   

}



   @DataProvider(name = "testputdata")
   public Object[][] getData1() throws IOException
	{
		
		String excelpath = "C:\\Users\\Supriya\\eclipse-workspace_202109NN\\18restassured\\src\\test\\resources\\TestData\\JOBSPUT.xlsx";
		String sheetname="Sheet1";
		Object data [][] =ReadExcel_Supriya_AllDataTypes.read(excelpath,sheetname);
		
		return data; 
		
	}
   

	@Test(dataProvider ="testputdata")
	
	public void HashMap_Data_Driven_Excel_testPutspecificPrograms(String JobTitle,String JobLocation,String JobId)

	{
	

	    RestAssured.baseURI ="https://jobs123.herokuapp.com/Jobs";
		RequestSpecification httprequest = RestAssured.given();
		HashMap data=new HashMap();
		data.put("Job Title",JobTitle);
	   // data.put("Job Company Name","RestAssuredSDET18");
	    data.put("Job Location",JobLocation);
		//data.put("Job Type","NumpyNinja");
		//data.put("Job Posted time","6 hours later");
		//data.put("Job Description","Tough One");
	    data.put("Job Id",JobId);
		
		
		httprequest.header("Content-Type","application/json");
		httprequest.body(data);
		Response response_1=httprequest.request(Method.PUT,"https://jobs123.herokuapp.com/Jobs");
		
		int statusCode_1 = response_1.getStatusCode();
		System.out.println("The status code recieved: " + statusCode_1);
		Reporter.log("The status code received for hard coded post"+statusCode_1);
	  
	    String responseBody_1 = response_1.getBody().asString();
		System.out.println("Hard Coded Put response Body using hash map" + responseBody_1);
		Reporter.log("Hard Coded Put response Body using hash map" + responseBody_1);
	} 

}

