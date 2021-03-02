package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AcmeTest {

	public static void main(String[] args) {
//		1. Load url "https://acme-test.uipath.com/login"
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://acme-test.uipath.com/login");
		driver.manage().window().maximize();
//		2. Enter email as "kumar.testleaf@gmail.com" (id=email)
		driver.findElement(By.id("email")).sendKeys("kumar.testleaf@gmail.com");
//		3. Enter Password as "leaf@12" (id=password)
		driver.findElement(By.id("password")).sendKeys("leaf@12");		
//		4. Click login button
		driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/form/button")).click();
//		5. Get the title of the page and print
		System.out.println("The Title of the page is: " + driver.getTitle());
//		6. Click on Log Out
		driver.findElement(By.linkText("Log Out")).click();
//		7. Close the browser
		driver.close();

	}

}
