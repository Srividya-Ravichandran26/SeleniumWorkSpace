package week2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import week5.day2.ReadExcel;

public class BaseClass {

	public ChromeDriver driver;
	public String excelFN;
	
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void preCoditions(String url, String username, String password) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys(username); // username
		driver.findElement(By.id("password")).sendKeys(password);// password
		driver.findElement(By.className("decorativeSubmit")).click();// login
		driver.findElement(By.linkText("CRM/SFA")).click(); // CRM/SFA Link
		driver.findElementByLinkText("Leads").click();
	}
	
	@AfterMethod
	public void postConditions() {
		driver.close();
	}
	
	@DataProvider(name="FetchData")
	public String[][] sendData() throws Exception{
		ReadExcel re = new ReadExcel();
		String[][] data = re.excelRead(excelFN);
		return data;
		
	}
}
