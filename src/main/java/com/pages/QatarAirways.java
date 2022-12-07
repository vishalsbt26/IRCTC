package com.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.base.TestBase;
import io.reactivex.rxjava3.functions.Action;

public class QatarAirways extends TestBase {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	Actions action = new Actions(driver);

	@FindBy(id = "bw-from")
	WebElement fromLoc;

	@FindBy(id = "bw-to")
	WebElement toLoc;

	@FindBy(id = "tripType")
	WebElement type;

	public QatarAirways() {
		PageFactory.initElements(driver, this);
	}

	public void fromLocation() {
		driver.findElement(By.id("cookie-close-accept-all")).click();
		WebElement fLoc = driver.findElement(By.id("bw-from"));
		fLoc.sendKeys("Dubai");

		wait.until(ExpectedConditions
				.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='tt-dataset tt-dataset-location']/div")));

		List<WebElement> locations = driver
				.findElements(By.xpath("//div[@class='tt-dataset tt-dataset-location']/div"));
		for (int i = 0; i < locations.size(); i++) {
			String text = locations.get(i).getText();

			if (text.contains("Sharjah")) {
				locations.get(i).click();
			}

		}
	}

	public void toLocation() {
		WebElement tLoc = driver.findElement(By.id("bw-to"));
		tLoc.sendKeys("India");
//		Actions action = new Actions(driver);
//		action.keyDown(fLoc, Keys.DOWN).keyDown(Keys.DOWN).keyDown(Keys.DOWN).keyDown(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();

		wait.until(ExpectedConditions
				.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='tt-dataset tt-dataset-location']/div")));

		List<WebElement> locations = driver
				.findElements(By.xpath("//div[@class='tt-dataset tt-dataset-location']/div"));
		for (int i = 0; i < locations.size(); i++) {
			String text = locations.get(i).getText();

			if (text.contains("Mumbai")) {
				locations.get(i).click();
			}

		}
	}

	public void tripType() throws InterruptedException {
		Thread.sleep(5000);
		Actions action = new Actions(driver);

		action.click(driver.findElement(By.id("tripType"))).build().perform();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<WebElement> list = driver.findElements(By.xpath("//a[@role='option']"));
		System.out.println(list);

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().contains("Multi-city")) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", list.get(i));
			}
		}
	}
}