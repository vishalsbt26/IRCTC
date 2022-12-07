package com.base;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Qatar {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.qatarairways.com/en-in/homepage.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("cookie-close-accept-all")).click();
		Actions action = new Actions(driver);
		WebElement frm = driver.findElement(By.id("bw-from"));
		frm.sendKeys("Mumbai");
		action.sendKeys(frm, Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
		
		WebElement to = driver.findElement(By.id("bw-to"));
		to.sendKeys("Hyderabad");
		action.sendKeys(to, Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
		
		driver.findElement(By.id("tripType")).click();
		
		List<WebElement> tripType = driver.findElements(By.xpath("//body/div[8]/main[1]/div[1]/div[1]/div[1]/hero-component[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[3]/div[1]/div[1]/ul[1]/li"));
		for (int i = 0; i < tripType.size(); i++) {
		 	String type = tripType.get(i).getText();
		 	
		 	if(type.equals("One way")) {
		 		tripType.get(i).click();
		 	}
		}
	}
}
