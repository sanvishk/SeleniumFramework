package base;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Constant;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;



public class BaseTest {

	public static WebDriver driver;
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest logger;



	//This is executed only once
	@BeforeTest
	public void beforeTestMethod()
	{
		// here we are including the report
		sparkReporter = new  ExtentSparkReporter(System.getProperty("user.dir") + File.separator+"reports"+File.separator+"selframeworkExtentReport.html");
		extent= new ExtentReports();
		extent.attachReporter(sparkReporter);
		sparkReporter.config().setTheme(Theme.DARK);
		extent.setSystemInfo("HostName", "RHEL8");
		extent.setSystemInfo("Username", "root");
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Automation Test Results herewith");
	}


	// This is executed for each test case or every time for a new @Test, but before the test case

	@BeforeMethod
	@Parameters("browser")
	public void beforeMethod_Method(String browser, Method testMethod)
	{
		logger = extent.createTest(testMethod.getName());
		setupDriver(browser);
		driver.manage().window().maximize();
		driver.get(Constant.url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		

	}


	//This is executed for each test case or every time for a new @Test, but after the test case
	@AfterMethod()
	public void afterMethod_Method(ITestResult result)

	{
		// in this method the report will be captured
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));

		}
		else if (result.getStatus()==ITestResult.SKIP)

		{
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " -Test Case Skipped", ExtentColor.ORANGE));

		}
		else if (result.getStatus()==ITestResult.SUCCESS) 
		{

			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " -Test Case Passed", ExtentColor.GREEN));

		}
		driver.quit();



	}
	//This is executed only once
	@AfterTest()
	public void afterTestMethod()
	{
		extent.flush();

	}

	public void setupDriver(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("safari")) 
		{
			WebDriverManager.safaridriver().setup();
			driver= new SafariDriver();
		}

	}

}
