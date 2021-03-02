package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("demosalesmanager"); // username
		driver.findElement(By.id("password")).sendKeys("crmsfa");// password
		driver.findElement(By.className("decorativeSubmit")).click();// login
		driver.findElement(By.linkText("CRM/SFA")).click(); // CRM/SFA Link
		driver.findElement(By.linkText("Create Lead")).click(); // create lead menu link
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("SembCorp Marine"); // company name
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Srividya"); // first name
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Ravichandran");// last name

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
