package com.MavenProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Writedata {
	
	private static void Writedata()  throws IOException {
	File f=new File("C:\\Users\\Hashinipranav\\Desktop\\pro.xlsx");
	FileInputStream fis=new FileInputStream(f);//we are Reading from file so fis from file 
	Workbook wb=new XSSFWorkbook(fis);
	wb.createSheet("Data").createRow(0).createCell(0).setCellValue("Employee_id");
	wb.getSheet("Data").getRow(0).createCell(1).setCellValue("EmployeeName");
	wb.getSheet("Data").createRow(1).createCell(0).setCellValue("123");
	
	wb.getSheet("Data").getRow(1).createCell(1).setCellValue("JAMES");
	FileOutputStream fos=new FileOutputStream(f);
	wb.write(fos);
	System.exit(0);//After this statement ,none lines will be executed.
	System.out.println("Write sucessfully");
	wb.close();
}
 public static void main(String[] args) throws IOException {
	 Writedata();
}

	
}
 

