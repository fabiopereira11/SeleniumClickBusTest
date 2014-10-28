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
	
	
	
	private final long MILLISECONDS = 6000;
	private final String NO_ROUTE = "No exist route for this search";
	private FirefoxDriver driver;
	private PopulateDataInHome populateDataInHome;
	
	
	@Before
	public void initialize(){
		this.driver = new FirefoxDriver();
		this.populateDataInHome = new PopulateDataInHome(driver);
		driver.get("http://www.clickbus.com.br");		
	}
	
	
	
	@Test
	public void testRouteSaoPauloCampinas() throws Throwable {
		populateDataInHome.PopulateSearchHome("Sao Paulo, SP - TODOS", "Campinas, SP", "01/11/2014", "26/11/2014");
		
		Thread.sleep(MILLISECONDS);
		
		if (populateDataInHome.existResult()) {
			
			assertTrue(true);
			driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
			Thread.sleep(MILLISECONDS);
			
			if (populateDataInHome.existResultAfterChooseGoing()) {
				
				assertTrue(true);
				driver.findElement(By.xpath("(//button[@type='button'])[111]")).click();
				Thread.sleep(MILLISECONDS);
				this.finalize();
			}else{
				assertTrue(false);
			}
		}else{
			if (populateDataInHome.existNoOfferRouteResult()) {
				
				System.out.println(NO_ROUTE);
				assertTrue(true);
				this.finalize();
			}else{
				
				assertTrue(false);
				this.finalize();
			}
		}
		
	}
	
	@Test
	public void testRouteSaoPauloSaoJoseDosCampos() throws Throwable {
		populateDataInHome.PopulateSearchHome("Sao Paulo, SP - TODOS", "Sao Jose dos Campos, SP", "01/11/2014", "26/11/2014");
		
		Thread.sleep(MILLISECONDS);
		
		if (populateDataInHome.existResult()) {
			
			assertTrue(true);
			driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
			Thread.sleep(MILLISECONDS);
			
			if (populateDataInHome.existResultAfterChooseGoing()) {
				
				assertTrue(true);
				driver.findElement(By.xpath("(//button[@type='button'])[111]")).click();
				Thread.sleep(MILLISECONDS);
				this.finalize();
			}else{
				assertTrue(false);
			}
		}else{
			if (populateDataInHome.existNoOfferRouteResult()) {
				
				System.out.println(NO_ROUTE);
				assertTrue(true);
				this.finalize();
			}else{
				
				assertTrue(false);
				this.finalize();
			}
		}
		
	}
	
	
	@Test
	public void testRouteCampinasAmericana() throws Throwable {
		populateDataInHome.PopulateSearchHome("Campinas, SP", "Americana, SP", "01/11/2014", "26/11/2014");
		
		Thread.sleep(MILLISECONDS);
		
		if (populateDataInHome.existResult()) {
			
			assertTrue(true);
			driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
			Thread.sleep(MILLISECONDS);
			
			if (populateDataInHome.existResultAfterChooseGoing()) {
				
				assertTrue(true);
				driver.findElement(By.cssSelector("button.searchResultsSubmitButton.searchResultsSelectButton")).click();
				Thread.sleep(MILLISECONDS);
				this.finalize();
			}else{
				assertTrue(false);
			}
		}else{
			if (populateDataInHome.existNoOfferRouteResult()) {
				
				System.out.println(NO_ROUTE);
				assertTrue(true);
				this.finalize();
			}else{
				
				assertTrue(false);
				this.finalize();
			}
		}
		
	}
	
	
	@Test
	public void testRouteSaoPauloSantos() throws Throwable {
		populateDataInHome.PopulateSearchHome("Sao Paulo, SP - TODOS", "Santos, SP", "01/11/2014", "26/11/2014");
		
		Thread.sleep(MILLISECONDS);
		
		if (populateDataInHome.existResult()) {
			
			assertTrue(true);
			driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
			Thread.sleep(MILLISECONDS);
			
			if (populateDataInHome.existResultAfterChooseGoing()) {
				
				assertTrue(true);
				driver.findElement(By.cssSelector("button.searchResultsSubmitButton.searchResultsSelectButton")).click();
				Thread.sleep(MILLISECONDS);
				this.finalize();
			}else{
				assertTrue(false);
			}
		}else{
			if (populateDataInHome.existNoOfferRouteResult()) {
				
				System.out.println(NO_ROUTE);
				assertTrue(true);
				this.finalize();
			}else{
				
				assertTrue(false);
				this.finalize();
			}
		}
		
	}
	
	
	@Test
	public void testRouteSaoCaetanoDoSulCampinas() throws Throwable {
		populateDataInHome.PopulateSearchHome("Sao Caetano do Sul, SP", "Campinas, SP", "01/11/2014", "26/11/2014");
		
		Thread.sleep(MILLISECONDS);
		
		if (populateDataInHome.existResult()) {
			
			assertTrue(true);
			driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
			Thread.sleep(MILLISECONDS);
			
			if (populateDataInHome.existResultAfterChooseGoing()) {
				
				assertTrue(true);
				driver.findElement(By.cssSelector("button.searchResultsSubmitButton.searchResultsSelectButton")).click();
				Thread.sleep(MILLISECONDS);
				this.finalize();
			}else{
				assertTrue(false);
			}
		}else{
			if (populateDataInHome.existNoOfferRouteResult()) {
				
				System.out.println(NO_ROUTE);
				assertTrue(true);
				this.finalize();
			}else{
				
				assertTrue(false);
				this.finalize();
			}
		}
		
	}
	
	
	@Test
	public void checkFooter() throws Throwable{
		this.checkFooterLinks();
		this.finalize();
	}
	
	
	public void finilize(){
		driver.close();		
	}
	
	
	public void checkFooterLinks(){
		
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
