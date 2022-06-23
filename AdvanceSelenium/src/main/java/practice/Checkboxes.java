package practice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Checkboxes {

	static WebDriver driver;
	@BeforeMethod
	public void initialization() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to("https://itera-qa.azurewebsites.net/home/automation");	
		
	}
	
	@Test
	public void checkedLast2Days() throws Exception {
		List<WebElement> choice=driver.findElements(By.xpath("//input[@type='checkbox' and @class='form-check-input']"));
		selectLast2Days(driver,choice);
		System.out.println(choice);
	}
	@Test
	public void checkedFirst2Days() throws Exception {
		List<WebElement> choice=driver.findElements(By.xpath("//input[@type='checkbox' and @class='form-check-input']"));	
		selectFirst2Days(driver,choice);
		
	}
	
	public static void selectLast2Days(WebDriver driver,List<WebElement>locators) throws Exception  {

		int totalCheckboxes=locators.size();
		
		for(int i=totalCheckboxes-2;i<totalCheckboxes;i++) {
			locators.get(i).click();
			
		}
	}
	public static void selectFirst2Days(WebDriver driver,List<WebElement>locators) throws Exception  {

		int totalCheckboxes=locators.size();
		
		for(int i=0;i<totalCheckboxes-5;i++) {
			locators.get(i).click();
			
		}
	}
}

