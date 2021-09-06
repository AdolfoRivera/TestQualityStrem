package com.project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class base {

	private WebDriver driver;
	
	//CONSTRUCTOR
	public base(WebDriver driver) {
		this.driver=driver;
	}
	//METODO PARA CONEXION CON CHROME
	public WebDriver chromeDriverConnection() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver=new ChromeDriver();
		return driver;
	}
	//METODO DRAVIR DE LA MAYOTIA DE LOS METODOS
	public WebElement finElement(By locator) {
		return driver.findElement(locator);   //POR SI HAY ALGUN CAMBIO DE VERCION SE MODIFICA EL NOMBRE DEL METODO SE VIENE AQUI Y LISTO
	}
	//METODO PARA DEBUELVE LISTA DE ELEMENTODS
	public List<WebElement> finElements(By locator){
		return driver.findElements(locator);  //POR SI HAY ALGUN CAMBIO DE VERCION SE MODIFICA EL NOMBRE DEL METODO SE VIENE AQUI Y LISTO
	}
	//METODO GETTEXT
	public String getText(WebElement element) {
		return element.getText();
	}
	//SOBRECARGA DEL METODO GETTEXT
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	//METODO PARA ESCRIVIR O MANDAR TEXTO
	public void type(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
	}
	//METODO CLIK
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	//METODO QUE NOS DICE SI EL ELEMENTO SE ENCUENTRA LISTOMPARA SER UTILIZADO
	public Boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		}catch(org.openqa.selenium.NoSuchElementException e) {//CAPTURAR EXCEPTION EL ELEMENTO NO ESTA
		return false;	
		}
	}
	//METODO GET ENCARGADO DE RECIVIR URL Y DE ABRIRLA LA PAGINA
	public void visit(String url) {
		driver.get(url);
	}
}
