package pages;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage {
	
	WebDriver driver;
	
	public SearchResultsPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By popUpCloseButtonLocator = By.xpath("//i[@class='icon icon-close']");
	By filtersCheckBoxLocator = By.xpath("//*[@class='cbox-label']");
	By busNameLocator = By.xpath("//div[@class='travels lh-24 f-bold d-color']");
	By busPriceLoactor = By.xpath("//span[@class='f-19 f-bold']");
	
	public void closePopUp()
	{
		
		try 
		{
			Thread.sleep(4500l);
			driver.findElement(popUpCloseButtonLocator).click();
		}
		catch(Exception e)
		{
			
		}
	}
	
	public void clickACcheckBox()
	{
		List <WebElement> allFiltersList = driver.findElements(filtersCheckBoxLocator);
		for(int i=0;i<allFiltersList.size();i++)
		{
			if(allFiltersList.get(i).getText().equalsIgnoreCase("AC"))
			{
				allFiltersList.get(i).click();
				break;
			}
		}
	}
	
	public void takeScreenshot()
	{
		TakesScreenshot scrnshot = ((TakesScreenshot) driver);
		File src = scrnshot.getScreenshotAs(OutputType.FILE);
		File dest = new File("src\\test\\resources\\screenshot\\TestResultScreenshot" + System.currentTimeMillis() + ".png");
		try {
			FileUtils.copyFile(src, dest);
		}
		catch (IOException e){}
	}
	
	public void printNameAndPrice()
	{
		System.out.println("\n\n Bus Name :\t"+driver.findElements(busNameLocator).get(1).getText());
		System.out.println("\n Price :\tRs. "+driver.findElements(busPriceLoactor).get(1).getText());
	}

}
