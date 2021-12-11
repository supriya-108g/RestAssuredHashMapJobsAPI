/*This code is to test data driven testing for registration page only
No object repository was used for this page*/

package com.lms.test.restapi18;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.lms.test.utils18.ReadExcel_Supriya_AllDataTypes;


import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
public class PostRequestJobsAPI

{
	@Test
	
	public void HardCoded_TestPostspecificPrograms()
	{
	
		RestAssured.baseURI ="https://jobs123.herokuapp.com/Jobs";
		RequestSpecification httprequest = RestAssured.given();
		HashMap data=new HashMap();
	    data.put("Job Title","SDET TriState");
	    data.put("Job Company Name","RestAssuredSDET18");
	    data.put("Job Location","Pune1");
		data.put("Job Type","NumpyNinja");
		data.put("Job Posted time","6 hours okago");
		data.put("Job Description","Tough One");
	    data.put("Job Id","1839");
		
		httprequest.header("Content-Type","application/json");
		httprequest.body(data);
		Response response=httprequest.request(Method.POST,"https://jobs123.herokuapp.com/Jobs");
		
		int statusCode = response.getStatusCode();
		System.out.println("The status code recieved: " + statusCode);
		Reporter.log("The status code received for hard coded post"+statusCode);
	  
	    String responseBody = response.getBody().prettyPrint();
		System.out.println("Response Body is Sup Code HAshmap:" + responseBody);
		Reporter.log("Hard Coded Post response Body using hash map" + responseBody);
     
	} 



@Test(priority=2)
public void testPOSTaJobHardCoded_UsingJSOnParams()
{

   
RequestSpecification httpRequest = RestAssured.given();

JSONObject requestParams = new JSONObject();
requestParams.put("Job Title","SDET");
requestParams.put("Job Company Name","Tech Phantoms");
requestParams.put("Job Location","NewYork");
requestParams.put("Job Type","Automation");
requestParams.put("Job Posted time","6 hours ago");
requestParams.put("Job Description","Requires Experience");
requestParams.put("Job Id","12440");

httpRequest.header("Content-Type","application/json");
httpRequest.body(requestParams.toJSONString());
Response response=httpRequest.request(Method.POST,"Enter your API Details Here");
 int status = response.getStatusCode();
 System.out.println("Status code for Posting new Job is :"+ status);
 String statusLine = response.getStatusLine();
 System.out.println("Status line is: "+ statusLine);
 Assert.assertEquals(statusLine,"HTTP/1.1 200 ");
 System.out.println(response.asString());
 String responseBody = response.getBody().asString();
 Reporter.log("response Body" + responseBody);
}
	




   @DataProvider(name = "testpostdata_jobsapi")
   public Object[][] getData1() throws IOException
	{
		
		String excelpath = "C:\\Users\\Supriya\\eclipse-workspace_202109NN\\18restassured\\src\\test\\resources\\TestData\\JOBSPOST.xlsx";
		String sheetname="Sheet1";
		Object data [][] =ReadExcel_Supriya_AllDataTypes.read(excelpath,sheetname);
		
		return data; 
		
	}
   

	@Test(dataProvider ="testpostdata_jobsapi")
	
	public void HashMap_Data_Driven_Excel_testPostspecificProgramsJobsAPI(String JobTitle,String JobCompanyName,
			String JobLocation,String JobType,
			String JobPostedtime,String JobDescription,String JobId)
	{
	
		
		RequestSpecification httprequest = RestAssured.given();
  
		HashMap data=new HashMap();
	    data.put("Job Title",JobTitle);
	    data.put("Job Company Name",JobCompanyName);
	    data.put("Job Location",JobLocation);
		data.put("Job Type",JobType);
		data.put("Job Posted time",JobPostedtime);
		data.put("Job Description",JobDescription);
	    data.put("Job Id",JobId);
		
		httprequest.header("Content-Type","application/json");
		httprequest.body(data);
		Response response=httprequest.request(Method.POST,"https://jobs123.herokuapp.com/Jobs");
		int statusCode = response.getStatusCode();
		System.out.println("The status code recieved: " + statusCode);
		Reporter.log("The status code received for post"+statusCode);
		
	    System.out.println("Response body: " + response.body().asString());
	    String responseBody = response.getBody().prettyPrint();
		System.out.println("Response Body is Sup Code HAshmap:" + responseBody);
		Reporter.log("Post response Body using hash map data driven" + responseBody);
      
	} 
}
	
	

	