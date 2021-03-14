package week2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLeads extends BaseClass{

	@BeforeTest
	public void setFileName() {
		excelFN = "EditLead";
	}
	
	@Test(dataProvider = "FetchData")
	public void runEditLeads(String company) throws Exception {

		driver.findElement(By.linkText("Find Leads")).click();// Find Leads
		
		String firstName = driver.findElement(By.xpath("//div[@class='x-grid3-body']//tr[1]/td[contains(@class,'td-firstName')]//a")).getText();
		driver.findElement(By.xpath("//div[@class='x-tab-panel']//input[@name='firstName']")).sendKeys(firstName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		String linkValue = driver.findElement(By.xpath("//div[@class='x-grid3-body']//tr[1]/td[1]")).getText();
		driver.findElement(By.linkText(linkValue)).click();
		
		System.out.println("The Title of the page is:" + driver.getTitle());
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(company);
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		String companyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();

		if (companyName.contains(company)) {
			System.out.println("Company name is changed and it is appeared as expected:" + companyName);
		}


	}

}
