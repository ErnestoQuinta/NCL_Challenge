package page_object_factory;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class HomepagePageFactory {
	
	//CREATE A WEBDRIVER OBJECT
			WebDriver driver;
		
			
			
	@FindBy(xpath="//body[@id='body-welcome']//div[@id='close']/a")
	WebElement easylink_icon_close;
	
	@FindBy(xpath="//a[contains(@href,'/shore-excursion') and contains(text(),'Explore Shore Excursion')]")
	WebElement explore_shore_link;
	
	@FindBy(xpath="//footer//a[contains(@href,'/port-of-call') and @title='Ports']")
	WebElement ports_link;
	
	
	
	
	
	public HomepagePageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void closeEasylinkIcon() {
		try {
			if(easylink_icon_close.isDisplayed()) {
			System.out.println( "Closing the easylink.");
			easylink_icon_close.click();
			}
		}catch(Exception e) {
			e.getMessage();
		}
		
		
	}
	
	public void clickExploreShoreExcursionLink() throws InterruptedException {
    	System.out.println("Clicking on the 'Explore Shore Excursion' link");
		explore_shore_link.click();
		String url = driver.getCurrentUrl();
		assertTrue(url.contains("/shore-excursions"), "Expected page doesnt load. Please review it.");
	}
	
	
	public void clickPortsLink() throws InterruptedException {
    	System.out.println("Clicking on the 'Ports' link.");
		ports_link.click();
		String url = driver.getCurrentUrl();
		assertTrue(url.contains("/port-of-call"), "Expected page doesnt loaded. Please review it.");
	}
	

}
