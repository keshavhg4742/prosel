package com.script;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class CommonLogin {
	WebDriver driver=null;
	
	@Test()
	@Severity(SeverityLevel.NORMAL)
	@Description("Login test case")
	@Parameters({"browser","url","username","password"})
	public void loginTest(String browser,String url,String username,String password) {
		
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.chrome.driver", "./drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("pwd")).sendKeys(password);
		driver.findElement(By.id("loginButton")).click();
		driver.findElement(By.linkText("Logout")).click();
	}
	
	/*@Test(priority=2)
	public void logout()
	{
		
			driver.findElement(By.linkText("Logout")).click();
		
	}*/


}
