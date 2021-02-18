package com.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import io.restassured.response.Response;

public class APIUtils {
	protected static Logger log = LogManager.getLogger(APIUtils.class.getName());

	private static Gson gson = new Gson();

	public static <T> T getDataFromJsonPath(Response response, String jsonPath) {

		log.info("response data from " + jsonPath + "is:" + response.jsonPath().get(jsonPath));
		return response.jsonPath().get(jsonPath);

	}

	public static LinkedTreeMap<String, Object> convertJsonToMap(String jsonString) {
		LinkedTreeMap<String, Object> jsonMap = new LinkedTreeMap<String, Object>();

		jsonMap = gson.fromJson(jsonString, jsonMap.getClass());
		log.info("converted data from json to map is " + jsonMap);

		return jsonMap;
	}

}
