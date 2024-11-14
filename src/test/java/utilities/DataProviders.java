package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	//DataProvider 1	
		@DataProvider(name="LoginData")
		public String [][] getData() throws IOException
		{
			String path=".\\testData\\SignInPageTestData.xlsx";//taking xl file from testData
			
			ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
			
			int totalrows=xlutil.getRowCount("Sheet1");	
			int totalcols=xlutil.getCellCount("Sheet1",1);
					
			String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
			
			for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
			{		
				for(int j=0;j<totalcols;j++)  //0    i is rows j is col
				{
					logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
				}
			}
		return logindata;//returning two dimension array
					
		}
		
		//DataProvider 2
		@DataProvider(name="EmptyUserOrPwdLoginData")
		public String [][] getEmptyData() throws IOException
		{
			String path=".\\testData\\SignInPageTestData.xlsx";//taking xl file from testData
			
			ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
			
			int totalrows=xlutil.getRowCount("Sheet2");	
			int totalcols=xlutil.getCellCount("Sheet2",1);
					
			String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
			
			for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
			{		
				for(int j=0;j<totalcols;j++)  //0    i is rows j is col
				{
					logindata[i-1][j]= xlutil.getCellData("Sheet2",i, j);  //1,0
				}
			}
		return logindata;//returning two dimension array
					
		}
		
		
		//DataProvider 3
			@DataProvider(name="RegisterWithInvalidData")
			public String [][] getRegisterData() throws IOException
			{
				String path=".\\testData\\RegisterPageData.xlsx";//taking xl file from testData
				
				ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
				
				int totalrows=xlutil.getRowCount("Sheet1");	
				int totalcols=xlutil.getCellCount("Sheet1",1);
						
				String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
				
				for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
				{		
					for(int j=0;j<totalcols;j++)  //0    i is rows j is col
					{
						logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
					}
				}
			return logindata;//returning two dimension array
						
			}
			
			
			//DataProvider 4
			@DataProvider(name="GetStartedTopics")
			public String [][] getStartedTopic() throws IOException
			{
				String path=".\\testData\\HomePageTestData.xlsx";//taking xl file from testData
				
				ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
				
				int totalrows=xlutil.getRowCount("Sheet1");	
				int totalcols=xlutil.getCellCount("Sheet1",1);
						
				String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
				
				for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
				{		
					for(int j=0;j<totalcols;j++)  //0    i is rows j is col
					{
						logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
					}
				}
			return logindata;//returning two dimension array
						
			}
			
			//DataProvider 5
			@DataProvider(name="DropdownTopics")
			public String [][] dropdownTopic() throws IOException
			{
				String path=".\\testData\\HomePageTestData.xlsx";//taking xl file from testData
				
				ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
				
				int totalrows=xlutil.getRowCount("Sheet2");	
				int totalcols=xlutil.getCellCount("Sheet2",1);
						
				String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
				
				for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
				{		
					for(int j=0;j<totalcols;j++)  //0    i is rows j is col
					{
						logindata[i-1][j]= xlutil.getCellData("Sheet2",i, j);  //1,0
					}
				}
			return logindata;//returning two dimension array
						


}
}