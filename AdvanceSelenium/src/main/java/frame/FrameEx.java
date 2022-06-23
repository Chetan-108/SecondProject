package frame;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FrameEx {

	WebDriver driver;
	@Test
	public void test01() throws Exception {
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.findElement(By.id("i-icon-profile")).click();
		driver.findElement(By.id("signInLink")).click();
		WebElement frame=driver.findElement(By.xpath("//iframe[@class='modalIframe']"));
		Thread.sleep(3000);
		String main=driver.getWindowHandle();
		driver.switchTo().frame(frame);
		//driver.findElement(By.id("mobileNoInp")).sendKeys("1234567891");
		driver.findElement(By.id("newFbId")).click();

		
		Set<String> allwins=driver.getWindowHandles();
	
	
		for(String win:allwins) {
			if(!win.equals(main)) {
				driver.switchTo().window(win);
				System.out.println(driver.getCurrentUrl());
				//driver.close();
			}
		
		}
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("chetan@gmail.com");
	}
	
}
