package com.atmecs.toolsqa.utils;

import org.testng.Assert;
import org.testng.Reporter;

public class VerifyResult {


	public boolean verifyBoolean(boolean actual, boolean expected, String message) {
		try {
			Assert.assertEquals(actual, expected);
			//report.info("PASS : " + message + ": " + "ACTUAL : " + actual + " 	" + "EXPECTED :" + expected);
			System.out.println("PASS : " + message + ": " + "ACTUAL : " + actual + " 	" + "EXPECTED :" + expected);
			Reporter.log("PASS : " + message + ": " + "ACTUAL : " + actual + " 	" + "EXPECTED :" + expected);
			return true;
		} catch (AssertionError assertionError) {
			Reporter.log("FAIL : " + assertionError.getMessage() + ": " + "ACTUAL : " + actual + " 	" + "EXPECTED :"
					+ expected);
			return false;
		}
	}

	public boolean verifyTrue(boolean condition, String message) {
		boolean result = true;
		try {
			Assert.assertTrue(condition);
			Reporter.log("PASS : " + message);
			result = true;
		} catch (AssertionError assertionError) {
			Reporter.log("FAIL : " + assertionError.getMessage());
			result = false;
		}
		
		return result;

	}
	
	public boolean verifyTrueAndStopTest(boolean condition, String message) {
		boolean result = true;

		try {
			Assert.assertTrue(condition);
			Reporter.log("PASS : " + message);
			result = true;
		} catch (AssertionError assertionError) {
			Reporter.log("FAIL : " + assertionError.getMessage());
			Assert.fail(message);
			result = false;
		}
		return result;
	}



}
