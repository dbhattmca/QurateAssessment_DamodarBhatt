package com.tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableTest {
	
	

	public void testWebTable()
	{
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://demoqa.com/webtables");
	        
	        HashMap<String,String> student =  new HashMap<String,String>();
	        List<LinkedHashMap<String, String>> allTableData = new ArrayList<LinkedHashMap<String, String>>();
	        
	        List<String> columnsname= new ArrayList<String>();
	 
	        //Store the table size
	        WebElement webtable = driver.findElement(By.xpath("//div[contains(@class,'ReactTable')]"));
	        
	        //Get the rows which has data
	        List<WebElement> rowsWithData = webtable.findElements(By.xpath("//div[contains(@class,'rt-td') and text()]/ancestor::div[contains(@class,'rt-tr-group')]"));
	        
	      List<WebElement> tablecolumsname =webtable.findElements(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/div[3]/div[1]/div[1]"));
	   
	      
	      LinkedHashMap<String, String> eachRowData = new LinkedHashMap<>();
	      
	      for (int i = 2; i <= rowsWithData.size(); i++) {
	    	  
	    	  String specificRowLoc="";
	      }
	        
	        
	        
	        //Print the text of 2nd row        
	        //System.out.println("Data of 2nd row is: \n" + rowsWithData.get(1).getText());
	        System.out.println(student);
	        driver.quit();
		
	}
	
	@Test
	
	public void  datadriver()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
		driver.get("http://omayo.blogspot.com/");
		// Let's get header first
				String headerLoc = "//*[@id=\"table1\"]//tr/th";
				List<WebElement> allHeadersEle = driver.findElements(By.xpath(headerLoc));
				List<String> allHeaderNames = new ArrayList<String>();
				for (WebElement header : allHeadersEle) {
					String headerName = header.getText();
					allHeaderNames.add(headerName);
				}
				
				// Each row will be a key value pair. So we will use LinkedHashMap so that order
				// can be retained.
				// All map will be added to a list.
				List<LinkedHashMap<String, String>> allTableData = new ArrayList<LinkedHashMap<String, String>>();
 
				// Get total rows count
				String rowLoc = "//table[@id='table1']//tr";
				List<WebElement> allRowsEle = driver.findElements(By.xpath(rowLoc));
				for (int i = 2; i <allRowsEle.size(); i++) {
					// Getting specific row with each iteration
					String specificRowLoc = "//table[@id='table1']//tr[" + i + "]";
					// Locating only cells of specific row.
					List<WebElement> allColumnsEle = driver.findElement(By.xpath(specificRowLoc))
							.findElements(By.tagName("td"));
					// Creating a map to store key-value pair data. It will be created for each
					// iteration of row
					LinkedHashMap<String, String> eachRowData = new LinkedHashMap<>();
					// Iterating each cell
					for (int j = 0; j < allColumnsEle.size(); j++) {
						// Getting cell value
						String cellValue = allColumnsEle.get(j).getText();
						// We will put in to map with header name and value with iteration
						// Get jth index value from allHeaderNames and jth cell value of row
						eachRowData.put(allHeaderNames.get(j), cellValue);
					}
					// After iterating row completely, add in to list.
					allTableData.add(eachRowData);
				
	}

				System.out.println(allTableData);
	}
}

