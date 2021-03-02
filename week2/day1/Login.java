package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	public static void main(String[] args) {
		
		//Chrome:		
		//Step 1: Ask webDriverManager to assist to download chromeDriver
		WebDriverManager.chromedriver().setup();		
		//Step 2 - Launch the chrome browser
		ChromeDriver driver = new ChromeDriver(); 		
		//Step 3 - Load the URL
		driver.get("http://leaftaps.com/opentaps/control/main");		
		//Step 4 - Maximize the browser
		driver.manage().window().maximize();		
		//Step 5 - get the Title and print it
		String title = driver.getTitle();
		System.out.println("Chrome browser:" + title);		
		//Step 6 - Enter Username (id="username")
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");	
		//Step 7 - Enter password (id="password")
		driver.findElement(By.id("password")).sendKeys("crmsfa");		
		//Step 8 - click login(class="decorativeSubmit")
		driver.findElement(By.className("decorativeSubmit")).click();		
		//Step 9 - click CRM/SFA link(a=CRM/SFA)
		driver.findElement(By.linkText("CRM/SFA")).click();		
		//Step 10 - click createLead link (a=Create Lead)
		driver.findElement(By.linkText("Create Lead")).click();		
		//Step 11 - Type my company name (id=createLeadForm_companyName)
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("SembCorp Marine");		
		//Step 12 - Type my first name (id=createLeadForm_firstName)
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Srividya");
		//Step 13 - Type my last name (id=createLeadForm_lastName)
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Ravichandran");
		//Step 14 - Click create lead button (name=submitButton)
		driver.findElement(By.name("submitButton")).click();
		//Step 15 - print the current page title
		String secondTitle = driver.getTitle();
		System.out.println("Second Title: " + secondTitle);		
		
//		
//		//Firefox
//		WebDriverManager.firefoxdriver().setup();
//		FirefoxDriver fireDriver = new FirefoxDriver();
//		fireDriver.get("http://leaftaps.com/opentaps/control/main");
//		fireDriver.manage().window().maximize();
//		String titleFireFox = fireDriver.getTitle();
//		System.out.println("Firefox browser:" + titleFireFox);
		
		//IE
//		WebDriverManager.edgedriver().setup();
//		EdgeDriver edgeDriver = new EdgeDriver();
//		edgeDriver.get("http://leaftaps.com/opentaps/control/main");
//		edgeDriver.manage().window().maximize();
//		String titleEdge = edgeDriver.getTitle();
//		System.out.println("Edge browser:" + titleEdge);

	}

}
