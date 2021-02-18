package com.tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.test.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Step;


public class HomeTest extends BaseTest {
	

	@Description("Valdation on Home Page")
    @Step("Step 1")
	@Test(description = "Validating home page for varios poinis")
	
	public void testHomePage()
	{
		
		HomePage homepage = new HomePage(driver);
		homepage.LaunchURL();
		homepage.verifyLogo();
//		//homepage.verifySearch();
//		homepage.verifyCart();
//		homepage.verifyPhoneNumber();
//		homepage.verifySignIntext();
//		homepage.verifyMenuItems();
		
	}

}
