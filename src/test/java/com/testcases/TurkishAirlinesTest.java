package com.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.TurkishAirlines;
import com.base.TestBase;

public class TurkishAirlinesTest extends TestBase {
	TurkishAirlines turkishAirlines;
	
	public TurkishAirlinesTest() {
		super();
	}
	
	@BeforeTest
	public void setup() {
		initialization();
		turkishAirlines = new TurkishAirlines();
	}
	
	@Test
	public void location() {
		turkishAirlines.location();
	}
}
