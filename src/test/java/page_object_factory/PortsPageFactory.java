package page_object_factory;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PortsPageFactory {
	
	WebDriver driver;
	
	@FindBy(id="searchbar")
	WebElement search_input;
	
	@FindBy(xpath="//div[@id='map-info-clone']//div[@id='map-zoom']//li[@class='control-zoom-in']/i[contains(@class,'icon-plus-simple-bold')]")
	List<WebElement> portDisplayed;
			
	@FindBy(xpath="(//div[contains(text(),'Honolulu') and contains(@style,'display: block')])[1]")
	List<WebElement> portMiddle;
	
	@FindBy(xpath="(//section[@id='portsLandingMap']//div[@id='ports-map']//img[contains(@src,'/icons/pin-port-of-departure')])[1]")
	List<WebElement> portDeparture;
	
	
	public PortsPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void searchPort(String port) throws Throwable {
		System.out.println("Search for port: '"+port+"'");
		Thread.sleep(2);
		search_input.sendKeys(port);
		System.out.println("Click on the first result.");
		driver.findElement(By.xpath("//ul[contains(@class,'list-find-port')]//a[contains(@title, '"+port+"')]")).click();	
	}
	
	public void portIsDisplayed() {
		System.out.println("Verifiying selected port is displayed.");
		assertTrue(portDisplayed.size() == 1,"Map wasnt zoomed. Please review it.");
		
	}
	
	public void portInMiddle() {
		 System.out.println("Verifiying port map is zoomed.");
		 assertTrue(portMiddle.size() == 1,"Map wasnt zoomed. Please review it.");

	}
	
	public void portIsDeparture() {
		System.out.println("Verifying the port is displayed as departure port.");
	    assertTrue(portDeparture.size()==1,"The port is not a departure port. please review it.");
	
	}
	
	
}
