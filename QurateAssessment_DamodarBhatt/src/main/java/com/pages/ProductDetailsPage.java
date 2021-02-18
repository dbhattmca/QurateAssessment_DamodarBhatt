package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import com.qa.BasePage;





public class ProductDetailsPage extends  BasePage{

	WebDriver driver;

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	  @FindBy(xpath = "//*[@id=\"add_to_cart\"]/button/span")
	    private WebElement addToCart;
	  
	  @FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/span[1]")
	    private WebElement prodocuincart;
	 
	 @FindBy(xpath = "//div[@class='shopping_cart']/a")
	    private WebElement viewcart;
	 
	 @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[1]/span")
	    private WebElement closecart;
	 

	 @FindBy(xpath = "//*[@id=\"layer_cart_product_title\"]")
	    private WebElement productTitle;
	 @FindBy(xpath = "//*[@id=\"center_column\"]/div/div/div[3]/h1")
	    private WebElement productname;
	 


	 @FindBy(xpath = "//a[@id='button_order_cart']/span")
	    private WebElement checkOut;
	 @FindBy(xpath = "(//div[@class='shopping_cart']/a//span)[1]")
	    private WebElement itemincart;
	 
	 

	
	
	public String selctSize()
	{
		
		Select se = new Select(driver.findElement(By.xpath("//*[@id='group_1']")));
		
		// Select the option by index
		se.selectByVisibleText("M");
		
	
		
		click(addToCart);
		
		
		
			
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String productName=readText(productTitle);
		
		return productName;
	}
	

	public int checkproductcount()
	{
		
		int productcount= Integer.parseInt(readText(prodocuincart));
		
		return productcount;
	}
	
	

	public String getProductName()
	{
		
		
		
		return readText(productname);
	}
	
	
	
public String expProductName()
{
	return readText(productTitle);
}

	
	public AuthPage  proceedToCheckOut()
	{
		
		click(closecart);

		String itemincart = prodocuincart.getText();

		Assert.assertEquals(1, checkproductcount());

		moveToElement(viewcart);

		click(checkOut);

		AuthPage authPage = PageFactory.initElements(driver, AuthPage.class);
		return authPage;
	
		

		
	
	
	
		
	
	}
  
}
