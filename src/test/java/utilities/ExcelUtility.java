package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public  FileInputStream fi;
	public FileOutputStream fo;
	public  XSSFWorkbook wb;
	public  XSSFSheet ws;
	public  XSSFRow row;
	public  XSSFCell cell; 
	String  path;
	
	public ExcelUtility(String  path) {
		this.path=path;
		
	}
	
	public int getRowCount(String xlsheet) throws IOException {
		
		fi =new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		int rowcount=ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
	}
	
   public  int getCellCount(String xlsheet,int rownum) throws IOException {
		
	   fi =new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		int cellcount=row.getLastCellNum(); 
		
		wb.close();
		fi.close();
		return cellcount;
	}
   
   public  String getCellData(String xlsheet,int rownum,int colnm) throws IOException {
		
	   fi =new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
	    cell=row.getCell(colnm); 
	    
	    DataFormatter formatter = new DataFormatter();
	    String data;
	    try
	    {
	    	//data=cell.toString();
	    	
	    	data=formatter.formatCellValue(cell);
	    }
	    catch(Exception e) {
	    	data="";
	    }
		
		wb.close();
		fi.close();
		return data;
	}   
   
   public  void setCellData(String xlsheet,int rownum,int colnm,String data) throws IOException {
		File xlfile =new File(path);
		if(!xlfile.exists())
		{
			wb=new XSSFWorkbook(fi);
			fo=new FileOutputStream(path);
			wb.write(fo);
		}
		if(wb.getSheetIndex(xlsheet)==-1)
		   wb.createSheet(xlsheet);
		   ws=wb.getSheet(xlsheet);
	   
		   if(ws.getRow(rownum)==null)
		   ws.createRow(rownum);
		   row=ws.getRow(rownum);
		
		
	    cell=row.getCell(colnm); 
	    cell.setCellValue(data);
	   fo=new FileOutputStream(path);
		
	    wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		
	}      
}
