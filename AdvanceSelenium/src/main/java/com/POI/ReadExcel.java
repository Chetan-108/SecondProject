package com.POI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ReadExcel {

	WebDriver driver;
	DataFormatter df=new DataFormatter();//to convert any cell into string format
	public static String getCellData(String filePath,String sheetName,int row,int col) throws Exception {
		DataFormatter df=new DataFormatter();
		FileInputStream fis=new FileInputStream(filePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		return df.formatCellValue(sh.getRow(row).getCell(col));
	}
	@Test
	public void loginTest() throws Exception {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///E:/old%20backup/Downloads/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		String uname=getCellData("TestData.xlsx", "Login", 1, 0);
		String pass=getCellData("TestData.xlsx", "Login", 1, 1);
		driver.findElement(By.id("email")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.xpath("//button")).click();
	}
	
//	public void readEx() throws Exception {
//
//	FileInputStream fis=new FileInputStream("TestData.xlsx");
//	Workbook wb=WorkbookFactory.create(fis);
//	Sheet sh=wb.getSheet("Login");
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
