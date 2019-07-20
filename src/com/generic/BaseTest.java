package com.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseTest implements IAutoConstant {
	public WebDriver driver;
	static{
		//System.setProperty(CHROME_KEY,CHROME_VALUE);
	}
	
	@BeforeMethod
	public void openApp() {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		driver.get(APP_URL);
		
	}
	@AfterMethod
	public void closeApp(ITestResult iTestResult) {
		int status = iTestResult.getStatus();
		String name = iTestResult.getName();
		if(status==1)
		{
			Reporter.log("Test"+name+"is pass",true);
		}
		else {
			Reporter.log("Test"+name+"is FAIL/SKIP",true);
			AutoLib.getPhoto(driver, IMG_PATH+name+".png");
		}
		//driver.close();
		
	}
}
