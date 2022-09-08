package mavenProject;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadDataExcel {
	public static String [][] readData() throws IOException {
		// TODO Auto-generated method stub
		XSSFWorkbook book = new XSSFWorkbook("./Testdata/Salesforcetest.xlsx");
		XSSFSheet sheet = book.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();

		XSSFRow row = sheet.getRow(1);
		int lastCellNum = row.getLastCellNum();
		System.out.println(lastCellNum);
		XSSFCell cell = row.getCell(2);
		String cellValue = cell.getStringCellValue();
		System.out.println(cellValue);

		String[][] data = new String[rowCount][lastCellNum];

		for (int i = 1; i <= rowCount; i++) {
		    for (int j = 0; j < lastCellNum; j++) {
		        String input = sheet.getRow(i).getCell(j).getStringCellValue();
		        data[i-1][j]=input;   
		    }
		}
		book.close();
		return data;
		

}

}
