package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseTest;

public class FetchElement {

	public WebElement getWebElement(String ElementIdentifierType, String ElementValue)
	{
		switch (ElementIdentifierType) {
		case "XPATH":
			return BaseTest.driver.findElement(By.xpath(ElementValue));

		case "ID":
			return BaseTest.driver.findElement(By.id(ElementValue));

		case "CSS":
			return BaseTest.driver.findElement(By.cssSelector(ElementValue));
			
		case "NAME":
			return BaseTest.driver.findElement(By.name(ElementValue));

			default:
			return null;
		}
		
	}

	public List<WebElement> getWebElements(String ElementIdentifierType, String ElementValue)
	{
		switch (ElementIdentifierType) {
		case "XPATH":
			return BaseTest.driver.findElements(By.xpath(ElementValue));

		case "ID":
			return BaseTest.driver.findElements(By.id(ElementValue));

		case "CSS":
			return BaseTest.driver.findElements(By.cssSelector(ElementValue));
			
		case "NAME":
			return BaseTest.driver.findElements(By.name(ElementValue));

			default:
			return null;
		}
		
	}
	
	
}
