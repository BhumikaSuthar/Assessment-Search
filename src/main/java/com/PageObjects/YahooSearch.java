package com.PageObjects;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ReadDataFromExcel;

public class YahooSearch {
	
	WebDriver driver;
	
	@FindBy(name = "p")
	WebElement searchTextBox;
	
	@FindBy(xpath="//h3/a[@data-matarget='algo']")
	WebElement readSearchTitle;
	
	ArrayList<String> data;
	
	
	public YahooSearch(WebDriver driver,String testCaseName) throws IOException {
		
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		data=ReadDataFromExcel.getData(testCaseName);
		
	}
	
	public void searchKeyword()
	{
		searchTextBox.sendKeys(data.get(1).toString());
		searchTextBox.sendKeys(Keys.ENTER);
	}
	
	public String getSearchTitle()
	{
		return readSearchTitle.getText();
	}

}
