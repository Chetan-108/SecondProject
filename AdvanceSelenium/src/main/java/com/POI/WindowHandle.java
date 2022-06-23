package com.POI;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowHandle {

	static WebDriver driver;
	public static void login() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///C:/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
	}
	
	@Test
	public void test01() {
		login();
		WebElement text=driver.findElement(By.xpath("//*[@class='active']"));
		System.out.println(text.getCssValue("font-size"));
//		List <WebElement> links=driver.findElements(By.partialLinkText("More info"));
//		String mainWin=driver.getWindowHandle();//1 window
//		//window is uniquely identify by unique id,that id is given by getWindowHandle()
//		for (WebElement link : links) {
//			link.click();
//		}
//		//There are 5 windows in the browser
//		Set<String> allWin=driver.getWindowHandles();//5 values
//		for (String win : allWin) {
//			System.out.println("id of a window is: "+win);
//			if(!win.equals(mainWin)) {
//				driver.switchTo().window(win);
//				System.out.println(driver.getCurrentUrl());
//				System.out.println(driver.getTitle());
//				driver.close();
//			}
//			else {
//				System.out.println("User is already on parent window");
//			}
//		}
	}
}
