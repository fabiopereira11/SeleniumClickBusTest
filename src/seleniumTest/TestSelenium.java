package seleniumTest;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSelenium {
	
	@Test
	public void testRouteSaoPauloCampinas() {

		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.clickbus.com.br");
		
		WebElement origem = driver.findElement(By.id("originPlace"));
		WebElement destino = driver.findElement(By.id("destinationPlace"));
		WebElement dataPartida = driver.findElement(By.id("departureDate"));
		WebElement dataRetorno = driver.findElement(By.id("returnDate"));
		WebElement search = driver.findElement(By.id("btn-search"));
		
		int contadorLinkQuebrado = 0;
		int contadorLinkSucesso = 0;
		
		WebElement container = driver.findElement(By.className("footer-container"));
		
		List<WebElement> links = container.findElements(By.tagName("a"));
		
		for (WebElement webElement : links) {
			
			
		 String linkURL = webElement.getAttribute("href");
		 boolean isValid = getResponseCode(linkURL);
		 
		 	if (isValid) {
		 		
		 		System.out.println("Este link esta ok : " + linkURL);
		 		contadorLinkSucesso ++;
				
			}else{
				
				System.out.println("Este link esta quebrado : " + linkURL);
				contadorLinkQuebrado ++;
			}
			
		}
		
		System.out.println("Existem " + contadorLinkQuebrado + " links quebrados e " +contadorLinkSucesso+ " links funcionando!");
		
		
		origem.sendKeys("Sao Paulo, SP - TODOS");
		destino.sendKeys("Campinas, SP");
		dataPartida.sendKeys("31/10/2014");
		dataRetorno.sendKeys("20/11/2014");
		
		search.submit();
		
//		driver.close();
		
	}
	
	
	public static boolean getResponseCode(String urlString) {
        boolean isValid = false;
        try {
            URL u = new URL(urlString);
            HttpURLConnection h = (HttpURLConnection) u.openConnection();
            h.setRequestMethod("GET");
            h.connect();
            System.out.println(h.getResponseCode());
            if (h.getResponseCode() != 404) {
                isValid = true;
            }
        } catch (Exception e) {

        }
        return isValid;
    }

}
