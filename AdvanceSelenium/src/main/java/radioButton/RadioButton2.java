package radioButton;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButton2 {
	WebDriver driver;
	@BeforeMethod
	public void initialization() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to("http://demo.automationtesting.in/Register.html");	
		
	}
	
	@Test
	public void clickOnRadio1() throws Exception {
		List<WebElement> locators=driver.findElements(By.xpath("//input[@type='radio']"));
		selectGender(driver,locators,"Male");
	}
	@Test
	public void clickOnRadio2() throws Exception {
		List<WebElement> locators=driver.findElements(By.xpath("//input[@type='radio']"));
		selectGender(driver,locators,"Male");
	}
	
	public static void selectGender(WebDriver driver,List<WebElement>locators,String value) throws Exception  {

		for(WebElement locator:locators) {
			String text=locator.getAttribute("value");
			
				if(text.equals(value)) {
					locator.click();
					System.out.println(locator.getText());
					break;				
			}
		}
}
}
