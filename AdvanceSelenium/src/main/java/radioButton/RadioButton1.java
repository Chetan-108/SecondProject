package radioButton;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class RadioButton1 {

	static WebDriver driver;
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to("http:demo.automationtesting.in/Register.html");	
	
		selectGender(driver,"Male");
		selectGender(driver,"FeMale");
		selectGender(driver,"FeMale");
		selectGender(driver,"Male");
	}
	
	public static void selectGender(WebDriver driver,String value) throws Exception  {
		List<WebElement> choice=driver.findElements(By.xpath("//div[@class='col-md-4 col-xs-4 col-sm-4']/label[contains(@class,'')]"));
			for(WebElement locator:choice) {
				String text=locator.getText();
				
					if(text.equals(value)) {
						locator.click();
						System.out.println(locator.getText());
						break;				
				}
			}
	}

}
