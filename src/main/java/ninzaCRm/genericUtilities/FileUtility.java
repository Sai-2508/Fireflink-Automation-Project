package ninzaCRm.genericUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic methods related to file operations like property file,excel file
 * @author Penugonda SaiDurga
 */
public class FileUtility {
	
	
	/**
	 * This method will read data from property file
	 * @param key
	 * @return 
	 * @throws IOException
	 */
	
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis =  new FileInputStream("C:\\Users\\User\\eclipse-workspace\\Fireflink.NinzaCRM.AutomationFramework\\src\\test\\resources\\CommonData.properties");
		 
		 Properties p = new Properties();
		 p.load(fis);
		 String value = p.getProperty(key);
		 return value;
	} 

		 //read data from excel,read multiple data,write data into excel
		 /**
		  * This method will read data from excel file and return
		  * @param sheetName
		  * @param rowNo
		  * @param CellNo
		  * @return
		 * @throws IOException 
		 * @throws EncryptedDocumentException 
		  */
		 
		 public String  readDataFromExcel(String sheetName,int rowNo,int CellNo) throws EncryptedDocumentException, IOException
		 {
		 
		 FileInputStream fis= new FileInputStream("C:\\Users\\User\\eclipse-workspace\\Fireflink.NinzaCRM.AutomationFramework\\src\\test\\resources\\testData.xlsx");
		 
		 Workbook  wb = WorkbookFactory.create(fis);
		  return wb.getSheet(sheetName).getRow(rowNo).getCell(CellNo).getStringCellValue();
		 
		
		 }	
		 
		 //read multiple data from excel
		 
		 public String readMultipledatafromExcel(String sheetname,int rowno,int cellno) throws EncryptedDocumentException, IOException
		 {
			 FileInputStream fis= new FileInputStream("C:\\Users\\User\\eclipse-workspace\\Fireflink.NinzaCRM.AutomationFramework\\src\\test\\resources\\testData.xlsx");
			 
			 Workbook  wb = WorkbookFactory.create(fis); 
			 return  wb.getSheet(sheetname).getRow(rowno).getCell(cellno).getStringCellValue();
			 //check the above line its just 
			 
			 
			 
			 
		 }
		 
		 
		 
		 
		
	}
	


