package pageEvents;

import pageObjects.HomePageElements;
import utils.FetchElement;

public class HomePageEvents {

	
	//call the fetchelement call
		//the actual action performed on the web element is written here
		FetchElement ele= new FetchElement();
		
		public void HomePagelogin()
		{
			
			
			ele.getWebElement("XPATH", HomePageElements.loginButton).click();
			
			
		}
}
