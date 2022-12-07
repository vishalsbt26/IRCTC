package com.base;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDate {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

		driver.findElement(By.id("datepicker")).click();

		new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("ui-datepicker-calendar")));
		selectDate("26", "June", "2023");
	}

	public static String[] getYearMonth(String monthYear) {
		return monthYear.split(" ");
	}

	public static void selectDate(String exDate, String exMonth, String exYear) {
		String monthYear = driver.findElement(By.className("ui-datepicker-title")).getText();
		System.out.println(monthYear);

		while (!(getYearMonth(monthYear)[0].equals(exMonth) && getYearMonth(monthYear)[1].equals(exYear))) {
			driver.findElement(By.xpath("//a[@title='Next']")).click();
			monthYear = driver.findElement(By.className("ui-datepicker-title")).getText();
		}
		driver.findElement(By.xpath("//a[text()='" + exDate + "']")).click();
	}
}