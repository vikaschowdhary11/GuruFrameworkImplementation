package testCases;

import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import excelExportAndFileIO.ReadGuru99ExcelFile;
import operation.ReadObject;
import operation.UIOperation;

public class ExecuteTest {
	
	@Test
	public void testLogin() throws Exception{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Vikas\\Documents\\Software\\Selenium\\geckodriver-v0.19.0-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		
		ReadGuru99ExcelFile file=new ReadGuru99ExcelFile();
		ReadObject object=new ReadObject();
		Properties allObjects=object.getObjectRespository();
		UIOperation operation=new UIOperation(driver);
		
		Sheet guru99Sheet=file.readExcel(System.getProperty("user.dir")+"\\","TestCase.xlsx" , "KeywordFramework");
		int rowCount=guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();
		
		for(int i=1;i<rowCount+1;i++) {
			Row row=guru99Sheet.getRow(i);
			
			if(row.getCell(0).toString().length()==0) {
				System.out.println(row.getCell(1).toString()+"--------"+row.getCell(2).toString()+"--------"+row.getCell(3).toString()+"--------"+row.getCell(4).toString()+"--------");
				operation.perform(allObjects, row.getCell(1).toString(), row.getCell(2).toString(), row.getCell(3).toString(), row.getCell(4).toString());				
			}
			else {
				System.out.println("New Test Case>-"+row.getCell(0).toString()+"");
			}
		}
	}
	
}
