package dropdown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BootstrapDropdown {
	WebDriver driver;
	@BeforeMethod
	public void initialization() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to("https://www.w3schools.com/bootstrap/bootstrap_dropdowns.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
	}	
	@Test
	public void selectExamples1() throws Exception {
        driver.findElement(By.xpath("//button[@id='menu1']")).click();
        List<WebElement>examples=driver.findElements(By.xpath("//ul[@aria-labelledby='menu1']//a[@role='menuitem']"));
        bootStrap(examples,"JavaScript"); 
       
        System.out.println("No of options: "+examples.size());

	}
	@Test
	public void selectExamples2() throws Exception {
		driver.findElement(By.xpath("//button[@id='menu1']")).click();
		 List<WebElement>examples=driver.findElements(By.xpath("//ul[@aria-labelledby='menu1']//a[@role='menuitem']"));
	        bootStrap(examples,"CSS");
	        System.out.println("No of options: "+examples.size());
	}
	public static void bootStrap(List<WebElement> options,String value) throws Exception {
		for (WebElement option : options) {
			if(option.getText().equals(value)) {
			System.out.println(option.getText());
			option.click();
			Thread.sleep(5000);
			break;
			}
		}
	}
}
