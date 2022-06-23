package com.POI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowHandle2 {
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
		
	}
}
