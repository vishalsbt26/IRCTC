package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.TestBase;

public class AirFrance extends TestBase {
	@FindBy(xpath = "//div[@class='mat-select-trigger ng-tns-c202-13']")
	WebElement tripType;
	
	@FindBy(xpath = "//div[@class='mat-form-field-infix ng-tns-c194-17']")
	WebElement fromLoc;
	
	@FindBy(xpath = "//div[@class='mat-form-field-infix ng-tns-c194-18']")
	WebElement toLoc;
	
	@FindBy(xpath = "//div[@class='mat-date-range-input-container']")
	WebElement travelDates;
	
	public AirFrance() {
		PageFactory.initElements(driver, this);
	}
	
	public void location() {
		driver.findElement(By.id("accept_cookies_btn")).click();
		fromLoc.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fromLoc.sendKeys("India");
		Actions action = new Actions(driver);
		action.keyDown(fromLoc, Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
	}
}
