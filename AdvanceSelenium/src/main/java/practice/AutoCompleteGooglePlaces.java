package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutoCompleteGooglePlaces {
	WebDriver driver;
	@BeforeMethod
	public void initialization() throws Exception {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to("https://www.twoplugs.com/");
		driver.manage().window().maximize();

	}	
	@AfterMethod
	public void close() {
		driver.close();
	}

	@Test
	public void selectOption() throws Exception {
		driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
		WebElement searchbox=driver.findElement(By.xpath("//input[@placeholder='Toronto,ON,Canada']"));
		checkAutoSuggestion(driver,searchbox,"delhi","Delhi Airport Parking Lot, New Delhi, Delhi");
	}

	public static void checkAutoSuggestion(WebDriver driver,WebElement option,String value1,String value2) throws Exception {

		option.clear();
		option.sendKeys(value1);
		String text=null;
		do {
			option.sendKeys(Keys.ARROW_DOWN);
			text=option.getAttribute("value");
			
			if(text.equals(value2)){
				option.sendKeys(Keys.ENTER);
				break;
			}
			Thread.sleep(3000);
		}while(!text.isEmpty());

	}	
}
