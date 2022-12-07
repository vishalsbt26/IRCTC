package com.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.AirFrance;
import com.base.TestBase;

public class AirFranceTest extends TestBase {
	AirFrance airFrance;
	
	public AirFranceTest() {
		super();
	}
	
	@BeforeTest
	public void setup() {
		initialization();
		airFrance = new AirFrance();
	}
	
	@Test
	public void fearchFlight() {
		airFrance.location();
	}
}
