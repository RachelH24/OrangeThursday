package com.qA.selenium.Orange;


import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrangeTest {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	
	
	

	@Before
	public void setUp() throws InterruptedException {
	
	

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\JAVA EE\\web drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		report = new ExtentReports("C:\\Users\\Admin\\Documents\\Assessment\\Reports.html");
		test = report.startTest("StartingTest");
		Thread.sleep(1000);
		driver.get("http://opensource.demo.orangehrmlive.com/index.php/dashboard");
		WebElement UserLog = driver.findElement(By.id("txtUsername"));{
			WebElement PassLog = driver.findElement(By.id("txtPassword"));
			WebElement LoginButton = driver.findElement(By.id("btnLogin"));
			UserLog.click();
			UserLog.sendKeys("Admin");
			PassLog.click();
			PassLog.sendKeys("admin");
			LoginButton.click();
			Thread.sleep(2000);	
		}
	}
	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
		report.endTest(test);
		report.flush();
		
	}
	

	@Given("^the Add Employee Tab$")
	public void the_Add_Employee_Tab() throws InterruptedException {
		Thread.sleep(200);
	   WebElement PIM = driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]/b"));
	   PIM.click();
	   
	   WebElement AddEmButton = driver.findElement(By.id("menu_pim_addEmployee"));
	   AddEmButton.click();
	}
	@When("^I fill out the Employee Details correctly$")
	public void i_fill_out_the_Employee_Details_correctly() {
//		FileInputStream file = null;
//		file = new FileInputStream(LoginData);
//		XSSFWorkbook workbook = null;
//		workbook = new XSSFWorkbook(file);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//
//		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
//			
//			XSSFCell firstName = sheet.getRow(i).getCell(0);
//			XSSFCell middleName = sheet.getRow(i).getCell(1);
//			XSSFCell lastName = sheet.getRow(i).getCell(2);
//			XSSFCell EmployeeID = sheet.getRow(i).getCell(3);
//			
//			String name1 = firstName.getStringCellValue();
//			String name2 = middleName.getStringCellValue();
//			String name3 = lastName.getStringCellValue();
//			String EmId = EmployeeID.getStringCellValue();
			WebElement fName = driver.findElement(By.id("firstName")); 
			fName.click();
			fName.sendKeys("namef");
			WebElement mName = driver.findElement(By.id("middleName")); 
			mName.click();
			mName.sendKeys("nameh");
			WebElement lName = driver.findElement(By.id("lastName")); 
			lName.click();
			lName.sendKeys("name");
			WebElement IDName = driver.findElement(By.id("employeeId")); 
			IDName.click();
			IDName.sendKeys("123456");
	}
	
	@When("^I choose to create Login Details$")
	public void i_choose_to_create_Login_Details() {
	WebElement checkBox = driver.findElement(By.xpath("//*[@id=\"chkLogin\"]")); 
	checkBox.click();
	
	}
	
	
	
	
	
	
	@When("^I fill out the Login Details correctly$")
	public void i_fill_out_the_Login_Details_correctly() { 
		WebElement UName = driver.findElement(By.id("user_name")); 
		UName.click();
		UName.sendKeys("Admin1");
		WebElement pName = driver.findElement(By.id("user_password")); 
		WebElement p2Name = driver.findElement(By.id("re_password")); 
		pName.click();
		pName.sendKeys("admin1");
		p2Name.click();
		p2Name.sendKeys("admin1");
	}
	@When("^I click the Save button$")
	public void i_click_the_Save_button() {
		WebElement save = driver.findElement(By.id("btnSave"));	
		save.click();
	}

	@Then("^I can see information about the user$")
	public void i_can_see_information_about_the_user() {
		WebElement EName = driver.findElement(By.xpath("//*[@id=\"personal_txtEmpFirstName\"]")); 
		EName.isDisplayed();
	}

	}

