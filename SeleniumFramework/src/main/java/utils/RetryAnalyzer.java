package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	
	// This class with be executed when the test failed due to flakky test results 
	int count=0;
	int retryCount=1;
	
	
	public boolean retry(ITestResult result) {
		
	while (count<retryCount ) {
		
		count++;
		return true;
		
	}	
		
		
		return false;
	}

}
