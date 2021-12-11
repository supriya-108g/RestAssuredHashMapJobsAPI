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

public class DeleteRequestJobsAPI {
	
	@Test(priority=1)
	public void ValidateStatusCodeforSpecificProgramIDHardCoded()
	{   
		
		RequestSpecification httpRequest = RestAssured.given();
		 HashMap data_1=new HashMap();
		data_1.put("Job Id","1014");
	    httpRequest.header("Content-Type","application/json");
		httpRequest.body(data_1);
		Response response_delete = httpRequest.request(Method.DELETE,"https://jobs123.herokuapp.com/Jobs");
		String responseBody = response_delete.getBody().prettyPrint();
	    Reporter.log("Response body for hardcoded program id  =>  "+responseBody);
		int statusCode=response_delete.getStatusCode();
		Assert.assertEquals(statusCode,200,"Correct Status Code returned");
		
	}
	
@Test(dataProvider="test1data",priority=2)
	public void DataDriven_Excel_testDeleteProgram(String JobId)
	
	{ 
		RequestSpecification httpRequest = RestAssured.given();
		 HashMap data_1=new HashMap();
		data_1.put("Job Id",JobId);
	    httpRequest.header("Content-Type","application/json");
		httpRequest.body(data_1);
		Response response_delete = httpRequest.request(Method.DELETE,"https://jobs123.herokuapp.com/Jobs");
		String responseBody = response_delete.getBody().prettyPrint();
	    Reporter.log("Response body for hardcoded program id  =>  "+responseBody);
		int statusCode=response_delete.getStatusCode();
		Assert.assertEquals(statusCode,200,"Correct Status Code returned");

	}
	
	@DataProvider(name = "test1data")

	public Object[][] getData() throws IOException
	{
	  String excelpath = "C:\\Users\\Supriya\\eclipse-workspace_202109NN\\18restassured\\src\\test\\resources\\TestData\\JOBSDELETE.xlsx";
	  String sheetname="Sheet1";
	  Object data [][] = ReadExcel_Supriya_AllDataTypes.read(excelpath,sheetname);
	  return data;
	}

	
	
	
@Test	
public void JsonHardCode_Delete()

{

    
RequestSpecification httpRequest = RestAssured.given();

JSONObject requestParams = new JSONObject();

requestParams.put("Job Id","1019");

httpRequest.header("Content-Type","application/json");
httpRequest.body(requestParams.toJSONString());

//Response Object
 Response response=httpRequest.request(Method.DELETE,"https://jobs123.herokuapp.com/Jobs");
 
 //Retrieving Status Code of response
   int status = response.getStatusCode();
   System.out.println("Status code for DELETE Method is :"+ status);
   //Assert.assertEquals(status, 200);
   

//Retrieving Status Line
   String statusLine = response.getStatusLine();
System.out.println("Status line is: "+ statusLine);
// Assert.assertEquals(statusLine,"HTTP/1.1 200 ");


   // Retrieving Body of response and printing on the console
   System.out.println(response.prettyPrint());
   String responseBody = response.getBody().asString();
   //System.out.println("Response Body is:" + responseBody);
   Reporter.log("response Body" + responseBody);
   

}

}

