package com.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.BasePage;
import com.utils.Log;
import com.utils.PropertyReader;

public class ProductListingPage extends BasePage  {
	
	int index=0;

	public ProductListingPage(WebDriver driver) {
		 super(driver );
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	}
	
	
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
    
    @FindBy(xpath = "(//form/button/span[contains(text(),'Compare')])[1]")
    private WebElement comapre;
    
    @FindBys(  @FindBy(xpath = "//div[@class='right-block']//div[@itemprop='offers']/span[@itemprop='price']"))
    private List<WebElement> itemsPrice;
    
    @FindBys(  @FindBy(xpath = "//div[@class='right-block']//h5"))
    private List<WebElement> itemsNames;
    
    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
    private WebElement signout;
    
    @FindBy(xpath ="//div[@class='header_user_info']/a")
    private WebElement signin;
    
 
  
    
 
    
    
    
 
    
  
  
    
    
    public List<String> getMenuItems(){

  	
  	  

  	  List<String> actualMenuItemsList=new ArrayList<String>();
  	  
  	  for(int i=0;i<menuItems.size();i++)
  		  
  	  {
  		  actualMenuItemsList.add(menuItems.get(i).getText());
  		 
  	  }
  	  
	  Log.info("Actutal item in List" + actualMenuItemsList);
  	 
  	  return actualMenuItemsList;
  	
  
	    
		 	    }
    
    
    public boolean verifySignOut(){

    	  boolean  dispsignout =false;
    	  
    	  String text =readText(signin);
    	  
    	  if(text.equalsIgnoreCase("Sign in"))
    	  {
    	  
    		  Log.info("Sign out is not visable");
    		  dispsignout=false;
    	  
    	
    	  }
    	  
    	  else
    	  {
    		  Log.info("Sign out is  visable");
    		  dispsignout=true; 
    	  }
    	  
    	  return dispsignout;
  	    
  		 	    }
      
    
    
    
    public  String getbtnCompareText()
    {
    
    	String actualcompareText =comapre.getText().trim();
    	
    	actualcompareText = actualcompareText .replaceAll("[^a-zA-Z]", ""); 
    	Log.info("Comapare contains"+actualcompareText.trim());
    	
    	return actualcompareText.trim();
    
    }
    
    
    
    public  void verfySignOutLink()
    {
    	
    }
    
    
    public  void verfyPrice()
    
    {
    	 List<String> actualPriceList=new ArrayList<String>();
    	 
    	 String price;
    	 
    	 
    	 
    	 for(int i=0;i<menuItems.size();i++)
     		  
     	  {
    		 price=itemsPrice.get(i).getText();
    		 price=price.replaceAll("[^0-9.]", "");
    		 System.out.println("pp"+price);
    		 actualPriceList.add(price);
    		 
    		 System.out.println( actualPriceList);
     		 
     	  }
    	
    	float highest = Float.parseFloat((actualPriceList.get(0)));
    	
    	for (int s = 0; s <actualPriceList.size(); s++){
    	    if (Float.parseFloat(actualPriceList.get(s))>highest)
    	    {
    	        highest=Float.parseFloat(actualPriceList.get(s));
    	        System.out.println("Big +"+ highest);
    	    }
    	    
    	   
    	      
    	}
    	 
    	System.out.println("higest item price" + highest);
    	price=Float.toString(highest);
//    	
    	
    	
    	String highPrice=String.format("%.2f",highest);
    	 index=actualPriceList.indexOf(highPrice)+1;
    	 System.out.println("Item found" + index);
    	     WebElement product =driver.findElement(By.xpath("(((//div[@class='right-block']//div[@itemprop='offers']/span[@itemprop='price'])[1])/ancestor::ul/li)["+index+"]"));
    	     
    	     product.click();

    	
    }
    
    public  ProductDetailsPage navigateToProductDetailsPage()
    {
    	verfyPrice();
    	
    	ProductDetailsPage  productDetailsPage =PageFactory.initElements(driver, ProductDetailsPage.class);
    	
    	
    	return productDetailsPage;
    }
    
    public String getItemName()
    {
    	   WebElement itemName =driver.findElement(By.xpath("(//div[@class='right-block']//h5)["+index+"]"));
    	   
    	   
    	   return itemName.getText();
    }

}
