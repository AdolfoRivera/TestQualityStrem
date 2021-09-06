package com.qualitystream.tutorial;

import static org.junit.Assert.*;

import java.awt.Font;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryTours_AutomatedTest {

	private WebDriver driver;
	//By Loc_reg = By.id("u_0_2_Ud");
	By Loc_reg1 = By.linkText("Crear cuenta nueva");
	By loc_dreg = By.linkText("Registrarte");
	By loc_img_reg = By.xpath("//img[@src='https://static.xx.fbcdn.net/rsrc.php/y8/r/dF5SId3UHWd.svg']");
	
	//--
	By loc_nombre =By.name("firstname");
	By loc_apellido =By.name("lastname");
	By loc_email =By.name("reg_email__");
	By loc_em =By.name("reg_email_confirmation__");
	By loc_pass =By.name("reg_passwd__");
	
	
	By loc_dia =By.name("birthday_day");
	By loc_mes =By.name("birthday_month");
	By loc_año =By.name("birthday_year");
	
	By loc_hombre = By.linkText("Hombre");
	By loc_hombreid = By.id("u_0_7_JM");
	By loc_HM =By.cssSelector("input[name='sex']");
	By loc_H =By.name("Hombre");
	
	//clic
	By loc_registrar = By.id("u_0_10_sp");
	By loc_registrar1 = By.name("websubmit");
	
	//
	By loc_us_reg =By.name("code");
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");//direccion del ejecutable chromedriver
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://es-la.facebook.com/login/");//comando para enviar la url al navegador
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();//para cerrar el navegador
	}

	@Test
	public void testregistro() throws InterruptedException {
		
		/*WebElement limpiarcajadetexto=driver.findElement(By.id("email"));
		WebElement limpiarcajadetexto1=driver.findElement(By.id("pass"));
		limpiarcajadetexto.clear();
		limpiarcajadetexto1.clear();*/
		
    driver.findElement(Loc_reg1).click();
    Thread.sleep(2000);//dos segundos de espera para que carge
    
    if(driver.findElement(loc_img_reg).isDisplayed()) {//nos debulebe un valor boleano si la imagen esta = true si no=false
    	driver.findElement(loc_nombre).sendKeys("Adolfo");
    	driver.findElement(loc_apellido).sendKeys("Rivera");
    	driver.findElement(loc_email).sendKeys("1213123123213213213214cddfs@gmail.com");
    	driver.findElement(loc_em).sendKeys("1213123123213213213214cddfs@gmail.com");
    	driver.findElement(loc_pass).sendKeys("Loc231az135");
    	driver.findElement(loc_dia).sendKeys("27");
    	driver.findElement(loc_mes).sendKeys("sep");
    	driver.findElement(loc_año).sendKeys("1994");
    	driver.findElement(loc_HM).click();
    	
    	driver.findElement(loc_registrar1).click();
    }
    else {//si la imagen no se encuentra
    	
    System.out.println("no fondos");
    }
	// List<WebElement> fonts=driver.findElement(By.tagName("fonts"));
   // List<WebElement> fonts =driver.findElement(By.tagName("font"));
    //assertEquals("code",font.get(5).getText());
    //driver.findElement(loc_us_reg).equals("code");
    
    /*PARA LOGEARSE YA NO SE PUEDE CON LA PAGINA XD FACEBOOK
     * 
     * CREAMOS ARRIBA LOS LOCATORES
     * By loc_user =By.name("userr");
     * By loc_pass =By.name("pass");
     * By loc_btn =By.name("login");
     * 
     * public void sinintest(){
     * if(driver.findElement(userr).isDisplayed()){ //verifica que el texbox usuario este presente en la pagina
     *  driver.findElement(userr).sendKeys(Adolfo);//enviamos el usuario creado anteriormente
     *  driver.findElement(pass).sendKeys(Loc231az135);//enviamos la contraseña creado anteriormente
     *  driver.findElement(loc_btn).click();
     *  Thread.sleep(2000);//dos segundos de espera para que carge
     *  
     *  asserTrue(driver.finfElement(loc_img).isDisplayed());//verificar la imagen para saber que ya estamos en la pagina xd
     * }else{
     * System.out.println("texbox no presente");
     * }
     * 
     * }
     * 
     * */
    
	}

}
