package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckDropdownSorted {

	WebDriver driver;
	@BeforeMethod
	public void initialization() throws Exception {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to("http:demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		
	}	
	@AfterMethod
	public void close() {
		driver.close();
	}
	@Test
	public void clickOnSkill1() throws Exception {
		WebElement skills=driver.findElement(By.id("Skills"));
		ArrayList<String> originalList=new ArrayList();
		ArrayList<String> tempList=new ArrayList();
		selectSkills(skills,originalList,tempList);

	}
	@Test
	public void clickOnSkill2() throws Exception {
		WebElement skills=driver.findElement(By.id("Skills"));
		ArrayList<String> originalList=new ArrayList();
		ArrayList<String> tempList=new ArrayList();
		selectSkills(skills,originalList,tempList);
	}
	public static void selectSkills(WebElement element,ArrayList<String> originalList,ArrayList<String> tempList) throws Exception  {
		Select drp=new Select(element);
		List<WebElement> allOptions=drp.getOptions();
		
		for(WebElement option:allOptions) {
			originalList.add(option.getText());
			tempList.add(option.getText());
		}
		System.out.println("Original List: "+originalList);
		System.out.println("Temporary List: "+tempList);
		Collections.sort(tempList);
		System.out.println("tempList after sorting: "+tempList);
			if(	originalList.equals(tempList)) {
			
				System.out.println("Dropdown sorted");				
			}
			else {
				System.out.println("Dropdown not sorted");	
		}
	}
}
