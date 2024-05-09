package com.MavenProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAllData {
	private  static void readAllData() throws Throwable {
		File f=new File(".\\Excel\\pro.xlsx");//open the file by giving location
		
		FileInputStream fis=new FileInputStream(f);//we are Reading from file so fis from file 
		Workbook wb=new XSSFWorkbook(fis);
		Sheet sheetAt = wb.getSheetAt(0);//transferring the control from wb to sheet
		int numberOfRows = sheetAt.getPhysicalNumberOfRows();//getting no.of rows 
		
		for(int i=0;i<numberOfRows;i++)//for iterating row
		{
			Row row = sheetAt.getRow(i);
			int numberOfCells = row.getPhysicalNumberOfCells();//getting physical  no of cells
			
			//inner for loop
			for(int j=0;j<numberOfCells;j++)
			{
				Cell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				if(cellType.equals(cellType.STRING))//to check celltype is dtring or numeric
				{
					 String stringCellValue = cell.getStringCellValue();
					 System.out.println(stringCellValue);
				}
				else if(cellType.equals(cellType.NUMERIC))
				{
					double numericCellValue = cell.getNumericCellValue();
					int data=(int)numericCellValue;//narrowing
					System.out.println(data);
				}
			}
		}
		wb.close();
		
			}
	public static void main(String[] args) throws Throwable {
		readAllData();
		
	}

}
