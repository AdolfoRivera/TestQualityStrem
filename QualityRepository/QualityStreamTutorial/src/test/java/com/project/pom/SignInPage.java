package com.project.pom;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends base {
	
	By loc_Uemail = By.name("userName");
	By loc_Upass = By.name("password");
	By loc_Ubtn = By.name("submit");
	//--------
	By loc_img_login = By.xpath("//img[@src='images/banner2.gif']");
	By loc_txt_login = By.linkText("Login Successfully");
	
	public SignInPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//
	public void signIn() {
		if(isDisplayed(loc_Uemail)) {
			type("adolfo2311@gmail.com",loc_Uemail);
			type("1234",loc_Upass);
			click(loc_Ubtn);
	    	
		}else {
			System.out.println("texbox usuario no presente");
		}
	}
//METODO PARA SABER SI EL INICIO DE SECION FUE EXITOSO
	public boolean isHomePageDisplayed() {
		return isDisplayed(loc_img_login);
	}
}
