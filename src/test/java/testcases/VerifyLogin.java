package testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjectModel.homePageObjects;
import pageObjectModel.loginPageObjects;
import resources.BaseClass;
import resources.commonMethods;
import resources.storeData;

public class VerifyLogin extends BaseClass{


	//yuvraj modiifcation
	// Bhushan changes


	@Test(priority =1)
	public void verifyLoginWithValidData() throws IOException, InterruptedException {
		
		
		homePageObjects hp =new homePageObjects(driver);
		commonMethods.handleExplictWait(10, hp.clickOnmyAccount(), driver);

		hp.clickOnmyAccount().click();
		hp.clickOnLogin().click();
		
		loginPageObjects lp=new loginPageObjects(driver);
			
		lp.enterEmail().sendKeys(emailAddress);
		lp.enterPassword().sendKeys(storeData.password);
		lp.clickOnSubmit().click();
	
	    
		String actual = driver.getCurrentUrl();
		String expected= storeData.loginExpectedURL;
		
		
	
        commonMethods.handleAssertion(actual, expected); 
		
		
		hp.clickOnmyAccount().click();
		
		lp.clickOnLogout().click();
		
		String actualWarningText = lp.getlogoutConfirmationText().getText();
		String expectedWarningText = storeData.logOutExpectedConfirmationtext;
		
	    commonMethods.handleAssertion(actualWarningText,  expectedWarningText); 
		
		
	}
	
	
	
	@Test(priority=2)
	public void verifyLoginWithInValidData() throws IOException, InterruptedException {
		

		homePageObjects hp =new homePageObjects(driver);
		commonMethods.handleExplictWait(10, hp.clickOnmyAccount(), driver);

		
		hp.clickOnmyAccount().click();
		hp.clickOnLogin().click();
		
		loginPageObjects lp=new loginPageObjects(driver);
			
		lp.enterEmail().sendKeys(emailAddress);
		lp.enterPassword().sendKeys(storeData.incorrectPassword);
		lp.clickOnSubmit().click();
	
		commonMethods.handleExplictWait(15, lp.warningText(), driver);


		String actual = lp.warningText().getText();
		String expected= storeData.loginFailedExpectedText;
		
		commonMethods.handleAssertion(actual, expected);
		
	}
	
	
	
	
	
}
