package com.MavenProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {
	
	private static void readdata() throws Throwable {
		File f=new File(".\\Excel\\pro.xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		
		Sheet sheetAt = wb.getSheetAt(0);
		
		Row row = sheetAt.getRow(2);
		
		Cell cell = row.getCell(1);
		
		CellType cellType = cell.getCellType();
		if(cellType.equals(CellType.STRING)) 
		{
			
			String stringCellValue = cell.getStringCellValue();
			System.out.println(stringCellValue);
			
		}
		else if(cellType.equals(cellType.NUMERIC))
		{
			double numericCellValue = cell.getNumericCellValue();
			int data=(int)numericCellValue;
			System.out.println(data);
		}
		wb.close();
		
		
	}
	
	public static void main(String[] args) throws Throwable {
		readdata();
		
		
		
	}
}
