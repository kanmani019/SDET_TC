package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import common.Wrapper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CreateCourse_Stepdefinition {
	
	static WebDriver driver;
	String url = "http://elearningm1.upskills.in/";
	
	@Given("^I launch the application$")
	public void i_launch_the_application() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get(url);
	    
	}

	@Then("^I enter my username and password$")
	public void i_enter_my_username_and_password() throws Throwable {
		driver.findElement(By.id("login")).sendKeys(Wrapper.getDataFromExcel(1,0));
		driver.findElement(By.id("password")).sendKeys(Wrapper.getDataFromExcel(1,1));
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
	    
	}

	@Then("^I click the create a course link$")
	public void i_click_the_create_a_course_link() throws Throwable {
		
		driver.findElement(By.xpath("//a [contains(text(),'Create a course')]")).click();
	    
	}

	@Then("^Enter valid credential in Title textbox$")
	public void enter_valid_credential_in_Title_textbox() throws Throwable {
		driver.findElement(By.id("update_course_title")).sendKeys("testing");
	   
	}

	@Then("^Enter valid credential in  code textbox$")
	public void enter_valid_credential_in_code_textbox() throws Throwable {
		driver.findElement(By.id("visual_code")).sendKeys("tes");
	    
	}

	

	@Then("^Select Valid credentials from Category list box$")
	public void select_Valid_credentials_from_Category_list_box() throws Throwable {
		Actions act = new Actions(driver);
		driver.findElement(By.xpath("//div[@class=\"filter-option-inner-inner\"]")).click();
		WebElement Category = driver.findElement(By.xpath("//input[@aria-label=\"Search\"]"));
		Category.sendKeys("Projects");
		act.sendKeys(Keys.ENTER).build().perform();
		
		
	    
	}
	
	@Then("^Select Valid credentials in Teacher list box$")
	public void select_Valid_credentials_in_Teacher_list_box() throws Throwable {
		Actions act = new Actions(driver);
		//driver.findElement(By.xpath("//input[@type=\"search\"]")).sendKeys("manzoor");
		 //Select sel = new Select(driver.findElement(By.xpath("//input[@type=\"search\"]")));
		 //Thread.sleep(6000);
		 //sel.getFirstSelectedOption();
		WebElement Teacher = driver.findElement(By.xpath("//input[@type=\"search\"]"));
		Teacher.sendKeys("manzoor");
		Thread.sleep(6000);
		act.sendKeys(Keys.ENTER).build().perform();
			    
	}
	


	@And("^Click on Create a course button$")
	public void click_on_Create_a_course_button() throws Throwable {
		driver.findElement(By.xpath("//button[@name=\"submit\"]")).click();
	   
	}
	
	@Then("^I click the create a class link$")
	public void i_click_the_create_a_class_link() throws Throwable {
	    driver.findElement(By.partialLinkText("Classes")).click();
	}

	@Then("^I click on Add classes icon$")
	public void i_click_on_Add_classes_icon() throws Throwable {
	    driver.findElement(By.xpath("//img[@alt=\"Add classes\"]")).click();
	}

	@Then("^Enter valid credentials in Name textbox$")
	public void enter_valid_credentials_in_Name_textbox() throws Throwable {
		driver.findElement(By.id("usergroup_name")).sendKeys("demo");
	}

	@Then("^Enter valid credentials in Description textbox$")
	public void enter_valid_credentials_in_Description_textbox() throws Throwable {
		driver.findElement(By.name("description")).sendKeys("demo");
	}

	@Then("^Select valid credentials in Group permissions list box$")
	public void select_valid_credentials_in_Group_permissions_list_box() throws Throwable {
		Actions act = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class=\"filter-option-inner-inner\"]")).click();
	    driver.findElement(By.xpath("//input[@role=\"textbox\"]")).sendKeys("open");
	    act.sendKeys(Keys.ENTER).build().perform();
	}

	@And("^Click on Add button$")
	public void click_on_Add_button() throws Throwable {
	    driver.findElement(By.name("submit")).click();
	}



}
