package com.tests;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.AuthPage;
import com.pages.HomePage;
import com.pages.ProductDetailsPage;
import com.pages.ProductListingPage;
import com.test.BaseTest;
import com.utils.Log;
import com.utils.PropertyReader;
import com.utils.StringReader;

import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class E2Eest extends BaseTest {
	
	StringReader stringReader = new StringReader();

  
  @Description("Valdation on Home Page")
  @Step("Step 1")
	@Test(description = "Validating home page for Logo,Serach Place Holder ,catrtext etc...",priority = 0)
	
	public void testHomePage()
	{

		HomePage homepage = new HomePage(driver);
		homepage.LaunchURL();
		Assert.assertTrue(homepage.verifyLogo());

		Assert.assertEquals(StringReader.readItem("serach"), homepage.getsearchPlaceholdertext());
		Assert.assertEquals(StringReader.readItem("carttext"), homepage.getCartText());

		Assert.assertEquals(StringReader.readItem("phonenumber"), homepage.getPhoneNumber());
		Assert.assertEquals(StringReader.readItem("signintooltip"), homepage.getSignIntext());

		List<String> expectedMenuItems = Arrays.asList("Women".toUpperCase(), "Dresses".toUpperCase(),
				"T-shirts".toUpperCase());

		Assert.assertEquals(expectedMenuItems, homepage.getMenuItems());

		Log.info("Actutal item in Menu" + homepage.getMenuItems());
		
	}
  
  
  @Test(priority = 1)
  public void testProductListing() {

		HomePage homepage = new HomePage(driver);
		homepage.LaunchURL();
		ProductListingPage productListingPage = homepage.navigateToProductListingPage();
		List<String> expectedMenuItems = Arrays.asList("Women".toUpperCase(), "Dresses".toUpperCase(),
				"T-shirts".toUpperCase());
		Assert.assertEquals(expectedMenuItems, productListingPage.getMenuItems());

		Assert.assertEquals(StringReader.readItem("expectedcompareText").trim(),
				productListingPage.getbtnCompareText());
		
  }

  @Test(priority = 2)
  public void testProductDetails() {
	  
		HomePage homepage = new HomePage(driver);
		homepage.LaunchURL();
		ProductListingPage productListingPage = homepage.navigateToProductListingPage();

		ProductDetailsPage productDetailsPage = productListingPage.navigateToProductDetailsPage();

		String productname=productDetailsPage.selctSize();
		Assert.assertEquals(productname, productDetailsPage.getProductName());

		
	
 
  
  }
  
  
  
  @Test(priority = 3)
  public void testAuth() {
	  
		HomePage homepage = new HomePage(driver);
		homepage.LaunchURL();
		ProductListingPage productListingPage = homepage.navigateToProductListingPage();

		ProductDetailsPage productDetailsPage = productListingPage.navigateToProductDetailsPage();

		productDetailsPage.selctSize();
		AuthPage authPage = productDetailsPage.proceedToCheckOut();

		HomePage homePage = authPage.navigateToHomePage();

		String useremail = PropertyReader.readItem("email");
		String password = PropertyReader.readItem("password");

		homepage.verifyLogin(useremail, password);
		
 
  
  }
  
  
}
