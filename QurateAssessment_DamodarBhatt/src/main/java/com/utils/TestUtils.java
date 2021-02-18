package com.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestUtils {
	protected static Logger log = LogManager.getLogger(DataUtils.class.getName());

	public static String uniqueNameGenerator(String prefix) {
		String result = null;
		try {
			result = prefix + System.currentTimeMillis();

		} catch (Exception e) {
			log.fatal("name generation failed for " + prefix + e.getMessage());
		}
		log.info("Unique name generated for prefix" + prefix + "is:" + result);

		return result;

	}

}
