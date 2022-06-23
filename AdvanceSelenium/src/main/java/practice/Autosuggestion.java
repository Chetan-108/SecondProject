package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Autosuggestion {
	WebDriver driver;
	@BeforeMethod
	public void initialization() throws Exception {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to("https://www.google.com/");
		driver.manage().window().maximize();
		
	}	
	@AfterMethod
	public void close() {
		driver.close();
	}
	
	@Test
	public void selectFromAutoSuggestion() throws Exception {
		driver.findElement(By.name("q")).sendKeys("Automation testing");
		Thread.sleep(3000);
		List<WebElement> allOptions=driver.findElements(By.xpath("//li[@class='sbct']//div[@class='wM6W7d']"));
		checkAutoSuggestion(driver,allOptions,"tutorial");
	}

	public static void checkAutoSuggestion(WebDriver driver,List<WebElement> options,String value) throws Exception {
	
		System.out.println("Size of Auto suggestions: "+options.size());
		for (WebElement option : options) {
			if(option.getText().contains(value)) {
				System.out.println(option.getText());
				option.click();
				break;
			}
		}
	}
}
