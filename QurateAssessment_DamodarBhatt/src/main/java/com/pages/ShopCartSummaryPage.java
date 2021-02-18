package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.BasePage;

public class ShopCartSummaryPage extends  BasePage {
	WebDriver driver;

	public  ShopCartSummaryPage (WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	 @FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/span[1]")
	    private WebElement prodocuincart;
	 
	 @FindBy(xpath = "//div[@class='shopping_cart']/a")
	    private WebElement viewcart;
	 
	
	
	
	
	
	public int checkproductcount()
	{
		
		int productcount= Integer.parseInt(readText(prodocuincart));
		
		return productcount;
	}
	
	
	
	

	public void proceedToCheckOut()
	{
		
		moveToElement(viewcart);
	}
}
