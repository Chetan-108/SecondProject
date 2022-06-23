package com.POI;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WriteExcel1 {
	WebDriver driver;
	DataFormatter df=new DataFormatter();
	int count=1;
	Sheet sh=null;
	Row r=null;
	Cell c=null;
	public String getCellData(String filePath,String sheetName,int row,int col) throws Exception {
		DataFormatter df=new DataFormatter();
		FileInputStream fis=new FileInputStream(filePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		return df.formatCellValue(sh.getRow(row).getCell(col));
	}
	public void writeData(String filePath,String sheetName,int row,int col,String data) throws Exception {
		FileInputStream fis=new FileInputStream(filePath);
		Workbook wb=WorkbookFactory.create(fis);
		if(wb.getSheet(sheetName)==null)
			sh=wb.createSheet(sheetName);
		else
			sh=wb.getSheet(sheetName);
		if(sh.getRow(row)==null)
			r=sh.createRow(row);
		else
			r=sh.getRow(row);
		if(r.getCell(col)==null)
			c=r.createCell(col);
		else
			c=r.getCell(col);
		c.setCellValue(data);
		FileOutputStream fos=new FileOutputStream(filePath);
		wb.write(fos);
		wb.close();
		fos.close();
	}
	@Test
	public void Login() throws Exception {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///E:/old%20backup/Downloads/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		driver.manage().window().maximize();
		while(count<4) {
			String email=getCellData("TestData.xlsx", "Login", count, 0);
			String password=getCellData("TestData.xlsx", "Login", count, 1);
			driver.findElement(By.id("email")).sendKeys(email);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.xpath("//button")).click();
			if(driver.getTitle().equals("JavaByKiran | Dashboard")) {
				writeData("TestData.xlsx", "Login", count, 2,"PASS");
				driver.findElement(By.linkText("LOGOUT")).click();
			}
			else {
				writeData("TestData.xlsx", "Login", count, 2,"FAIL");
				driver.navigate().refresh();
			}
			count++;
		}
	}
}
