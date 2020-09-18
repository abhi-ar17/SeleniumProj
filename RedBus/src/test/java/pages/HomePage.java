package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By sourceLocationTextBoxLocator = By.xpath("//input[@id='src']");
	By destLocationTextBoxLocator = By.xpath("//input[@id='dest']");
	By autoFillListFirstLiLocator = By.xpath("//ul[@class='autoFill']//li[1]");
	By onwardDateLocator = By.xpath("//div[@class='fl search-box date-box gtm-onwardCalendar']");
	By yearMonthLocator = By.xpath("//td[@class='monthTitle']");
	By nextMonthButtonLocator = By.xpath("//td[@class='next']//button");
	By dateLocator = By.xpath("//td[@class='we day' or @class='wd day']");
	By searchBusButtonLocator = By.id("search_btn");
	
	public void selectFromandToLocation(String fromLocation,String toLocation)
	{
		driver.findElement(sourceLocationTextBoxLocator).sendKeys(fromLocation);
		driver.findElement(autoFillListFirstLiLocator).click();
		driver.findElement(destLocationTextBoxLocator).sendKeys(toLocation);
		driver.findElement(autoFillListFirstLiLocator).click();
	}
	
	public void datePicker(String monthYear,String date)
	{
		driver.findElement(onwardDateLocator).click();
		System.out.println("eo********"+driver.findElement(yearMonthLocator).getText());
		WebElement activeMonth = driver.findElement(yearMonthLocator);
		while(!activeMonth.getText().contains(monthYear))
		{
			driver.findElement(nextMonthButtonLocator).click();
			activeMonth = driver.findElement(yearMonthLocator);
		}
		List<WebElement> dates = driver.findElements(dateLocator);
		for(int i=0;i<dates.size();i++)
		{
			if(dates.get(i).getText().equals(date))
			{
				dates.get(i).click();
				break;
			}
		}
	}
	
	public void clickSearch()
	{
		driver.findElement(searchBusButtonLocator).click();
	}

}
