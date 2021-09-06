package com.project.pom;

import static org.junit.Assert.assertEquals;

import java.awt.Font;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;


public class RegisterPage extends base {
	
	//LOCALIZADORES 
		By loc_reg = By.linkText("REGISTER");
		By loc_img_reg = By.xpath("//img[@src='images/mast_register.gif']");
		//---------
		By loc_mail = By.id("email");
		By loc_pass1 = By.name("password");
		By loc_pass2 = By.name("confirmPassword");
		By loc_pass22 = By.cssSelector("input[name='confirmPassword']");
		By loc_btn = By.name("submit");
		//---------
		By loc_message = By.tagName("font");

	//CONSTRUCTOR CON ERENCIA
	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//METOD REGISTRO
public void registerUser() throws InterruptedException {
	click(loc_reg);
	Thread.sleep(2000);
	if(isDisplayed(loc_img_reg)) {
		type("adolfo2311@gmail.com",loc_mail);
		type("1234",loc_pass1);
		type("1234",loc_pass2);
		
		click(loc_btn);
	}else {
		System.out.println("NOT FOUNDS");
	}
}
//MENSAJE DE EXITO	
public String resisteredMessage() {
	List<WebElement> fonts = finElements(loc_message);
	return getText(fonts.get(5));
}
	
	
}
