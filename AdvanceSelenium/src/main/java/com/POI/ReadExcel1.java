package com.POI;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ReadExcel1 {

	WebDriver driver;
    DataFormatter df=new DataFormatter();//to convert any cell into string format
	int count=1;
	public String getCellData(String filePath,String sheetName,int count,int col) throws Exception {
		
		FileInputStream fis=new FileInputStream(filePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		return df.formatCellValue(sh.getRow(count).getCell(col));//to convert any cell into string format
	}
	@Test
	public void registerUser1() throws Exception {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///E:/old%20backup/Downloads/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		
		driver.findElement(By.xpath("//*[contains(@href,'pages/examples/register.html')]")).click();
		while(count<6) {
		String name=getCellData("TestData.xlsx", "RegisterUser1", count, 0);
		String mobile=getCellData("TestData.xlsx", "RegisterUser1", count, 1);
		String email=getCellData("TestData.xlsx", "RegisterUser1", count, 2);
		String pass=getCellData("TestData.xlsx", "RegisterUser1",count, 3);
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("mobile")).sendKeys(mobile);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.xpath("//*[contains(@class,'btn btn-primary btn-block btn-flat')]")).click();
		driver.switchTo().alert().accept();
		driver.navigate().refresh();
		count++;
		}
	}
	
//	public void readEx() throws Exception {
//
//	FileInputStream fis=new FileInputStream("TestData.xlsx");
//	Workbook wb=WorkbookFactory.create(fis);
//	Sheet sh=wb.getSheet("RegisterUser1");
//	int rows=sh.getLastRowNum();
//	for (int i = 0; i <=rows; i++) {
//		int cols=sh.getRow(i).getLastCellNum();
//		for (int j = 0; j <=cols; j++) {
//			Cell c=sh.getRow(i).getCell(j);
//			System.out.print(df.formatCellValue(c)+"  ");//to convert any cell into string format
//		}
//		System.out.println();
//	}
//	}
}


