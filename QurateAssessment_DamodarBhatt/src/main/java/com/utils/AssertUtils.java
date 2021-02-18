package com.utils;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import org.testng.Assert;

import com.constants.Constants;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;


public class AssertUtils {

	public static ValidatableResponse verifySchema(Response response, String jsonSchema) {

		return response.then().assertThat().body(matchesJsonSchema(jsonSchema));

	}

	public static void verifyStatusCode(int status) {

		Assert.assertEquals(status, 200);

	}

	public static void verifyResponseTime(long l) {
		Assert.assertEquals(l < Constants.maxTimeout, true);

	}

	public static void VerifyResponseData(float actual, float expected, String desc) {
		Assert.assertEquals(actual, expected, desc);

	}

	public static void VerifyResponseData(boolean actual, boolean expected, String desc) {
		Assert.assertEquals(actual, expected, desc);

	}

	public static void VerifyResponseData(String actual, String expected, String desc) {
		Assert.assertEquals(actual, expected, desc);

	}

}
