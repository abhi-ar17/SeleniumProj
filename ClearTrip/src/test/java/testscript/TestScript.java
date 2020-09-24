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
	
	
	@BeforeTest
	public void beforeTest()
	{
		LaunchBrowser.launchBrowser("https://www.cleartrip.com/flights");
	}
	
	@Test(dataProvider="testdata")
	public void test(String from,String to,String departDate,String returnDate)
	{
		HomePage hp = new HomePage(driver);
		hp.closePopUp();
		hp.selectRoundTrip();
		hp.selectFromToLoaction(from, to);
		hp.selectDepartDate(departDate);
		hp.selectReturnDate(returnDate);
		hp.selectAdultsasTwo();
		hp.clickSearchFlights();
	}

	@AfterTest
	public void afterTest()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		SearchResultsPage srp = new SearchResultsPage(driver);
		srp.takeScreenshot();
		driver.quit();
	}
	
	
	
	@DataProvider(name="testdata")
	public Object[][] testDataFeed()
	{
		ReadExcel config = new ReadExcel("src\\test\\resources\\datatables\\ClearTripTestData.xlsx");

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
