package com.base;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testAir {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.qatarairways.com/en-in/homepage.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Actions action = new Actions(driver);
		driver.findElement(By.id("cookie-close-accept-all")).click();
		WebElement from = driver.findElement(By.id("bw-from"));
		from.sendKeys("Mumbai");
		action.sendKeys(from, Keys.DOWN).sendKeys(Keys.ENTER).build().perform();

		WebElement to = driver.findElement(By.id("bw-to"));
		to.sendKeys("Dubai");
		action.sendKeys(to, Keys.DOWN).sendKeys(Keys.ENTER).build().perform();

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