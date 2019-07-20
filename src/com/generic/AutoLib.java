package com.generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AutoLib {
	public static void getPhoto(WebDriver driver,String path) {
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File dest=new File(path);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
