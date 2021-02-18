package com.tests;

import com.google.gson.Gson;
import com.utils.PropertyReader;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public abstract class BaseAPITest {


	PropertyReader pr = new PropertyReader();
	
	
	protected RequestSpecification whetherSpec = new RequestSpecBuilder()
			.setBaseUri(pr.readItem("apiendpoint")).setContentType("application/json").build() 
			.log().all();


	

}
