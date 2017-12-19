package dataProvider;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelDataProvider
{
	XSSFWorkbook wb;
	public ExcelDataProvider()
	{
		File src = new File("./AppliactionTestData/Appdata.xlsx");
	try {
		FileInputStream fis= new FileInputStream(src);
		 wb= new XSSFWorkbook(fis);
		
	} catch (Exception e)
	{
		System.out.println("this is file error for filrinput/output"+e.getMessage());
	}
	
}
	public String getData(int sheetIndex,int row,int column)
	{
		  String data= wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
		 // System.out.println(data);

		  return data;
	}
	public String getData(String sheetname,int row,int column)
	{
		  String data= wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
		//  System.out.println(data);
		  return data;
	}

}