package com.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.utils.WaitForHelper;


public class BasePage {
	protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    // Navigation
    // Wait for Element
    // Wait for Time
    // Click
    // WriteText
    // Read Text
    // MoveToElement

    public void goToURL(String url){
        driver.get(url);
    }

    public void waitForElementAppear(WebElement ele){
        new WaitForHelper(driver).presenceOfTheElement(ele);
    }

    public void waitForLoading(){
        new WaitForHelper(driver).implicitwait();
    }

    public void click(WebElement ele){
    	waitForElementAppear(ele);
      ele.click();
    }

    public void writeText(WebElement ele, String text){
    ele.clear();
    ele.sendKeys(text);
    }

    public String readText(WebElement ele){
        return ele.getText();
    }

    public void moveToElement(WebElement ele){
    	 waitForElementAppear(ele);
        new Actions(driver).moveToElement(ele).build().perform();
    }
    public String getAttribute(WebElement ele,String attribute)
    {
    	waitForLoading();
  	  return ele.getAttribute(attribute);
    
    }

}
