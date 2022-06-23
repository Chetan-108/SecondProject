package practice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class JQueryDropdown {

	static WebDriver driver=null;
	public void launch() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		
	}
	
	@Test
	public void clickOnCountry1() throws Exception {
		launch();
		driver.findElement(By.id("justAnInputBox")).click();;
		List<WebElement> allOptions=driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));	
		ArrayList <String> check=new ArrayList<String>();
		check.add("choice 2 1");
		check.add("choice 6 1");
		selectChoice(driver,allOptions,check);
	}

	@Test
	public void clickOnCountry2() throws Exception {
		launch();
		driver.findElement(By.id("justAnInputBox")).click();
		List<WebElement> allOptions=driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
		ArrayList <String> check=new ArrayList<String>();
		check.add("choice 6 2 2");
		check.add("choice 7");
		selectChoice(driver,allOptions,check);

	}

	public static void selectChoice(WebDriver driver,List<WebElement>locators,ArrayList<String> check1) throws Exception  {

		for(String checked:check1) {
		for(WebElement locator:locators) {
			String text=locator.getText();
			
				if(text.equals(checked)) {
					locator.click();
					break;				
			}
		}
	}
}
}
