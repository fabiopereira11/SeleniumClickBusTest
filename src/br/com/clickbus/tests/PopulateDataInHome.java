package br.com.clickbus.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopulateDataInHome {
	
	private final WebDriver driver;
	
	public PopulateDataInHome(WebDriver driver){
		this.driver = driver;
		
	}
	
	
	public void PopulateSearchHome(String origin, String destiny, String departureDate, String returnDate){
		
		WebElement originField = driver.findElement(By.id("originPlace"));
		WebElement destinyField = driver.findElement(By.id("destinationPlace"));
		WebElement departureDateField = driver.findElement(By.id("departureDate"));
		WebElement returnDateField = driver.findElement(By.id("returnDate"));
		WebElement search = driver.findElement(By.id("btn-search"));
		
		originField.sendKeys(origin);
		destinyField.sendKeys(destiny);
		departureDateField.sendKeys(departureDate);
		returnDateField.sendKeys(returnDate);
		
		search.click();
		
	}
	
	public boolean existResult(){
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver.getPageSource().contains("Escolher Ida");
		
	}

}
