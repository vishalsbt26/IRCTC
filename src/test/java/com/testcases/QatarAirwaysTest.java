package com.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.QatarAirways;
import com.base.TestBase;

public class QatarAirwaysTest extends TestBase {
	QatarAirways qatar;
	
	public QatarAirwaysTest() {
		super();
	}
	
	@BeforeTest
	public void setup() {
		initialization();
		qatar = new QatarAirways();
	}
	
	@Test
	public void searchFlight() throws InterruptedException {
		qatar.fromLocation();
		qatar.toLocation();
//		qatar.departDate();
		qatar.tripType();
	}
}
