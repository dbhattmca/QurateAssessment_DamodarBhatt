package com.utils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForHelper {
	  public WebDriver driver;

	    public WaitForHelper(WebDriver driver){
	        this.driver = driver;
	    }

	    public void implicitwait(){
	        // #Todo We need to change or get it from the Property
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    }

	    // Presen Of Element
	    public WebElement presenceOfTheElement(final WebElement elementIdentier){
	        WebElement element = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(elementIdentier));
	        return element;
	    }
	    
	    
	    public WebElement presenceOfTheEle(final WebElement elementIdentier){
	    	
    Wait<WebDriver> wait = new FluentWait<>(driver)
    		.withTimeout(Duration.ofSeconds(30))
    		.pollingEvery(Duration.ofSeconds(5))
    		.ignoring(NoSuchMethodException.class);
	        WebElement element = wait.until(new Function<WebDriver, WebElement>() {

				@Override
				public WebElement apply(WebDriver d) {
					// TODO Auto-generated method stub
					return d.findElement(By.id("firstname"));
				
			
	    }}
	        );
			return element;
	    }

	    // elementToBeClickable
	    public WebElement elementToBeClickable(final By elementIdentier){
	        WebElement element = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(elementIdentier));
	        return element;
	    }
	    public void sendtext(WebElement e,String text)
	    {
	    	
	    	JavascriptExecutor js = (JavascriptExecutor)driver;
	    	
	    	js.executeScript("document.getElementById("+e+").value='"+text+"'");
	    	
	    }

}
