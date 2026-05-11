package stepsdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	WebDriver driver;
	WebDriverWait wait;

	@Given("Chrome browser is opened")
	public void chrome_browser_is_opened() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		System.out.println("Chrome browser is opened");

	}

	@When("Go to URL {string}")
	public void go_to_url(String string) {
		driver.get("https://the-internet.herokuapp.com/");
		System.out.println("Landed on the Internet herouk page");

	}

	@Then("User should be on {string}")
	public void user_should_be_on(String string) {
		String titleText = driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals(titleText, "Welcome to the-internet");
		System.out.println("Validated that title page is loaded succesfully");

	}

	@When("User clicks on {string}")
	public void user_clicks_on(String string) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/a[contains(text(),'Form Authentication')]")))
				.click();
		System.out.println("Clicked on form authentication");

	}

	@Then("User should land on login page")
	public void user_should_land_on_login_page() {
		String loginPageHeadingText = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h2")))
				.getText();
		System.out.println("The text on login page is ::  " + loginPageHeadingText);
		Assert.assertEquals(loginPageHeadingText, "Login Page");
		System.out.println("Validated that user has successfully landed on the login page");
	}

	@When("User enters Username {string}")
	public void user_enters_username(String string) {

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username"))).sendKeys("tomsmith");
		System.out.println("Sending the username :: tomsmith");
	}

	@When("User enters Password {string}")
	public void user_enters_password(String string) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password"))).sendKeys("SuperSecretPassword!");
		System.out.println("Sending password");

	}

	@When("clicks on Login button")
	public void clicks_on_login_button() {
		wait.until(ExpectedConditions.elementToBeClickable(By.className("radius"))).click();
		System.out.println("Clicked on login button");

	}

	@Then("User should be logged in successfully")
	public void user_should_be_logged_in_successfully() {
		String secureAreaText = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h2"))).getText();

		Assert.assertEquals(secureAreaText, "Secure Area");
		System.out.println("Login succesful, The text on the secure area page is::  " + secureAreaText);

	}

}
