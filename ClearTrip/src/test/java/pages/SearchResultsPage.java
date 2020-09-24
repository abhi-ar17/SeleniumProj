package pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {
	
	WebDriver driver;
	
	public SearchResultsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	By bookButtonLocator = By.xpath("//button[@class='bg-orange hover:bg-orange-dark bc-transparent c-white fw-600 c-pointer fs-body py-1 px-3 h-8 button bs-solid tp-color td-500 bw-1 br-4 lh-solid box-border']");

	public void takeScreenshot()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(bookButtonLocator)));
		TakesScreenshot scrnshot = ((TakesScreenshot) driver);
		File src = scrnshot.getScreenshotAs(OutputType.FILE);
		File dest = new File("src\\test\\resources\\screenshot\\TestResultScreenshot" + System.currentTimeMillis() + ".png");
		try {
			FileUtils.copyFile(src, dest);
		}
		catch (IOException e){}
	}
}
