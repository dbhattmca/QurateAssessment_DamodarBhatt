package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.BasePage;

public class AuthPage extends BasePage {

	
	WebDriver driver;
	public AuthPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

@FindBy(xpath = "//span[text()='Proceed to checkout']")
private WebElement btncheckout;



public HomePage navigateToHomePage()
{
	click(btncheckout);
	
	HomePage homePage  =PageFactory.initElements(driver, HomePage.class);
	return   homePage;
}
	

}
