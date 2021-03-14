package week2.day1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import week2.assignment.BaseClass;
import week5.day2.ReadExcel;

public class CreateLead extends BaseClass{

	@BeforeTest
	public void setFileName() {
		excelFN = "createLead";
	}
//	@Test(invocationCount=3)
	@Test(dataProvider = "FetchData")
	public void runCreateLead(String companyName, String FirstName, String LastName) {
		driver.findElement(By.linkText("Create Lead")).click(); // create lead menu link
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName); // company name
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(FirstName); // first name
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(LastName);// last name

		WebElement source = driver.findElement(By.id("createLeadForm_dataSourceId"));// locate source dropdown
		Select sourceDropdown = new Select(source); // create obj
		sourceDropdown.selectByVisibleText("Employee"); // select employee option for source dropdown

		WebElement marketingCamp = driver.findElement(By.id("createLeadForm_marketingCampaignId"));// locate marketingCamp dropdown
		Select marketingCampDropdown = new Select(marketingCamp);// create obj
		marketingCampDropdown.selectByValue("9001");// select Pay Per Click Advertising option for marketingCamp dropdown

		WebElement ownership = driver.findElement(By.id("createLeadForm_ownershipEnumId"));// locate ownership dropdown
		Select ownershipDropdown = new Select(ownership);// create obj
		ownershipDropdown.selectByIndex(5);// select Pay Per Click corporation option for ownership dropdown

		WebElement country = driver.findElement(By.id("createLeadForm_generalCountryGeoId"));// locate country dropdown
		Select countryDropdown = new Select(country); // create obj
		countryDropdown.selectByVisibleText("India"); // select India option for country dropdown

		driver.findElement(By.name("submitButton")).click();// click create lead button
		String secondTitle = driver.getTitle(); // get title
		if (secondTitle.contains("View Lead"))
			System.out.println("Title is displayed as expected: " + secondTitle);
		else
			System.out.println("Expected Title is not displayed and appeared is:" + secondTitle);
	}

}
