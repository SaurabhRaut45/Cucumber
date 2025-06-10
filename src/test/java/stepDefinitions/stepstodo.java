package stepDefinitions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepstodo {

	WebDriver driver;
	
	public String productname;

	@Given("User is on greenkart landing page")
	public void user_is_on_greenkart_landing_page() {
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

	}

	@When("User searched with shortname {string} and extarcted actual name of the product")
	public void user_searched_with_shortname_and_extarcted_actual_name_of_the_product(String shortname) throws InterruptedException {

		driver.findElement(By.cssSelector("input[type='search']")).sendKeys(shortname);
		
		Thread.sleep(2500);

		productname = driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();

		System.out.println(productname + " Product name on home page is");

	}

	@Then("User searched with same shortname {string} in offerspage to see if the product exists")
	public void user_searched_with_same_shortname_in_offerspage_to_see_if_the_product_exists(String shortname) throws InterruptedException {

		driver.findElement(By.linkText("Top Deals")).click();
		Set<String> windows = driver.getWindowHandles();

		Iterator<String> it = windows.iterator();

		String parentwindow = it.next();
		String childwindow = it.next();
		
		driver.switchTo().window(childwindow);
		
		driver.findElement(By.id("search-field")).sendKeys(shortname);
		
		Thread.sleep(2500);
		
		String actualname= driver.findElement(By.xpath("//tr/td[1]")).getText();
		
		System.out.println("Actual name is "+ actualname);
		
		Assert.assertEquals(productname, actualname);
		

	}

}
