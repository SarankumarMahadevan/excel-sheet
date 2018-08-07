package com.cg;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainDemo {
	
	public static void main(String[] args) throws InterruptedException, IOException {
	WebDriver driver;
	System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");
	 driver = new ChromeDriver();
	driver.get("file:///D:/Users/sarmahad/Desktop/new%20%202.html");
	FileInputStream ExcelFile = new FileInputStream("D:\\selenium demos\\login.xls");
	Workbook srcBook = new HSSFWorkbook(ExcelFile);
	Sheet sourceSheet = srcBook.getSheetAt(0);
	int rowMaxRowNum = sourceSheet.getLastRowNum();
	for(int row = 0;row <= rowMaxRowNum;row++){
	Row sourceRow = sourceSheet.getRow(row);
	Cell fname = sourceRow.getCell(0);
	Cell lname = sourceRow.getCell(1);
	driver.findElement(By.id("fname")).sendKeys(fname.toString());
	Thread.sleep(1000);
	driver.findElement(By.id("lname")).sendKeys(lname.toString());
	Thread.sleep(1000);
	WebElement submitButton = driver.findElement(By.id("submit"));
	submitButton.click();
	srcBook.close();
}
}
}