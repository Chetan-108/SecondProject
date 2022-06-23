package com.POI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class WriteExcel {
	 Sheet sh=null;
	 Row r=null;
	 Cell c=null;	
	@Test
	public void writeExcel() throws Exception {		
		FileInputStream fis=new FileInputStream("TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		if(wb.getSheet("User")==null)
			sh=wb.createSheet("User");
		else
			sh=wb.getSheet("User");		
		if(sh.getRow(5)==null)
			r=sh.createRow(5);
		else
			r=sh.getRow(5);		
		if(r.getCell(3)==null)
			c=r.createCell(3);
		else
			c=r.getCell(3);		
		c.setCellValue("JAVABYKIRAN");		
		FileOutputStream fos=new FileOutputStream("TestData.xlsx");
		wb.write(fos);
		wb.close();
		fos.close();
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
}
