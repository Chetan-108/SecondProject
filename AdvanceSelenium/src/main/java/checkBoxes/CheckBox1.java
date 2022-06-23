package checkBoxes;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBox1 {
	static WebDriver driver;
	@BeforeMethod
	public void initialization() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to("http:demo.automationtesting.in/Register.html");	
		
	}
	
	@Test
	public void clickOnCheckBox1() throws Exception {
		List<WebElement> choice=driver.findElements(By.xpath("//input[@type='checkbox']"));
		ArrayList <String> check=new ArrayList<String>();
		check.add("Cricket");
		check.add("Hockey");
		selectHobbies(driver,choice,check);
		System.out.println(choice);
	}
	@Test
	public void clickOnCheckBox2() throws Exception {
		List<WebElement> choice=driver.findElements(By.xpath("//input[@type='checkbox']"));
		ArrayList <String> check=new ArrayList<String>();
		check.add("Cricket");
		check.add("Movies");
		selectHobbies(driver,choice,check);
		
	}
	
	public static void selectHobbies(WebDriver driver,List<WebElement>locators,ArrayList<String> check1) throws Exception  {

		for(String checked:check1) {
		for(WebElement locator:locators) {
			String text=locator.getAttribute("value");
			
				if(text.equals(checked)) {
					locator.click();
					break;				
			}
		}
	}
}
}
