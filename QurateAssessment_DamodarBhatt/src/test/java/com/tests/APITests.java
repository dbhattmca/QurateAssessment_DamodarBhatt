package com.tests;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.constants.APIEndpoints;
import com.google.gson.internal.LinkedTreeMap;
import com.utils.APIUtils;
import com.utils.AssertUtils;
import com.utils.DataUtils;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;

/**
 * Unit test for simple App.
 */
public class APITests extends BaseAPITest {

	@Description("Verify dashboard api")
	@Severity(SeverityLevel.CRITICAL)

	@Test()
	public void testWhetherAPI() {

	// Provide city name in config.properties and report will automatic update in 
		
		List<String> cityNames =DataUtils.getAllData("Config");
		
		for (String cityName : cityNames) {
		
		Response response = given().spec(whetherSpec).when()
				.get(cityName);
		
	
		
		System.out.println(cityNames);

		Reporter.log("Response  is :" + response.getBody().asString());
		
		
		LinkedTreeMap<String, Object> map=APIUtils.convertJsonToMap(response.asString());
		

      String Temperature = (String) map.get("Temperature");
		
		
		String humidity = (String) map.get("Humidity");
		String whetherdesc = (String) map.get("Weather Description");
		String windspeed = (String) map.get("Wind Speed");
		String winddirdegree = (String) map.get("Wind Direction degree");
		
		
		DataUtils.WriteDataExcel("Config",cityName, Temperature,humidity,whetherdesc,windspeed,winddirdegree);

	}
	}
		
		
		

	}


	



