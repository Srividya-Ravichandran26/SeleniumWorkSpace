package week2.assignment;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1_HyperLinks {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		
		//Go to Home Page
		driver.findElement(By.linkText("Go to Home Page")).click();
		System.out.println("The URL for the action of (Go to Home Page) is:" + driver.getCurrentUrl());
		driver.navigate().back();
		
		//Find where am supposed to go without clicking me?
		String redirectsLink = driver.findElement(By.linkText("Find where am supposed to go without clicking me?")).getAttribute("href");		
		System.out.println("The URL redirects to:" + redirectsLink);
		
		//Verify am I broken
		String brokenUrl = driver.findElement(By.linkText("Verify am I broken?")).getAttribute("href");	
		
		HttpURLConnection connection = (HttpURLConnection)new URL(brokenUrl).openConnection();
		connection.setRequestMethod("HEAD");
		connection.connect();
		
		int respCode = connection.getResponseCode();
		if(respCode >= 400){
            System.out.println(brokenUrl+" is a broken link");
        }
        else{
            System.out.println(brokenUrl+" is a valid link");
        }
		connection.disconnect();
		
		//Go To Homepage(Interact with same link name)
		driver.findElement(By.xpath("//label[text()='(Interact with same link name)']/preceding-sibling::a")).click();
		System.out.println("The URL for the action of (Go to Home Page(Interact with same link name)) is:" + driver.getCurrentUrl());
		driver.navigate().back();
		
		//How many links are available in this page?
		List<WebElement> links = driver.findElements(By.tagName("a"));		
		System.out.println("How many links are available in this page? --->" + links.size() );

	}

}
