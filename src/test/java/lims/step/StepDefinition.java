package lims.step;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition {
	WebDriver driver;
	@Given("user is on the lims login page")
	public void user_is_on_the_lims_login_page() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://130.78.62.52:107/#/Login?IPADDRESS=192.168.1.100&MACHINE=DHHCLBX5PFB3");
	}

	@When("user enter valid {string}and{string}")
	public void user_enter_valid_and(String string, String string2) {
		WebElement txtUsername = driver.findElement(By.id("txtUsername"));
		txtUsername.sendKeys("VM");
		WebElement txtPassword = driver.findElement(By.id("txtPassword"));
	txtPassword.sendKeys("Pas123");
	}

	@When("user click the login button")
	public void user_click_the_login_button() {
		WebElement btnLogin = driver.findElement(By.id("btnLogin"));
		btnLogin.click();
	   
	}

	@When("user click the menu")
	public void user_click_the_menu() throws InterruptedException {
		Thread.sleep(30000);
		String homePage = driver.getCurrentUrl();
		assertTrue("Checking whether user on home page",homePage.contains("Mainpage"));
			
		
		WebElement btnMenu = driver.findElement(By.xpath("//i[text()='menu']"));
		btnMenu.click();
	}

	@When("user click the Skeleton Request")
	public void user_click_the_Skeleton_Request() throws InterruptedException {
		Thread.sleep(5000);
		WebElement menuOrderManagement = driver.findElement(By.xpath("//div[text()=' Order management ']"));
		menuOrderManagement.click();
		Thread.sleep(5000);
		WebElement btnSkeletonRequest = driver.findElement(By.xpath("//div[text()=' Skeleton request ']"));
		btnSkeletonRequest.click();
	}

	@When("user click the test")
	public void user_click_the_test() throws InterruptedException {
		Thread.sleep(10000);
		WebElement txtTestSearch = driver.findElement(By.xpath("(//input[@id='txtfavSearch'])[1]"));
		txtTestSearch.sendKeys("qt11");
		Thread.sleep(10000);
		WebElement btnQttest = driver.findElement(By.xpath("(//div[@class='cell vAlign'])[1]"));
		btnQttest.click();
		Thread.sleep(10000);
		WebElement btnCheckBox = driver.findElement(By.xpath("(//span[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin'])[1]"));
		btnCheckBox.click();
		WebElement btnAdd = driver.findElement(By.xpath("(//span[text()='Add'])[3]"));
		btnAdd.click();
	}

	@When("user enter No of sample")
	public void user_enter_No_of_sample() throws InterruptedException {
		Thread.sleep(5000);
		WebElement txtExternal = driver.findElement(By.id("FirstExternal"));
		txtExternal.sendKeys("2");
	}

	@When("user click the save")
	public void user_click_the_save() throws InterruptedException {
		Thread.sleep(5000);
		JavascriptExecutor js =(JavascriptExecutor)driver;
		WebElement btnSave = driver.findElement(By.xpath("//span[text()=' SAVE ']"));
		js.executeScript("arguments[0].click()",btnSave);
	}
}
