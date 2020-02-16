package step_definitions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import constants.Constants;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import page_object_factory.HomepagePageFactory;
import page_object_factory.PortsPageFactory;
import page_object_factory.ShoreExcursionPageFactory;

public class NCL_Challenge1 {
	
	static WebDriver driver; 
	private HomepagePageFactory hp ;
	private PortsPageFactory port;
	private ShoreExcursionPageFactory shore;  

	
	
	
		@Given("^a Guest$")
		public void a_Guest() throws Throwable {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			hp	  =  new HomepagePageFactory(driver);
			port  =  new PortsPageFactory(driver);
			shore =  new ShoreExcursionPageFactory(driver);
    
		}

		@And("^I am on Homepage$")
		public void i_am_on_Homepage() throws Throwable {
			System.out.println("Navigating to the Homepage.");
			driver.navigate().to(Constants.BASE_URL);		
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
			//hp.closeEasylinkIcon();
			
		}

		@And("^I navigated to \"([^\"]*)\" page$")
		public void i_navigated_to_page(String arg1) throws Throwable {			
		    if (arg1.equalsIgnoreCase("Shore Excursion")) {  
		    	hp.clickExploreShoreExcursionLink();
		    }else {	
		    	hp.clickPortsLink();
		    }
		}

		@When("^I search for \"([^\"]*)\" port$")
		public void i_search_for_port(String arg1) throws Throwable{
			port.searchPort(arg1);		   
		}

		@Then("^Map zoomed to show selected port$")
		public void map_zoomed_to_show_selected_port(){
			port.portIsDisplayed();
		}

		@Then("^Port is on the middle of the map$")
		public void port_is_on_the_middle_of_the_map(){
			 port.portInMiddle();
		}

		@And("^Port displayed as “Port Of Departure”$")
		public void port_displayed_as_Port_Of_Departure(){
			port.portIsDeparture();
		}

		@And("^I search for destination \"([^\"]*)\"$")
		public void i_search_for_destination(String arg1){
		  shore.searchDestination(arg1);
		   
		}

		@Then("^Shore Excursions page is present$")
		public void shore_Excursions_page_is_present() throws Throwable {
			shore.clickFindExcursions();
			shore.shoreExcursionPageIsDisplayed();
		}

		@And("^Results are filtered by \"([^\"]*)\"$")
		public void results_are_filtered_by(String arg1) throws Throwable {
			shore.filterByDestination(arg1);
		}

		@And("^Filter By Ports are only belong to \"([^\"]*)\"$")
		public void filter_By_Ports_are_only_belong_to(String arg1) throws Throwable {
		    shore.clickFilterPort();
		}

		@And("^I click Find Excursions$")
		public void i_click_Find_Excursions() throws Throwable {
			shore.clickFindExcursions();
		}

		@And("^Shore Excursions page is loaded$")
		public void shore_Excursions_page_is_loaded() throws Throwable {
			shore.shoreExcursionPageIsDisplayed();
		}

		@When("^Price range is filtered to \"([^\"]*)\"$")
		public void price_range_is_filtered_to(String arg1) throws Throwable {
			System.out.println("Filter for '"+arg1+"' price range" );
			shore.filterbyPrice(arg1);
			
		}

		@Then("^Only shore excursions within range are displayed$")
		public void only_shore_excursions_within_range_are_displayed() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		    
		}
		
}
