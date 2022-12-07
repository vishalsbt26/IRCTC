package com.pages;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.base.TestBase;

public class SearchFlight extends TestBase {
	Actions action = new Actions(driver);
	// Page Objects
	@FindBy(xpath = "//div[@class='ng-trigger ng-trigger-animation ng-tns-c19-2 ui-dialog ui-widget ui-widget-content ui-corner-all ui-shadow ui-dialog-draggable ui-dialog-resizable ng-star-inserted']")
	WebElement alertBox;

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement alertOk;

	@FindBy(xpath = "//input[@class='ng-tns-c57-8 ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted']")
	WebElement fromTxt;

	@FindBy(xpath = "//input[@class='ng-tns-c57-9 ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted']")
	WebElement toTxt;

	@FindBy(xpath = "//input[@class='ng-tns-c58-10 ui-inputtext ui-widget ui-state-default ui-corner-all ng-star-inserted']")
	WebElement selDate;

	@FindBy(xpath = "//button[text()='Search']")
	WebElement subBtn;

	// initialize page objects
	public SearchFlight() {
		PageFactory.initElements(driver, this);
	}

	public void acceptAlerts() {
		if (alertBox.isDisplayed()) {
			alertOk.click();
		}
	}

	public void location() throws InterruptedException {
		Thread.sleep(2000);
		fromTxt.sendKeys("mum");
		Thread.sleep(2000);
		action.sendKeys(fromTxt, Keys.ARROW_DOWN).keyDown(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

		Thread.sleep(2000);
		toTxt.sendKeys("hyderabad");
		Thread.sleep(2000);
		action.sendKeys(toTxt, Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	}

	public void date(String monYear, String date) {
		selDate.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(
//				By.xpath("//div[@class='ui-datepicker-group ui-widget-content ng-tns-c58-10 ng-star-inserted']")));

		String monthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title ng-tns-c58-10']")).getText();
		System.out.println(monthYear);

		while (!(monthYear.equals(monYear))) {
			driver.findElement(
					By.xpath("//a[@class='ui-datepicker-next ui-corner-all ng-tns-c58-10 ng-star-inserted']")).click();

			monthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title ng-tns-c58-10']")).getText();
			System.out.println(monthYear);
		}
		driver.findElement(By.xpath("//a[text()='" + date + "']")).click();
	}

	public void checkbox() {
		List<WebElement> list = driver.findElements(By.xpath(
				"//body/app-root[1]/app-home[1]/div[3]/div[1]/app-main-page[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-jp-input[1]/div[1]/form[1]/div[4]/div[1]"));
		
		for (int i = 0; i < list.size(); i++) {
			String allText = list.get(i).getText();
			if (allText.equals("Flexible With Date")) {
				list.get(i).click();
			}
			if (allText.equals("Railway Pass Concession")) {
				list.get(i).click();
			}
		}
	}

	public void pressBtn() {
		subBtn.click();
	}
	
	public void trainCount() {
		List<WebElement> list = driver
				.findElements(By.xpath("//div[@class='form-group no-pad col-xs-12 bull-back border-all']"));
		int count = 0;
		boolean b;
		String s = " ";
		for (int i = 0; i < list.size(); i++) {
			b = list.get(i).isDisplayed();

			if (b == true) {
				s = list.get(i).getText();
				if (s != " ") {
					count++;
				}
			}
			System.out.println("Total trains available are " + count);
		}
	}
}
