package com.generic;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class XL {
	static Workbook workbook;
	
	public static int getRowCount(String path,String sheet)
	{
		
		int rc=-1;
		try {
			 workbook=WorkbookFactory.create(new FileInputStream(path));
			rc=workbook.getSheet(sheet).getLastRowNum();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rc;
	}

	public static String getData(String path,String sheet,int r,int c)
	{
		String v="";
		
		try {
			 workbook=WorkbookFactory.create(new FileInputStream(path));
			   v= workbook.getSheet(sheet).getRow(r).getCell(c).toString();
			
			 } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return v;
	}
	public static String getCel(String path,String sheet,int r,int c) {
		Integer d=0;
		
		try {
			 workbook=WorkbookFactory.create(new FileInputStream(path));
			 d = (int)workbook.getSheet(sheet).getRow(r).getCell(c).getNumericCellValue();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d.toString();
		// TODO Auto-generated method stub

	}
}
