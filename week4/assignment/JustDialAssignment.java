package week4.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JustDialAssignment {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable--notifications");

		ChromeDriver driver = new ChromeDriver(options);
//		driver.get("https://www.justdial.com/");
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//
//		driver.findElement(By.xpath("//div[@class='search-city mnsrchwpr']")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//a[text()='Chennai']")).click();
//
//		driver.findElement(By.xpath("//span[text()='Auto care']")).click();
//		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//span[@title='Car Repair']")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//span[@title='Hyundai']")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//span[@title='Hyundai Xcent']")).click();
//		
//		driver.findElement(By.xpath("//span[@title='All Options']")).click();
//		
//		driver.findElement(By.id("srchbx")).click();
//		driver.findElement(By.id("insrch")).sendKeys("Porur", Keys.ARROW_DOWN, Keys.ENTER);
//		
//		driver.findElement(By.id("distance")).click();
//		driver.findElement(By.xpath("//span[@class='drpwn']/*[text()='1 km']")).click();

		driver.get("https://www.justdial.com/Chennai/Car-Repair-Services-Hyundai-Xcent-in-Porur/nct-11293522");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.findElement(By.id("distance")).click();
		driver.findElement(By.id("distance")).click();

		// Scrolling till last page and let it load for 10secs to get current page all
		// data
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(10000);

		// The count of Rating
		List<WebElement> allRating = driver.findElements(By.className("green-box"));

		// The count of Votes
		List<WebElement> allVotes = driver.findElements(By.xpath("//span[contains(@class,'lng_vote')]"));
		// Getting the votes text and removing the empty rows and assign it to list
		List<String> allVotesList = new ArrayList<String>();
		for (int i = 0; i < allVotes.size(); i++) {
			if (i % 2 != 0) {
				allVotesList.add(allVotes.get(i).getText().replaceAll("\\D", ""));
			}
		}

		// The count of Service Provider Name
		List<WebElement> allServiceProvider = driver.findElements(By.className("lng_cont_name"));

		// The count of phone number
		List<WebElement> allPhoneNo = driver.findElements(By.xpath("//p[@class='contact-info ']/span"));

		// Assign the phone number to finalPhoneNo list
		List<String> finalPhoneNo = new ArrayList<String>();

		// To get the phone number - creating For all phoneNo
		for (int i = 1; i <= allPhoneNo.size(); i++) {
			String mergingLetter = "";

			// To get the phonenumber - creating For one particular phoneNo by getting size
			List<WebElement> eachPhoneNoSize = driver
					.findElements(By.xpath("(//p[@class='contact-info ']/span)[" + i + "]//span"));
			for (int j = 1; j <= eachPhoneNoSize.size(); j++) {

				// To get the class of every digit phone number and replace the class name to
				// letter
				String classPhoneNo = driver
						.findElement(By.xpath("(//p[@class='contact-info ']/span)[" + i + "]//span[" + j + "]"))
						.getAttribute("class");
				String replacedPhoneNo = classPhoneNo.replaceAll("mobilesv icon-", "");
				switch (replacedPhoneNo) {
				case "dc":
					mergingLetter = mergingLetter + replacedPhoneNo.replaceAll(replacedPhoneNo, "+");
					break;
				case "fe":
					mergingLetter = mergingLetter + replacedPhoneNo.replaceAll(replacedPhoneNo, "(");
					break;
				case "hg":
					mergingLetter = mergingLetter + replacedPhoneNo.replaceAll(replacedPhoneNo, ")");
					break;
				case "ba":
					mergingLetter = mergingLetter + replacedPhoneNo.replaceAll(replacedPhoneNo, "-");
					break;
				case "acb":
					mergingLetter = mergingLetter + replacedPhoneNo.replaceAll(replacedPhoneNo, "0");
					break;
				case "yz":
					mergingLetter = mergingLetter + replacedPhoneNo.replaceAll(replacedPhoneNo, "1");
					break;
				case "wx":
					mergingLetter = mergingLetter + replacedPhoneNo.replaceAll(replacedPhoneNo, "2");
					break;
				case "vu":
					mergingLetter = mergingLetter + replacedPhoneNo.replaceAll(replacedPhoneNo, "3");
					break;
				case "ts":
					mergingLetter = mergingLetter + replacedPhoneNo.replaceAll(replacedPhoneNo, "4");
					break;
				case "rq":
					mergingLetter = mergingLetter + replacedPhoneNo.replaceAll(replacedPhoneNo, "5");
					break;
				case "po":
					mergingLetter = mergingLetter + replacedPhoneNo.replaceAll(replacedPhoneNo, "6");
					break;
				case "nm":
					mergingLetter = mergingLetter + replacedPhoneNo.replaceAll(replacedPhoneNo, "7");
					break;
				case "lk":
					mergingLetter = mergingLetter + replacedPhoneNo.replaceAll(replacedPhoneNo, "8");
					break;
				case "ji":
					mergingLetter = mergingLetter + replacedPhoneNo.replaceAll(replacedPhoneNo, "9");
					break;
				}

			}
			// Assigning the final mergered phone number to List
			finalPhoneNo.add(mergingLetter);
		}

		// Create Map - Key as Service provide name and Vote as value
		Map<String, Integer> storeNameVote = new HashMap<String, Integer>();
		List<String> finalVotingName = new ArrayList<String>();

		for (int j = 0; j < allServiceProvider.size(); j++) {
			storeNameVote.put(allServiceProvider.get(j).getText(), Integer.parseInt(allVotesList.get(j)));
		}

		// Adding the final result of >=50 names to list
		for (Entry<String, Integer> eachNameVote : storeNameVote.entrySet()) {
			if (eachNameVote.getValue() >= 50) {
				finalVotingName.add(eachNameVote.getKey());
			}
		}

		// Create Map - Key as Service provide name and rating as value
		Map<String, Float> storeNameRating = new HashMap<String, Float>();
		List<String> finalRatingName = new ArrayList<String>();

		for (int j = 0; j < allRating.size(); j++) {
			storeNameRating.put(allServiceProvider.get(j).getText(), Float.parseFloat(allRating.get(j).getText()));
		}

		// Adding the final result of >=4.5 names to list
		for (Entry<String, Float> eachNameRating : storeNameRating.entrySet()) {
			if (eachNameRating.getValue() >= 4.5) {
				finalRatingName.add(eachNameRating.getKey());
			}
		}

		// Merging both rating and voting final result of service provider name in one
		// list and displaying only duplicate values

		List<String> merge = new ArrayList<String>(finalVotingName);
		merge.addAll(finalRatingName);

		System.out.println("Getting vote >=50 and rating >= 4.5 - Service provider names");

		for (int i = 0; i < merge.size(); i++) {
			for (int j = i + 1; j < merge.size(); j++) {
				if (merge.get(i).equalsIgnoreCase(merge.get(j))) {
					// Create Map - Key as Service provide name and PhoneNo as value
					Map<String, String> storeNamePhoneNo = new HashMap<String, String>();

					for (int k = 0; k < finalPhoneNo.size(); k++) {
						storeNamePhoneNo.put(allServiceProvider.get(k).getText(), finalPhoneNo.get(k));
					}

					// Adding the final result of >=4.5 names to list
					for (Entry<String, String> eachNamePhone : storeNamePhoneNo.entrySet()) {
						if (eachNamePhone.getKey().equalsIgnoreCase(merge.get(j))) {
							System.out.println(eachNamePhone);
						}
					}
				}
			}

		}

	}

}
