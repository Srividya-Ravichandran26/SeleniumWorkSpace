package week4.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JustDial {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable--notifications");

		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://www.justdial.com/Chennai/Car-Repair-Services-Hyundai-Xcent-in-Porur/nct-11293522");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// Scrolling till last page and let it load for 10secs to get current page all
		// data
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(10000);

		driver.findElement(By.xpath("(//*[contains(@onclick,'closePopUp')])[4]")).click();// closing pop up

		List<WebElement> totalDetailCount = driver
				.findElements(By.xpath("//div[@class=' col-sm-5 col-xs-8 store-details sp-detail paddingR0']"));
		System.out.println(totalDetailCount.size());
		
		List<String> serviceName = new ArrayList<String>();
		List<String> ratingNo = new ArrayList<String>();
		List<String> voteNo = new ArrayList<String>();
		List<String> phoneNo = new ArrayList<String>();

		for (int i = 1; i <= totalDetailCount.size(); i++) {
			serviceName.add(driver
					.findElement(By.xpath("(//div[@class=' col-sm-5 col-xs-8 store-details sp-detail paddingR0'])[" + i
							+ "]//span[@class='lng_cont_name']"))
					.getText());

			List<WebElement> ratingElements = driver
					.findElements(By.xpath("(//div[@class=' col-sm-5 col-xs-8 store-details sp-detail paddingR0'])[" + i
							+ "]//span[@class='green-box']"));
			if (ratingElements.size() == 0) {
				ratingNo.add("0.0");
			} else {
				ratingNo.add(driver
						.findElement(By.xpath("(//div[@class=' col-sm-5 col-xs-8 store-details sp-detail paddingR0'])["
								+ i + "]//span[@class='green-box']"))
						.getText());
			}

			List<WebElement> votingElements = driver
					.findElements(By.xpath("(//div[@class=' col-sm-5 col-xs-8 store-details sp-detail paddingR0'])[" + i
							+ "]//span[@class='rt_count lng_vote']"));
			if (votingElements.size() == 0) {
				voteNo.add("0");
			} else {
				voteNo.add(driver
				.findElement(
						By.xpath("((//div[@class=' col-sm-5 col-xs-8 store-details sp-detail paddingR0'])["
								+ i + "]//span[@class='rt_count lng_vote'])[2]"))
				.getText().replaceAll("\\D", ""));
			}

			List<WebElement> phoneNoElements = driver
					.findElements(By.xpath("(//div[@class=' col-sm-5 col-xs-8 store-details sp-detail paddingR0'])[" + i
							+ "]//p[@class='contact-info ']/span"));
			if (phoneNoElements.size() == 0) {
				phoneNo.add("NoNumber");
			} else {
				String mergingLetter = "";
				// To get the phonenumber - creating For one particular phoneNo by getting size
				List<WebElement> eachPhoneNoSize = driver
						.findElements(By.xpath("(//div[@class=' col-sm-5 col-xs-8 store-details sp-detail paddingR0'])["
								+ i + "]//p[@class='contact-info ']/span//span"));
				for (int j = 1; j <= eachPhoneNoSize.size(); j++) {
					// To get the class of every digit phone number and replace the class name to
					// letter
					String classPhoneNo = driver
							.findElement(
									By.xpath("(//div[@class=' col-sm-5 col-xs-8 store-details sp-detail paddingR0'])["
											+ i + "]//p[@class='contact-info ']/span//span[" + j + "]"))
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
				phoneNo.add(mergingLetter);
			}
		}

		System.out.println("Name Size: " + serviceName.size() + " Rating Size: " + ratingNo.size() + " Voting Size: "
				+ voteNo.size() + " PhoneNo size: " + phoneNo.size());
		
		Map<String, Integer> storeNameVote = new HashMap<String, Integer>();
		List<String> finalVotingName = new ArrayList<String>();

		for (int j = 0; j < serviceName.size(); j++) {
			storeNameVote.put(serviceName.get(j), Integer.parseInt(voteNo.get(j)));
		}

		// Adding the final result of >=50 names to list
		for (Entry<String, Integer> eachNameVote : storeNameVote.entrySet()) {
			if (eachNameVote.getValue() >= 50) {
				finalVotingName.add(eachNameVote.getKey());
			}
		}

//		System.out.println("Voting >=50");
//		for (String eachVote : finalVotingName) {
//			System.out.println(eachVote);
//		}
		// Create Map - Key as Service provide name and rating as value
		Map<String, Float> storeNameRating = new HashMap<String, Float>();
		List<String> finalRatingName = new ArrayList<String>();

		for (int j = 0; j < serviceName.size(); j++) {
			storeNameRating.put(serviceName.get(j), Float.parseFloat(ratingNo.get(j)));
		}

		// Adding the final result of >=4.5 names to list
		for (Entry<String, Float> eachNameRating : storeNameRating.entrySet()) {
			if (eachNameRating.getValue() >= (4.5f)) {
				finalRatingName.add(eachNameRating.getKey());
			}
		}
		
//		System.out.println("Rating >=4.5");
//		for (String eachRate : finalRatingName) {
//			System.out.println(eachRate);
//		}

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

					for (int k = 0; k < serviceName.size(); k++) {
						storeNamePhoneNo.put(serviceName.get(k), phoneNo.get(k));
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
