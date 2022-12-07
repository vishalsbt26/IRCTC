package com.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.SouthWest;
import com.base.TestBase;

public class SouthWestTest extends TestBase {
	SouthWest southWest;
	
	public SouthWestTest() {
		super();
	}
	
	@BeforeTest
	public void setup() {
		initialization();
		southWest = new SouthWest();
	}
	
	@Test
	public void searchFlight() {
		southWest.location();
		southWest.departDate();
		southWest.returnDate();
		southWest.pressBtn();
	}
}
