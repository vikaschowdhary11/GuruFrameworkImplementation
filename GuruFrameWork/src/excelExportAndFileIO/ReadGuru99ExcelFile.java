package excelExportAndFileIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadGuru99ExcelFile {
	
	public Sheet readExcel(String filePath,String fileName,String sheetName) throws IOException {
		File file=new File(filePath+"\\"+fileName);
		FileInputStream inputSteam=new FileInputStream(file);
		
		Workbook guru99Workbook=null;
		
		String fileExtensionName=fileName.substring(fileName.indexOf("."));
		
		if(fileExtensionName.equalsIgnoreCase(".xlsx")) {
			guru99Workbook=new XSSFWorkbook(inputSteam);
		}else if(fileExtensionName.equals(".xls")) {
			guru99Workbook=new HSSFWorkbook(inputSteam);
		}
		
		Sheet guruSheet=guru99Workbook.getSheetAt(0);
		
		return guruSheet;
		
	}

}
