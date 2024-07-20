package qa.test;

import org.testng.annotations.Test;
import base.BaseTest;
import pageEvents.HomePageEvents;
import pageEvents.LoginPageEvents;
import utils.FetchElement;

public class MainTest extends BaseTest {
  
	FetchElement ele= new FetchElement();
	HomePageEvents homePage = new HomePageEvents();
	LoginPageEvents loginPage= new LoginPageEvents();
		 
	@Test
  public void LoginTest() 
   
  {
	  
	homePage.HomePagelogin();
	
	loginPage.checkLoginButtonPresent();
	loginPage.Login();
	  
  
  }
}
