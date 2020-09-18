package testscript;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import fileoperations.ReadExcel;
import pages.HomePage;
import pages.SearchResultsPage;
import testbase.LaunchBrowser;

public class TestScript extends LaunchBrowser {

//	WebDriver driver;
	
	@BeforeTest
	public void beforeTest()
	{
		LaunchBrowser.launchBrowser();
	}
	
	@Test(dataProvider = "testdata")
	public void test(String from,String to,String monthYear,String day)
	{
		HomePage hp = new HomePage(driver);
		hp.selectFromandToLocation(from,to);
		hp.datePicker(monthYear, day);
		hp.clickSearch();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		SearchResultsPage srp =new SearchResultsPage(driver);
		srp.closePopUp();
		srp.clickACcheckBox();
		srp.takeScreenshot();
		srp.printNameAndPrice();
	}
	
	@AfterTest
	public void afterTest()
	{
		driver.quit();
	}
	
	@DataProvider(name="testdata")
	public Object[][] testDataFeed()
	{
		ReadExcel config = new ReadExcel("src\\test\\resources\\datatables\\RedBusTestData.xlsx");

		int rows = config.getRowCount(0);
		int col=4;
		Object[][] data = new Object[rows-1][col];
		for (int i=0,instant = 1; instant < rows; i++,instant++) 
		{
			for(int z=0;z<col;z++)
			{
			data[i][z] = config.getData(0, instant, z);
			}	
		}
		return data;
	}

}
