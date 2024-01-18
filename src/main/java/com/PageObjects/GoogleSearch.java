package com.PageObjects;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ReadDataFromExcel;

public class GoogleSearch{
	
	WebDriver driver;
	
	@FindBy(name = "q")
	WebElement searchTextBox;
	
	@FindBy(xpath="//div[@data-attrid='title']")
	WebElement readSearchTitle;
	
	ArrayList<String> data;
	
	
	public GoogleSearch(WebDriver driver,String testCaseName) throws IOException {
		
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		data=ReadDataFromExcel.getData(testCaseName);
		
	}
	
	public void searchKeyword(String keyword)
	{
		searchTextBox.sendKeys(data.get(1).toString());
		searchTextBox.sendKeys(Keys.ENTER);
	}
	
	public String getSearchTitle()
	{
		return readSearchTitle.getText();
	}
}
