package com.qualitystream.tutorial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchTest {

	private WebDriver driver;
	
	//LOCALIZADOR
	By loc_video = By.cssSelector("a[href='https://www.youtube.com/watch?v=R_hh3jAqn8M']");
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");//direccion del ejecutable chromedriver
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");//comando para enviar la url al navegador
	}
	
	@Test
	public void testGooglePage() {
		
	WebElement searchbox=driver.findElement(By.name("q"));//el comado para encontrar un elemento el la pagina  tambien un localizador
	
	searchbox.clear();//para limpiar cualquier texto que este en la caja de busqueda
	searchbox.sendKeys("quality-stream Introducción a la Automatización de Pruebas de Software");//comando para enviar el texto que queramos enviar a la caja de texto
	searchbox.submit();//para que envie la inf es como dar enter
	
	
	
	//Implicit wait esperar que uno o varios elementos esten presenes en la pagina
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//tempo que queremos que espere --tiempo de carga
	//puede dar falsos positivos en esa busqueda al no terminar de cargar la pagina y hacewr el test
	
	
	
	
	//Explicit Wait tipo de esper esplicita no se recomineda relentisa test
	//WebDriverWait ewait=new WebDriverWait(driver, 10);
								//hay muchos elementos precentes para hacer muchos tipos de espera selcionado,cargado,listo para hacer clik etc...
	//ewait.until(ExpectedConditions.titleContains("quality-stream")); //hay muchas maneras de hacer esperas estas 
	
	
	//FluenWait espera para las llamas asincronas con ajax
/*	Wait<WebDriver> fwait=new FluentWait<WebDriver>(driver)
			.withTimeout(10,TimeUnit.SECONDS)//tiempo de espera maximo 10 segundos
			.pollingEvery(2,TimeUnit.SECONDS)//que realice consultas cada 2 segundos
			.ignoring(NoSuchElementException.class);//que ignore la exception en caso de que la aroje
			
				WebElement video = fwait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(loc_video);
					}
				}					
	);
				assertTrue(driver.findElement(loc_video).isDisplayed());//que el video buscado este precente en la apgina*/
				
	//como chequemos los resultados de la busqueda
	      assertEquals("quality-stream Introducción a la Automatización de Pruebas de Software - Buscar con Google", driver.getTitle());//que eso este en el titulo de la pagina de resultados de busqueda 
	//el tutulo debe ser igual
	
	}
	
	@After//metodo de cierre
	public void tearDown() {
		driver.quit();
	}
	
}

/*
 * 
 * TIPOS DE LOCALIZADORES
 * 1-------------------------------
 * By.id("String")
 * By.name("String");
 * By.className("class");
 * By.tagName("tag");
 * By.linkName("string");
 * By.partialLinkText("string");
 * By.cssSelector("string");
 * By.xpach("string");
 * JavaScript
 * 
 * @test void localizadores(){
 * By locator = By.id("id_del_elemento");
 * By locator_name = By.name("name_element");
 * By locator_class = By.className("clase_element"); 
 * By locator_tagName = By.tagName("tag");
 * By locator_linktext = By.linkText("texto_link");
 * By locator_partialLinkText = By.partialLinkText("parte_texto");
 * By locator_CssSelector = By.cssSelector("input[name='q']");
 * By locator_Xpath = By.xpatch("//input[@name='q']");
 * 
 * 
 * USANDO JAVASCRIPT
 * javascriptExecutor js=(JavascriptExecutor)drivers;
 * WebElement searchBox = (WebElement)js.executeScript("return document.getElementsByName('q')[0]");
 * 
 * 
 * 
 * 
 * }
 * 
 * 2-------------------------------
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */
