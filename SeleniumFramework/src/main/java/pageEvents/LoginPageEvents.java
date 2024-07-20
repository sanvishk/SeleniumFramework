package pageEvents;

import org.testng.Assert;

import pageObjects.LoginPageElements;
import utils.FetchElement;

public class LoginPageEvents {
	FetchElement ele= new FetchElement();
	
	
	public void checkLoginButtonPresent()
	{
		
		
		Assert.assertTrue(ele.getWebElements("XPATH", LoginPageElements.LoginButton).size()==0, "Element is not Present");
		
	}
	
	public void Login()
	{
		ele.getWebElement("XPATH", LoginPageElements.emailField).sendKeys("santoshs@gmail.com");
		ele.getWebElement("CSS", LoginPageElements.PasswordField).sendKeys("Password123");
		//ele.getWebElement("XPATH", LoginPageElements.LoginButton).click();
		
		
	}
	


}
