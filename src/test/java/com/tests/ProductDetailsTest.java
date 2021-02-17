package com.tests;

import org.testng.annotations.Test;

import com.pages.AuthPage;
import com.pages.HomePage;
import com.pages.ProductDetailsPage;
import com.pages.ProductListingPage;
import com.test.BaseTest;
import com.utils.PropertyReader;

public class  ProductDetailsTest extends  BaseTest{
  @Test
  public void testProductDetails() {
	  
	  HomePage homepage = new HomePage(driver);
		homepage.LaunchURL();
	ProductListingPage	productListingPage=homepage.navigateToProductListingPage();
	
	 ProductDetailsPage   productDetailsPage  =productListingPage.navigateToProductDetailsPage();
	 
	 productDetailsPage.selctSize();
	 
	AuthPage authPage =  productDetailsPage.proceedToCheckOut();
	
HomePage homePage=	authPage.navigateToHomePage();

String useremail =PropertyReader.readItem("email");
String password =PropertyReader.readItem("password");

homepage.verifyLogin(useremail,password);
	 System.out.println(driver.getTitle());
	
 
  
  }
}
