package com.POI;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WindowHandle1 {


	static WebDriver driver=null;
	public void launch() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Windows.html");
		
//		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
//		driver.findElement(By.id("password")).sendKeys("123456");
//		driver.findElement(By.xpath("//button")).click();
	}
	public static void scrollForElement(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",element);
	}
	@Test
	public void test01() throws Exception {
		launch();
		scrollForElement(driver.findElement(By.xpath("//a[@href='http://www.selenium.dev']//child::button")));	
		(driver.findElement(By.xpath("//a[@href='http://www.selenium.dev']//child::button"))).click();

		String parentWindow=driver.getWindowHandle();
		Thread.sleep(10000);
		Set<String> allWin=driver.getWindowHandles();//1 window
		//window is uniquely identify by unique id,that id is given by getWindowHandle()
		switchToWindow(parentWindow,allWin,"Selenium");
	}
		public void switchToWindow(String parentWindow,Set<String> allWin,String title) {
		for (String window : allWin) {
			if(!window.equals(parentWindow)) {
			driver.switchTo().window(window);
			if(driver.getTitle().equalsIgnoreCase(title)) {
			System.out.println(driver.getCurrentUrl());
			System.out.println(driver.getTitle());
			driver.close();
			}
			}
		}
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	}
}
