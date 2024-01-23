package com.TestSelenium;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.PageObjects.GoogleSearch;
import com.PageObjects.YahooSearch;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utilities.BaseDriver;

public class Test_Google extends BaseDriver{
	
	WebDriver driver;
	GoogleSearch googleSearch; 
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	YahooSearch yahooSearch;
	
	@BeforeTest
    public void startReport() {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testReport.html");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);


        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Simple Automation Report");
        htmlReporter.config().setReportName("Test Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
    }
	
	@BeforeMethod
	void beforeTest(Method method)
	{
		 test = extent.createTest(method.getName());
	}
	
	@Test(description = "Verify search functionality with input keyword")
	void testSearchFunctionality() throws IOException
	{
		driver = initalizeDriver();
		googleSearch = new GoogleSearch(driver,"TC1");
		googleSearch.searchKeyword();
	}
	
	@Test(description = "Verify search functionality and title heading with input keyword")
	void testSearchFunctionalityAndGetTitle() throws IOException
	{
		driver = initalizeDriver();
		googleSearch = new GoogleSearch(driver,"TC2");
		googleSearch.searchKeyword();	
		assertEquals("United States", googleSearch.getSearchTitle());
	}
	
	@Test(description = "Verify search functionality with input keyword")
	void test_SearchFunctionality() throws IOException
	{
		driver = initalizeDriver();
		yahooSearch = new YahooSearch(driver,"TC1");
		yahooSearch.searchKeyword();
	}
	
	@Test(description = "Verify search functionality and title heading with input keyword")
	void test_SearchFunctionalityAndGetTitle() throws IOException
	{
		driver = initalizeDriver();
		yahooSearch = new YahooSearch(driver,"TC2");
		yahooSearch.searchKeyword();	
		assertEquals("United States", yahooSearch.getSearchTitle());
	}

	@AfterMethod
	public void getResult(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL,result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, result.getTestName());
        }
        else {
            test.log(Status.SKIP, result.getTestName());
        }
	        
	    }
	@AfterTest
    public void tearDown() {
        extent.flush();
    }
}
