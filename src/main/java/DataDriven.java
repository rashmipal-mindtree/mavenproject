import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public static ArrayList<String> getData(String testcaseName) throws IOException {
		// TODO Auto-generated method stub
		
		//String[] strArr = new String[5];
		//int count_strArr =0;
		ArrayList<String> al = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("C:\\Users\\palra\\Documents\\data_rest_api_example.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int count = workbook.getNumberOfSheets();
		
		for (int i =0; i < count; i++) {
		if (workbook.getSheetName(i).equalsIgnoreCase("TestData")) {
			XSSFSheet sheet = workbook.getSheetAt(i);
			//Identify test cases column by scanning the first row
			Iterator<Row> rows = sheet.iterator(); // sheet is collection of rows
			Row firstRow = rows.next();
			
			Iterator<Cell> cell = firstRow.cellIterator(); //row is collection of cells
			int k =0;
			int column =0;
			while(cell.hasNext()) {
				Cell value = cell.next();
				if(value.getStringCellValue().equalsIgnoreCase("Testcases")) {
					// desired column					
					column = k;
					break;
					
				}
				k++;
				
			}
			
		
			//once column is identified then entire test case column us scanned and get the purchase test case row
			while(rows.hasNext()) {
				Row r = rows.next();
				if(r.getCell(column).getStringCellValue().equals(testcaseName)){
					// after grabbing AddBook test case row , and get all the data from the other columns of that row
					Iterator<Cell> cv  = r.cellIterator();
					while(cv.hasNext()) {						
						//strArr[count_strArr] = cv.next().getStringCellValue();
						al.add(cv.next().getStringCellValue());
						//System.out.println(strArr[count_strArr]);		
						//count_strArr++;
					}
					
				
					
				}
			}
			
				
		 }
		}
		
		
		
		/*for (int i=0; i <strArr.length; i++) {
			System.out.println(strArr[i]);
		}*/
		
		for (int i=0; i <al.size(); i++) {
			System.out.println(al.get(i));
		}
		return al;
		

	}
	
	public static void main(String[] args) throws IOException {
		getData("Delete Profile");
		
	}

}
