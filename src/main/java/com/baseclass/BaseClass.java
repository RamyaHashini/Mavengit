package com.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;//null
	public static String value;//null
//1	
	public static WebDriver browserLaunch(String type)//for browser
	{
		if(type.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(type.equalsIgnoreCase("firefox"))
		{
			
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
         driver.manage().window().maximize();
         return driver;
	}
	
	//2
	public static WebDriver getUrl(String url)
	{
		driver.get(url);
		return driver;
	}
	
	//3
		public static void clickOnElement(WebElement element)//click method
	{
		
		element.click();
	}
		
	//4
	public static void inputValueElement(WebElement element,String value) 
	{
		element.sendKeys(value);

	}
	
	//5
	public static WebDriver close() {
		driver.close();
		return driver;
	}
	
	//6
	public static WebDriver quit()
	{
		driver.quit();
		return driver;
	}
	
	
//7
	public static void dropdown(WebElement element,String type,String value) {
		Select s=new Select(element);
		if(type.equalsIgnoreCase("value"))
		{
			s.selectByValue(value);
			}
	
		else if(type.equalsIgnoreCase("index"))
		{
			int data = Integer.parseInt(value);
			s.selectByIndex(data);
		}
		else if(type.equalsIgnoreCase("text"))
		{
			s.selectByVisibleText(value);
		}
}
	
	//DataDriven
	public static String readData(String path,int sheetIndex,int rowIndex,int cellIndex ) throws IOException {
		File f=new File(path);
		FileInputStream fis=new FileInputStream(f);
		Workbook wb=new XSSFWorkbook(fis);
		Sheet sheetAt = wb.getSheetAt(sheetIndex);
		Row row = sheetAt.getRow(rowIndex);
		Cell cell = row.getCell(cellIndex);
		CellType cellType = cell.getCellType();
		if(cellType.equals(CellType.STRING))
		{
			value = cell.getStringCellValue();//value is in String
		}
		else if (cellType.equals(CellType.NUMERIC)) {
			double numericCellValue = cell.getNumericCellValue();
			int data= (int) numericCellValue;//value is in int ,to change int to string v having method i.e in below
			value=String.valueOf(data);
		}
		wb.close();
		return value;

	}
	
//8
	public static WebDriver accept() {
		driver.switchTo().alert().accept();
		return driver;
	}
	
//9
	public static WebDriver dismiss() {
		driver.switchTo().alert().dismiss();
		return driver;
	}
	
//10
	public static WebDriver getText() {
		driver.switchTo().alert().getText();
		return driver;
	}
	
		
////11
		public static void screenshot(String filepath) throws IOException
		{
			TakesScreenshot t=(TakesScreenshot) driver;
			File src=t.getScreenshotAs(OutputType.FILE);
			File des = new File(filepath);
			FileUtils.copyFile(src, des);
		}
		
//12
		
		public static WebDriver gettTitle() {
			driver.getTitle();
			return driver;
		}
		
//13
		public static  void gettText(WebElement element) {
			element.getText();
			}
		
//14
		public static  WebDriver gettcurrenturl() {
			driver.getCurrentUrl();
			return driver;
			}
		
//15
		public static void gettAttribute(WebElement element,String value) {
			element.getAttribute(value);
			}
		
//16
		public static void isEnabledd(WebElement element) {
			element.isEnabled();
		}
	
//17
		public static void isdisplayedd(WebElement element) {
			element.isDisplayed();
		}
		
//18
		public static void isSelectedd(WebElement element) {
			element.isSelected();
		}
		
//19
		public static WebDriver windowHandlee() {
			driver.getWindowHandle();
			return driver;			

		}
//20
		public static WebDriver windowHandless() {
			driver.getWindowHandles();
			return driver;			
		}
		
//21
		public static void Actionss(WebElement element,String type,WebElement target) {
			
				Actions a=new Actions(driver);
				if(type.equalsIgnoreCase("moveToelement"))
				{
					a.moveToElement(element).perform();
					}
			
				else if(type.equalsIgnoreCase("doubleclick"))
				{
					a.doubleClick(element).perform();
				}
				else if(type.equalsIgnoreCase("contextclick"))
				{
					a.contextClick(element).perform();
				}
				else if(type.equalsIgnoreCase("draganddrop"))
				{
					a.dragAndDrop(element, target).perform();
		}

		}
	//22 scroll
		public static void scroll(String type) {
			JavascriptExecutor j=(JavascriptExecutor) driver;//downcasting 
			if(type.equalsIgnoreCase("bottom"))
			{
			j.executeScript("window.scrollBy(0,document.body.scrollHeight)");//scroll to the end of the page
			}
			else if(type.equalsIgnoreCase("top"))
			{
			j.executeScript("window.scrollTo(0,0)");//scroll to the top of the webpage
			}
		}
	
	//23,24,25,26 Navigate to back,forward,refresh
				public static  WebDriver navigate(String type,String value) {
					if(type.equalsIgnoreCase("to"))
					{
						driver.navigate().to(value);
					}
					else if(type.equalsIgnoreCase("back"))
					{
						driver.navigate().back();
					}
					else if(type.equalsIgnoreCase("forward"))
					{
						driver.navigate().back();
					}
					else if(type.equalsIgnoreCase("refresh"))
					{
						driver.navigate().back();
					}
					return driver;

				}
				
	//27.Excel ReadAllData
				public  static String excelreadAllData(String path,int sheetin) throws Throwable {
					File f=new File(path);//open the file by giving location
					
					FileInputStream fis=new FileInputStream(f);//we are Reading from file so fis from file 
					Workbook wb=new XSSFWorkbook(fis);
					Sheet sheetAt = wb.getSheetAt(sheetin);//transferring the control from wb to sheet
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
					return value;
					
						}
				
		//28.Frames
				public static void frames(String frame1,int frameint,WebElement element) {
					
					if(frame1.equalsIgnoreCase("frame1")) {
						driver.switchTo().frame(element);
					}
					else if(frame1.equalsIgnoreCase("frame1"))
					{
						driver.switchTo().frame(frameint);
					}
					else if(frame1.equalsIgnoreCase("parentframe"))
					{
						driver.switchTo().parentFrame();
					}
					else if(frame1.equalsIgnoreCase("default"))
					{
						driver.switchTo().defaultContent();
					}
				}
		
		//29.wait
				public static void waitForPageLoad(WebDriver driver)
				{
					driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				}
		//30.getoptions
				public static void getaloptions(WebElement element)
				{
				Select s=new Select(element);
				s.getOptions();
				}
				
				
		//31.get1st selected option
				public static void get1stSelecteedopt(WebElement element)
				{
				Select s=new Select(element);
				s.getFirstSelectedOption();
				}
				
		//32.is multiple
				public static void isMultiple(WebElement element)
				{
				Select s=new Select(element);
				s.isMultiple();
				}
				
			//33.radiobutton
		
				public static void Radiobutn(WebElement element)
				{
					
					element.click();
				}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	
}
