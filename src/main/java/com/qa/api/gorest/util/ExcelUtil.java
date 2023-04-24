package com.qa.api.gorest.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public static Workbook book ;
	public static Sheet sheet;
	
	public static String TEST_DATA_SHEET_PATH= "C:\\Users\\Ajith Kumar\\eclipse-workspace\\Rest_Assured_FrameWork"
					+ "\\src\\main\\java\\com\\qa\\api\\gorest\\testdata\\GoRestTestData.xlsx";
	
	
		public static Object [][] getTestData(String sheetName) {
			
			try {
				FileInputStream ip = new FileInputStream(TEST_DATA_SHEET_PATH);
			book =	WorkbookFactory.create(ip);
			sheet =book.getSheet(sheetName);
			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (InvalidFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()]	;
			
			for(int i=0;i<sheet.getLastRowNum();i++) {
				for(int k=0; k<sheet.getRow(0).getLastCellNum();k++) {
					data[i][k] = sheet.getRow(i+1).getCell(k).toString();
					 
				}
			}
			
			return data;
			
		}
	
}
