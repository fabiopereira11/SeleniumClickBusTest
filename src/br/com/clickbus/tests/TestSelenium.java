package br.com.clickbus.tests;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.clickbus.response.ResponseCode;

public class TestSelenium {
	
	private FirefoxDriver driver;
	private PopulateDataInHome populateDataInHome;
	
	
	@Before
	public void initialize(){
		this.driver = new FirefoxDriver();
		this.populateDataInHome = new PopulateDataInHome(driver);
		driver.get("http://www.clickbus.com.br");		
	}
//	
//	@Test
//	public void checkFooter(){
//		this.checkFooterLinks(driver);
//	}
	
	@Test
	public void testRouteSaoPauloCampinas() {
		populateDataInHome.PopulateSearchHome("Sao Paulo, SP - TODOS", "Campinas, SP", "01/11/2014", "26/11/2014");
		
		assertTrue(populateDataInHome.existResult());
	}
	
	public void finilize(){
		driver.close();		
	}
	
	
	public void checkFooterLinks(WebDriver driver){
		
		int counterLinkBroken = 0;
		int counterLinkSuccess = 0;
		
		WebElement container = driver.findElement(By.className("footer-container"));
		
		List<WebElement> links = container.findElements(By.tagName("a"));
		
		for (WebElement webElement : links) {
			
			
		 String linkURL = webElement.getAttribute("href");
		 boolean isValid = ResponseCode.getResponseCode(linkURL);
		 
		 	if (isValid) {
		 		
		 		System.out.println("This link is ok : " + linkURL);
		 		counterLinkSuccess++;
				
			}else{
				
				System.out.println("This link is broken : " + linkURL);
				counterLinkBroken++;
			}
			
		}
		
		System.out.println("There are " + counterLinkBroken + " broken links and " +counterLinkSuccess+ " links working!");
		
	}

}
