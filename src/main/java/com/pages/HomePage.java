package com.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.BasePage;
import com.utils.Log;
import com.utils.PropertyReader;



public class HomePage extends BasePage {

	      WebDriver driver;
	      
	      @FindBy(xpath = "//*[@id=\"header_logo\"]/a")
	      private WebElement pageLogo;
	      @FindBy(name = "search_query")
	      private WebElement searchBox;
	      @FindBy(xpath = "//*[@id=\"header\"]//span[contains (text(),'empty')]")
	      private WebElement cart;
	      @FindBy(xpath = "//*[@id=\"header\"]//span/strong")
	      private WebElement phoneNumber;
	      
	      @FindBy(linkText = "Sign in")
	      private WebElement signInLink;
	      @FindBys(  @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li"))
	      private List<WebElement> menuItems;
	      
	      @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
	      private WebElement dressmenu;
	      
	      
	      @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[3]/a")
	      private WebElement dressSubmneu;
	    
	      
	      @FindBy(name = "email")
	      private WebElement  email;
	      
	      @FindBy(name = "passwd")
	      private WebElement  password;
	      
	      @FindBy(xpath = "//*[@id=\"SubmitLogin\"]/span/i")
	      private WebElement btnsignIn;
	
	
	   
	 

	    public HomePage(WebDriver driver){
	        super(driver );
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	    
	    
	    public void LaunchURL(){
	        goToURL(PropertyReader.readItem("url"));
	    }
	    
	    
	    public void verifyLogin(String useremail,String userpass)
	    {
	    	
	  
	    	writeText(email,  useremail);
	    	writeText(password,  userpass);
	    	click(btnsignIn);
	    	
	    	Log.info("Login Sucessfull");
	    }
	    
	    public String getTitle()
	    {
	    	
	  
	    	return driver.getTitle();
	    }
	    
	    public boolean verifyLogo(){
	    	
	    
	    	Log.info("Logo Found"+ pageLogo.isDisplayed());
	        return pageLogo.isDisplayed();
	    }
	    
	    public String getsearchPlaceholdertext(){
	    	  return getAttribute(searchBox,"placeholder") ;
	    }
	    
	    public String getCartText(){
	    	
	     	Log.info("Cart is"+ readText(cart));
	 	 
	 	   return readText(cart);
	 	    }
	    
	    public String getPhoneNumber(){
	    	
	    	
		 	
		 	   
		 	   return readText(phoneNumber);
		 	    }
	    
	    public String getSignIntext(){

			moveToElement(signInLink);

			Log.info("Logo Found" + getAttribute(signInLink, "title"));
	    	
	    return getAttribute(signInLink, "title");
		 	    }
	    
	    
	    public List<String> getMenuItems(){

	    	  List<String> expectedMenuItems = Arrays.asList("Women".toUpperCase(), "Dresses".toUpperCase(),"T-shirts".toUpperCase());
	    	  

	    	  List<String> actualMenuItemsList=new ArrayList<String>();
	    	  
	    	  for(int i=0;i<menuItems.size();i++)
	    		  
	    	  {
	    		  actualMenuItemsList.add(menuItems.get(i).getText());
	    		 
	    	  }
	    	  
	    	 return actualMenuItemsList;
	    	 
	 	    
	 		 	    }
	    
	    
	    
	    public ProductListingPage navigateToProductListingPage()
	    
	    {
	    	moveToElement(dressmenu);
	    	
	    	
	    	try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	click(dressSubmneu);
	    	
	    	
	    	
	    	return new ProductListingPage(driver);
	    	
	    	
	    }


}
