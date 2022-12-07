package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.TestBase;

public class TurkishAirlines extends TestBase {
	@FindBy(xpath = "//input[@id='portInputFrom']")
	WebElement fromLoc;
	
	@FindBy(id = "destinationSelector")
	WebElement toLoc;
	
	public TurkishAirlines() {
		PageFactory.initElements(driver, this);
	}
	
	public void location() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fromLoc.sendKeys("Mumbai");
		Actions action = new Actions(driver);
		action.keyDown(fromLoc, Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
	}
}
