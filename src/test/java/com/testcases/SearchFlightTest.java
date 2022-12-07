package com.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.SearchFlight;
import com.base.TestBase;

public class SearchFlightTest extends TestBase {
	SearchFlight searchFlight;

	public SearchFlightTest() {
		super();
	}

	@BeforeTest
	public void setup() {
		initialization();
		searchFlight = new SearchFlight();
	}

	@Test(priority = 1)
	public void search() {
		searchFlight.acceptAlerts();
	}

	@Test(priority = 2)
	public void searchFlight() throws InterruptedException {
		searchFlight.location();
		searchFlight.date("January2023", "26");
		searchFlight.checkbox();
		searchFlight.pressBtn();
		searchFlight.trainCount();
	}
}
