package stepsdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	WebDriver driver;
	@Given("Chrome browser is opened")
	public void chrome_browser_is_opened() {
		driver=new ChromeDriver();
	   
	}
	@When("Go to URL {string}")
	public void go_to_url(String string) {
		driver.get("https://the-internet.herokuapp.com/");
	    
	}
	@Then("User should be on {string}")
	public void user_should_be_on(String string) {
		String titleText=driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals(titleText, "Welcome to the-internet");
	   
	}
	@When("User clicks on {string}")
	public void user_clicks_on(String string) {
		driver.findElement(By.xpath("//li/a[contains(text(),'Form Authentication')]")).click();
		
		
	    
	}
	@Then("User should land on login page")
	public void user_should_land_on_login_page() {
	    String loginPageText=driver.findElement(By.tagName("h2")).getText();
	    Assert.assertEquals(loginPageText, "Login Page");
	}
	@When("User enters Username {string}")
	public void user_enters_username(String string) {
		
	   driver.findElement(By.id("username")).sendKeys("tomsmith ");
	}
	@When("User enters Password {string}")
	public void user_enters_password(String string) {
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
	   
	}
	@When("clicks on Login button")
	public void clicks_on_login_button() {
		driver.findElement(By.className("radius")).click();
	    
	}
	@Then("User should be logged in successfully")
	public void user_should_be_logged_in_successfully() {
	    String secureText=driver.findElement(By.tagName("h2")).getText();
	    Assert.assertEquals(secureText, " Secure Area");
	}

}
