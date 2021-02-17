package com.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class DataUtils {
	protected static Logger log = LogManager.getLogger(DataUtils.class.getName());

	static String environment = System.getProperty("env") == null ? "staging" : System.getProperty("env");
	static String testDataFile = environment.equals("prod") ? "TestDataProd.xlsx" : "TestData.xlsx";

	public static String getTestData(String sheetname, String id, String field) {
		String value = null;
		try {

			Fillo fillo = new Fillo();
			Connection connection = fillo.getConnection(
					System.getProperty("user.dir")+"/TestData.xlsx");
			String strQuery = "Select * from " + sheetname + " " + "where ID='" + id + "'";
			Recordset recordset = null;

			recordset = connection.executeQuery(strQuery);

			while (recordset.next()) {
				value = recordset.getField(field);
			}

			recordset.close();
			connection.close();

		}

		catch (Exception e) {
			e.printStackTrace();

		}
		log.info("data from excel file is " + value);

		return value;
	}
	
	
	public static List<String> getAllData(String sheetname) {
		String value = null;
		List<String>values = new ArrayList<String>();
		try {

			Fillo fillo = new Fillo();
			
			Connection connection = fillo.getConnection(
					System.getProperty("user.dir") + File.separator + testDataFile);
			String strQuery = "Select City from " + sheetname + "";
			Recordset recordset = null;

			recordset = connection.executeQuery(strQuery);

			while (recordset.next()) {
				value = recordset.getField("City");
				values.add(value);
			}

			recordset.close();
			connection.close();

		}

		catch (Exception e) {
			e.printStackTrace();

		}
		log.info("data from excel file is " + value);

		return values;
	}
	
	
	
	
	public static String WriteDataExcel(String sheetName,String cityName,String feild1,String feild2,String feild3,String feild4,String feild5)
	{
		
		String result ="Unable to read data,please cheeck stacktrace";
		
		try {
			Fillo fillo=new Fillo();
			Connection connection=fillo.getConnection(System.getProperty("user.dir")+"/TestData.xlsx");
			String strQuery="update "+ sheetName.trim() + " set Temperature='"+feild1+"',Humidity='"+feild2+"',Description='"+feild3+"',WindSpeed= '"+feild4+"',Windegree='"+feild5+"' where City='"+cityName+"'";
			
			//String strQuery ="Select * from Config where ID=\'baseUrl\'";
			System.out.println(sheetName);
			System.out.println(strQuery);
		int count =connection.executeUpdate(strQuery);
			 
			
			 
			
			connection.close();
		} catch (FilloException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
		
	}

}
