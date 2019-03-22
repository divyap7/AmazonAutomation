package actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataExcelRead {

	public static HashMap<String, HashMap<String, HashMap<String,String>>> initializeTestData() {
		
		HashMap<String, HashMap<String,String>> rowMap= new HashMap<String, HashMap<String,String>>();
		HashMap<String, HashMap<String, HashMap<String,String>>> sheetMap= new HashMap<String, HashMap<String, HashMap<String,String>>>();
		try {
			FileInputStream fs = new FileInputStream("TestData.xlsx");
			String ext = FilenameUtils.getExtension("TestData.xlsx"); 
			if(ext.equals("xlsx")){
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			for(int a=0; a<workbook.getNumberOfSheets();a++){
				rowMap= new HashMap<String, HashMap<String,String>>();
				XSSFSheet sheet = workbook.getSheetAt(a);
				Row HeaderRow = sheet.getRow(0);
				for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
					Row currentRow = sheet.getRow(i);
					HashMap<String,String> currentHash = new HashMap<String,String>();
					for (int j = 1; j < HeaderRow.getLastCellNum(); j++) {
						//System.out.println("TOTAL CELL COUNT::::::::: "+j+":::  "+HeaderRow.getLastCellNum());
						Cell currentCell = currentRow.getCell(j);
						if(currentRow.getCell(j)==null){
							currentHash.put(HeaderRow.getCell(j).getStringCellValue(), "");
						}else{
							if(!currentCell.getStringCellValue().isEmpty() ){
								currentHash.put(HeaderRow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
								//System.out.println("Col val :   "+HeaderRow.getCell(j).getStringCellValue()+"   data Val:: "+currentCell.getStringCellValue());
							}else{
								currentHash.put(HeaderRow.getCell(j).getStringCellValue(), "");
							}
						/*switch (currentCell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							break;
						}*/
						}
					}
					rowMap.put(currentRow.getCell(0).getStringCellValue().trim(), currentHash);
				}
				sheetMap.put(workbook.getSheetName(a), rowMap);
			}}else if(ext.equals("xls")){
				HSSFWorkbook workbook = new HSSFWorkbook(fs);
				for(int a=0; a<workbook.getNumberOfSheets();a++){
					rowMap= new HashMap<String, HashMap<String,String>>();
					HSSFSheet sheet = workbook.getSheetAt(a);
					Row HeaderRow = sheet.getRow(0);
					for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
						Row currentRow = sheet.getRow(i);
						HashMap<String,String> currentHash = new HashMap<String,String>();
						for (int j = 1; j < HeaderRow.getLastCellNum(); j++) {
							//System.out.println("TOTAL CELL COUNT::::::::: "+j+":::  "+HeaderRow.getLastCellNum());
							Cell currentCell = currentRow.getCell(j);
							if(currentRow.getCell(j)==null){
								currentHash.put(HeaderRow.getCell(j).getStringCellValue(), "");
							}else{
								if(!currentCell.getStringCellValue().isEmpty() ){
									currentHash.put(HeaderRow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
									//System.out.println("Col val :   "+HeaderRow.getCell(j).getStringCellValue()+"   data Val:: "+currentCell.getStringCellValue());
								}else{
									currentHash.put(HeaderRow.getCell(j).getStringCellValue(), "");
								}
							/*switch (currentCell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								break;
							}*/
							}
						}
						rowMap.put(currentRow.getCell(0).getStringCellValue().trim(), currentHash);
					}
					sheetMap.put(workbook.getSheetName(a), rowMap);
				}
			}
			fs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sheetMap;
	}
	
	public static void main(String[] args){
		HashMap<String, HashMap<String, HashMap<String,String>>> sheetMap=initializeTestData();
		System.out.println("******************************************");
		//System.out.println("1st row 3rd value first sheet"+ sheetMap.get("PriceCompetitor").get("PC_Create_PriceZones_1").get("country") );
		System.out.println("******************************************");
		//System.out.println("1st row 3rd value second sheet"+ sheetMap.get("PriceCompetitor").get("PC_Create_PriceZones_2").get("country") );
	}
}
