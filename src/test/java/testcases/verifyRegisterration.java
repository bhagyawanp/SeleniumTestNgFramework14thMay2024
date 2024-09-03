package testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjectModel.homePageObjects;
import pageObjectModel.registerationPageObjects;
import resources.BaseClass;
import resources.commonMethods;
import resources.storeData;

public class verifyRegisterration extends BaseClass{

	@Test(priority =1)
	public void verifyRegisterationWithValidData() throws IOException, InterruptedException {
		
	
		homePageObjects hp =new homePageObjects(driver);
		
		commonMethods.handleExplictWait(10, hp.clickOnmyAccount(), driver);
		
      
		hp.clickOnmyAccount().click();
		hp.clickOnRegister().click();
		
		registerationPageObjects rp=new registerationPageObjects(driver);
			
		rp.enterFirstName().sendKeys(storeData.firstName);
		rp.enterLastName().sendKeys(storeData.lastName);
		rp.enterEmail().sendKeys(emailAddress);
		rp.Telephone().sendKeys(storeData.telePhone);
		rp.Password().sendKeys(storeData.password);
		rp.PasswordConfirm().sendKeys(storeData.confirmPassword);
		rp.PrivacyPolicy().click();
		rp.Continue().click();
		
		
		String actual = rp.getRegisterationConfirmText().getText();
		String expected= storeData.regExpectedText;
		commonMethods.handleAssertion(actual, expected);
		
	}
	

	@Test(priority=2)
	public void verifyRegisterationWithBlankData() throws IOException, InterruptedException {
		
		homePageObjects hp =new homePageObjects(driver);
		
		commonMethods.handleExplictWait(10, hp.clickOnmyAccount(), driver);

		hp.clickOnmyAccount().click();
		hp.clickOnRegister().click();
		
		registerationPageObjects rp=new registerationPageObjects(driver);
			
		rp.Continue().click();
		
		
		String FirstNameactual = rp.getfirstnameErrorText().getText();
		String FirstNameexpected =storeData.firstNameErrorExpectedresult;
	
		commonMethods.handleAssertion(FirstNameactual, FirstNameexpected);
		
		String LastNameactual = rp.getlastnameErrorText().getText();
		String LastNameexpected =storeData.lastNameErrorExpectedresult;
	
		commonMethods.handleAssertion(LastNameactual, LastNameexpected);

		
		String Emailactual = rp.getemailErrorText().getText();
        String Emailexpected =storeData.emailErrorExpectedresult;
		commonMethods.handleAssertion(Emailactual, Emailexpected);

        
		
		String Telephoneactual = rp.gettelephoneErrorText().getText();
		String Telephoneexpected =storeData.telePhoneErrorExpectedresult;
		
		commonMethods.handleAssertion(Telephoneactual, Telephoneexpected);

		
		String Passwordactual = rp.getpasswordErrorText().getText();
		String Passwordexpected =storeData.passwordErrorExpectedresult;

		commonMethods.handleAssertion(Passwordactual, Passwordexpected);

	
				
	}
}
