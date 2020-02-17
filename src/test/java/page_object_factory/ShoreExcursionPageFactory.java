package page_object_factory;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ShoreExcursionPageFactory {
	
	WebDriver driver;
	
	@FindBy(id="search_destinations_chosen")
	WebElement destination_dropdown;
	
	@FindBy(xpath="//div[@id='search_destinations_chosen']//input[@class='chosen-search-input']")
	WebElement destination_input;
	
	@FindBy(xpath="//div[@id='search_destinations_chosen']//ul[@class='chosen-results']/li")
	WebElement first_result;
	
	@FindBy(xpath="//section[@id='page-shore-excursions']//button[contains(@class, 'search-submit')]")
	WebElement find_excursions;
	
	@FindBy(xpath="//div[@class='filter-options']//a[@title='Destination']/following-sibling::div[@class='widget-items']/ul/li/a")
	WebElement filterTerm;
	
	@FindBy(xpath="//div[@class='search-filter']//span[contains(text(),'Port')]")
	WebElement portFilter;
	
	@FindBy(xpath="//div[@class='filter-options']//a[@title='Destination']/following-sibling::div[@class='widget-items']/ul/li")
	List<WebElement> destinationFiltered;
	
	@FindBy(xpath="//li[@class='opened']//div[@class='filterbox']")
	WebElement portModal;
	
	@FindBy(xpath="//div[@id='price-slider-values']//span[1]")
	WebElement priceFilter1;
	
	@FindBy(xpath="//div[@id='price-slider-values']//span[2]")
	WebElement priceFilter;
	
	
	
	public ShoreExcursionPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void filterbyPrice(String priceRange) {

		String [] values = priceRange.split("-");
		
		String minValue = values[0].substring(1);
		String maxValue = values[1].substring(1);
		
		System.out.println("minimun value : "+ minValue);
		System.out.println("maximun value : "+ maxValue);
		
		Actions act = new Actions(driver);
		
		int priceMin = priceFilter1.getLocation().getX();
		System.out.println("1 - get X: "+priceMin);		
		int priceMax = priceFilter.getLocation().getX();
		System.out.println("get X: "+priceMax);
		
		int diff = priceMax - priceMin;
		
		System.out.println("price bar total in pixels : "+ diff);
	
		act.dragAndDropBy(priceFilter, -180, 0).release().build().perform();
	   	    
		/*
		 * continue working on this, drag and drop is not the optimal method since the value is to small and will be trigger and error
		 * the other idea will be changing the value in the URL but this will not be the most realistic option.
		 * So still need clarification. 
		*/
		
	}
	
	public void searchDestination(String destination) {
		System.out.println("Clicking on destination dropdown.");
		destination_dropdown.click();	
		System.out.println("Enter desired destination: '"+destination+"'");
		destination_input.sendKeys(destination);
		System.out.println("Click on the first result listed.");
		first_result.click();
	}
	
	
	public void clickFindExcursions() {
		System.out.println("Clicking on find excursions button.");
		find_excursions.click();
	}
	
	public void shoreExcursionPageIsDisplayed() {
		System.out.println("Verifing the shore excursions page loaded.");
		assertTrue(driver.getCurrentUrl().contains("/shore-excursions/"), "The current page is not the expected. Please review it.");

	}
	
	public void filterByDestination(String destination) {
		System.out.println("Verifying that only '"+destination+"' filter is visible.");
		   int i = destinationFiltered.size();
		   if (i==1) {
			  assertTrue(filterTerm.getAttribute("title").equalsIgnoreCase(destination), "Filter By is no the expected. please review it.");
		   }else {
			   assertTrue(false,  "Filter By is no the expected. please review it.");
		   }
	}
	
	public void clickFilterPort() {
		System.out.println("Clicking on port filter.");
		portFilter.click();
		System.out.println("Verifying modal displayed");
		assertTrue(portModal.isDisplayed(),"Modal is missing. please review it.");
	}

}
