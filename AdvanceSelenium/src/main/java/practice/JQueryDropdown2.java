package practice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JQueryDropdown2 {
	static WebDriver driver;
	@BeforeMethod
	public void initialization() throws Exception {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to("http:demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();		
		Thread.sleep(5000);
	
	}
	@AfterMethod
	public void close() {
		driver.close();
	}
	@Test
	public void clickOnSkill1() throws Exception {
	driver.findElement(By.id("msdd")).click();
	List<WebElement> allOptions=driver.findElements(By.xpath("//li/a[@class='ui-corner-all']"));
	ArrayList <String> check=new ArrayList<String>();
	check.add("English");
	check.add("Hindi");
	selectSkills(allOptions,check);
	}
	@Test
	public void clickOnSkill2() throws Exception {

		driver.findElement(By.id("msdd")).click();
		List<WebElement> allOptions=driver.findElements(By.xpath("//li/a[@class='ui-corner-all']"));
		ArrayList <String> check=new ArrayList<String>();
		check.add("French");
		check.add("Greek");
		selectSkills(allOptions,check);

	}

	public static void selectSkills(List<WebElement> options,ArrayList<String> values) throws Exception  {
	WebDriverWait wait=new WebDriverWait(driver,30);
		for(String value:values) {
		for(WebElement option:options) {
           wait.until(ExpectedConditions.elementToBeClickable(option));
			if(	option.getText().equals(value)) {				
				System.out.println("Selected option: "+option.getText());
				option.click();						
				Thread.sleep(5000);
				break;				
			}
		}
	}
	}
}
