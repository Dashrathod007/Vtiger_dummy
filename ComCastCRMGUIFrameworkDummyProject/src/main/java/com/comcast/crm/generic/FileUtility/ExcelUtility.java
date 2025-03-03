package com.comcast.crm.generic.FileUtility;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class ExcelUtility
{
public String getDatafromExcel(String sheetName,int rowNum,int celNum) throws Exception
{
	FileInputStream fis=new FileInputStream("./testData/TestScript.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	  String data=wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
	  wb.close();
	return data;
	
}

public int getRowCount(String sheetName) throws Exception
{
	FileInputStream fis=new FileInputStream(FilePathConstant.ExcelFile);
	Workbook wb = WorkbookFactory.create(fis);
	int rowCount = wb.getSheet(sheetName).getLastRowNum();
	wb.close();
	return rowCount;
}
public void setDataIntoExcel(String sheetName,int rowNum,int celNum,String data ) throws Exception
{
	FileInputStream fis=new FileInputStream("./testData/TestScript.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	wb.getSheet(sheetName).getRow(rowNum).createCell(celNum);
	
	FileOutputStream fos= new FileOutputStream("./testData/TestScript.xlsx");
	wb.write(fos);
	wb.close();
}
}
