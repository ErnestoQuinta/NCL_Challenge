package com.ncl.challenge.Scenarios;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Common {
	
	
	public static void keyEnterAction(WebDriver driver){
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER);
		actions.build().perform();
	}

}
