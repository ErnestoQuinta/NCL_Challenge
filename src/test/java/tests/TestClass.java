package tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features/",tags="@Scenario1, @Scenario2, @Scenario3",  
		glue= {"step_definitions"}
		)



public class TestClass {

	
}
