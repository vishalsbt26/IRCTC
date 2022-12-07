package com.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.base.TestBase;

public class SouthWest extends TestBase {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	@FindBy(id = "LandingAirBookingSearchForm_originationAirportCode")
	WebElement fromLoc;

	@FindBy(id = "LandingAirBookingSearchForm_destinationAirportCode")
	WebElement toLoc;

	@FindBy(id = "LandingAirBookingSearchForm_departureDate")
	WebElement fromDate;

	public SouthWest() {
		PageFactory.initElements(driver, this);
	}

	public void location() {
		fromLoc.click();
		fromLoc.sendKeys("New");
		Actions action = new Actions(driver);
		action.keyDown(fromLoc, Keys.DOWN).sendKeys(Keys.ENTER).build().perform();

		toLoc.click();
		toLoc.sendKeys("Nas");
		action.keyDown(toLoc, Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
	}

	public void departDate() {
		fromDate.click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("calendar-month")));

		String cal = driver.findElement(By.xpath("(//div[@class='calendar-month--title'])[1]")).getText();
		System.out.println(cal);
		String month = cal.split(" ")[0].trim();
		String year = cal.split(" ")[1].trim();
		while (!(month.equals("February") && year.equals("2023"))) {
			driver.findElement(By.xpath(
					"//button[@class='actionable actionable_button actionable_icon-only actionable_light button calendar-controls--button calendar-controls--next']"))
					.click();
			cal = driver.findElement(By.xpath("(//div[@class='calendar-month--title'])[1]")).getText();
			System.out.println(cal);
			month = cal.split(" ")[0].trim();
			year = cal.split(" ")[1].trim();
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[@class='calendar-month--days'])[1]//button//span[contains(text(),'26')]")));
		js.executeScript("arguments[0].click();", element);
	}
	
	public void returnDate() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Return date')]")));
		String cal = driver.findElement(By.xpath("(//div[@class='calendar-month--title'])[2]")).getText();
		System.out.println(cal);
		String month = cal.split(" ")[0].trim();
		String year = cal.split(" ")[1].trim();
		while (!(month.equals("March") && year.equals("2023"))) {
			driver.findElement(By.xpath(
					"//button[@class='actionable actionable_button actionable_icon-only actionable_light button calendar-controls--button calendar-controls--next']"))
					.click();
			cal = driver.findElement(By.xpath("(//div[@class='calendar-month--title'])[2]")).getText();
			System.out.println(cal);
			month = cal.split(" ")[0].trim();
			year = cal.split(" ")[1].trim();
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[@class='calendar-month--days'])[2]//button//span[contains(text(),'26')]")));
		js.executeScript("arguments[0].click();", element);
	}
	
	public void pressBtn() {
		driver.findElement(By.id("LandingAirBookingSearchForm_submit-button")).click();
	}
}
