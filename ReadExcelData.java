package week6.day3;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcelData {
	
	public static String[][] readExcel(String fileName) throws IOException {
		XSSFWorkbook book = new XSSFWorkbook("./testdata/"+fileName+".xlsx");
		XSSFSheet sheet = book.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		XSSFRow row = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		String[][] array = new String[rowCount][colCount];
		DataFormatter formatter = new DataFormatter();
		for(int i=1; i<=rowCount; i++) {
			XSSFRow eachRow = sheet.getRow(i);
			for(int j=0; j<colCount; j++) {
				XSSFCell eachCell = eachRow.getCell(j);
				//String data = eachCell.toString();
				String data = formatter.formatCellValue(eachCell);
				array[i-1][j] = data;
			}
		}
		return array;
	}

}
