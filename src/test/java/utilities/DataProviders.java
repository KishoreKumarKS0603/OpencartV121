package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders { 
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException{
		
		String path=".\\testData\\Opencart Login Testdata.xlsx";
		
		ExcelUtility Xlutil=new ExcelUtility(path);
		System.out.println("Hello");
		
		int totalrows=Xlutil.getRowCount("Sheet1");
		System.out.println(totalrows);
		int totalcols=Xlutil.getCellCount("Sheet1", 1);
		System.out.println(totalcols);
		
		String logindata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				logindata[i-1][j]=Xlutil.getCellData("Sheet1", i, j);
			}
	           }
		System.out.println(logindata[2][1]);
		
		return logindata;
	}
	
    //Dataprovider 2
	
	//Dataprovider 3
	/*public static void main(String[] args) throws IOException {
		System.out.println("Hi");
		DataProviders dat = new DataProviders();
		System.out.println(dat.getData());
	}*/
}
