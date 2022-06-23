package dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandleDropdown {

	static WebDriver driver;
	@BeforeMethod
	public void initialization() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to("http:demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
	}	
	@Test
	public void clickOnSkill1() throws Exception {
	
		WebElement skills=driver.findElement(By.id("Skills"));
		selectSkills(skills,"Java");
	}
	@Test
	public void clickOnSkill2() throws Exception {

		WebElement skills=driver.findElement(By.id("Skills"));
		selectSkills(skills,"MySQL");

	}

	public static void selectSkills(WebElement skill,String value) throws Exception  {
		Select drp=new Select(skill);
		List<WebElement> allOptions=drp.getOptions();
		for(WebElement option:allOptions) {

			if(	option.getText().equals(value)) {
				option.click();
				System.out.println("Selected Skill: "+option.getText());
				break;				
			}
		}
	}
}