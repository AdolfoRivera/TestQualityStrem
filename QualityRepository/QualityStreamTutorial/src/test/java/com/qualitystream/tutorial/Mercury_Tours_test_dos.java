package com.qualitystream.tutorial;

import static org.junit.Assert.*;


//import java.awt.List;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Mercury_Tours_test_dos {

	private WebDriver driver;
	
	//LOCALIZADORES 
	By loc_reg = By.linkText("REGISTER");
	By loc_img_reg = By.xpath("//img[@src='images/mast_register.gif']");
	//---------
	By loc_mail = By.id("email");
	By loc_pass1 = By.name("password");
	By loc_pass2 = By.name("confirmPassword");
	By loc_pass22 = By.cssSelector("input[name='confirmPassword']");
	By loc_btn = By.name("submit");
	//--------
	By loc_Uemail = By.name("userName");
	By loc_Upass = By.name("password");
	By loc_Ubtn = By.name("submit");
	//--------
	By loc_img_login = By.xpath("//img[@src='images/banner2.gif']");
	By loc_txt_login = By.linkText("Login Successfully");
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");//direccion del ejecutable chromedriver
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/newtours/");//comando para enviar la url al navegador
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void t1_RegistrarTest() throws InterruptedException {
		driver.findElement(loc_reg).click();
		 Thread.sleep(2000);
		 
		 if(driver.findElement(loc_img_reg).isDisplayed()) {
			 
			    driver.findElement(loc_mail).sendKeys("adolfo2311@gmail.com");
		    	driver.findElement(loc_pass1).sendKeys("1234");
		    	driver.findElement(loc_pass2).sendKeys("1234");
		    	//driver.findElement(loc_pass22).sendKeys("1234");
		    	driver.findElement(loc_btn).click();
		 }else {
			 System.out.println("NO HAY FONDOS");
		 }
	   
	List<WebElement> fonts = driver.findElements(By.tagName("font"));
	assertEquals("Note: Your user name is adolfo2311@gmail.com.",fonts.get(5).getText());
	
	}
	
	@Test
	public void t2_LoginTest() throws InterruptedException {
		if(driver.findElement(loc_Uemail).isDisplayed()) {
			driver.findElement(loc_Uemail).sendKeys("adolfo2311@gmail.com");
			driver.findElement(loc_Upass).sendKeys("1234");
	    	driver.findElement(loc_Ubtn).click();
	    	Thread.sleep(2000);
	    	
	    	assertTrue(driver.findElement(loc_img_login).isDisplayed());
	    	
		}else {
			System.out.println("texbox usuario no presente");
		}
	}		 
}


