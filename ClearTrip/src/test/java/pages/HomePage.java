package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}

	By roundTripRadioButtonLocator = By.id("RoundTrip");
	By fromLocationTextBoxLocator = By.id("FromTag");
	By toLocationTextBoxLoactor = By.id("ToTag");
	By departDateIconLocator = By.id("DepartDate");
	By returnDateIconLocator = By.id("ReturnDate");
	By firstMonthNameLocator = By.xpath("//div[@class='monthBlock first']//span[@class='ui-datepicker-month']");
	By nextMonthButtonLocator = By.className("nextMonth");
	By dateCellLocator = By.xpath("//div[@class='monthBlock first']//td[@class=' ' or @class=' weekEnd ' or @class=' ui-datepicker-days-cell-over  selected']");
	By popUpClose = By.xpath("//body[@class='optimisedCSS air home in  (none)']");
	By adultsDropDownLocator = By.id("Adults");
	By searchFlightsButtonLocator = By.id("SearchBtn");
	
	public void closePopUp()
	{
	
			driver.findElement(popUpClose).click();
	}
	
	public void selectRoundTrip()
	{
		driver.findElement(roundTripRadioButtonLocator).click();
	}
	
	
	public void selectFromToLoaction(String from,String to)
	{
		driver.findElement(fromLocationTextBoxLocator).sendKeys(from);
		driver.findElement(toLocationTextBoxLoactor).sendKeys(to);
	}
	
	public void selectDepartDate(String departDate)
	{	
		String month = departDate.split(" ")[0];
		String date = departDate.split(" ")[1];
		driver.findElement(departDateIconLocator).click();
		String firstMonthName = driver.findElement(firstMonthNameLocator).getText();
		while(!firstMonthName.equals(month))
		{
			driver.findElement(nextMonthButtonLocator).click();
		    firstMonthName = driver.findElement(firstMonthNameLocator).getText();
		}
		
		List <WebElement> dates = driver.findElements(dateCellLocator);
		for(int i=0;i<dates.size();i++)
		{
			if(dates.get(i).getText().equals(date))
			{
				dates.get(i).click();
				break;
			}
		}	
	}
	
	public void selectReturnDate(String returnDate)
	{
		String month = returnDate.split(" ")[0];
		String date = returnDate.split(" ")[1];
		driver.findElement(returnDateIconLocator).click();
		String firstMonthName = driver.findElement(firstMonthNameLocator).getText();
		while(!firstMonthName.equals(month))
		{
			driver.findElement(nextMonthButtonLocator).click();
		    firstMonthName = driver.findElement(firstMonthNameLocator).getText();
		}
		
		List <WebElement> dates = driver.findElements(dateCellLocator);
		for(int i=0;i<dates.size();i++)
		{
			if(dates.get(i).getText().equals(date))
			{
				dates.get(i).click();
				break;
			}
		}		
	}
	
	public void selectAdultsasTwo()
	{
		Select s = new Select(driver.findElement(adultsDropDownLocator));
		s.selectByVisibleText("2");
	}
	
	public void clickSearchFlights()
	{
		driver.findElement(searchFlightsButtonLocator).click();
	}
}
