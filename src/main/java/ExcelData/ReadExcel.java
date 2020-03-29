package ExcelData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
		public static String[][] testdata=new String[3][2];
	
//Function to read a data from Excel
		public  static void GetExcel()
		
		{
			
			try {
				File f1=new File("src\\test\\resources\\ExcelSheet\\Data.xlsx");
				FileInputStream fI=new FileInputStream(f1);
				XSSFWorkbook wb=new XSSFWorkbook(fI);
				XSSFSheet sh=wb.getSheet("Sheet1");
				
				for(int i=0;i<=2;i++)
				{
					XSSFRow R1=sh.getRow(i);
					for(int j=0;j<=1;j++)
					{
				XSSFCell c1=R1.getCell(j);
				
				testdata[i][j]=c1.getStringCellValue();
				System.out.println(testdata[i][j]);
				}
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}

}
