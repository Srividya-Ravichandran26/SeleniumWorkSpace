package week5.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] excelRead(String fileName) throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook("./data/"+fileName+".xlsx");
		XSSFSheet ws = wb.getSheet("Sheet1");
		int rowCount = ws.getLastRowNum();
		short cellCount = ws.getRow(0).getLastCellNum();
		String[][] data = new String[rowCount][cellCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				String value = ws.getRow(i).getCell(j).getStringCellValue();
//				System.out.println(value);
				data[i-1][j] = value;
			}
		}
		wb.close();
		return data;
	}

}
