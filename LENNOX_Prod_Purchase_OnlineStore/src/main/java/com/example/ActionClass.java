package com.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

public class ActionClass {

	public static WebDriver driver;
	
	public static void captureScreenshot(WebDriver driver, String ScrenshotName) {
		
		try {
			
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		 
		Files.copy(src, new File("Users/acer/git/sample-cucumber-testng/test-output/screenshot"));
		}
		 
		catch (IOException e)
		 {
		  System.out.println("Expection while takiing screenshots"+ e.getMessage());
		 
		 }
		 }
	



@BeforeTest
public static void setDriver(){
	System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();

}

@Test
public static void LaunchLENNOX_Website(String URL) throws IOException {
	driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	driver.navigate().to(URL);
	driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	String title = driver.getTitle();
	System.out.println("Title of the page " + title);
	driver.findElement(By.xpath("//a[@class='login-link btn NEEDS_AUTHENTICATION']")).click();
	System.out.println("Navigation page successfully");
	try
	{
		driver.findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']")).click();
		System.out.println("Accepted Cookies");
	}
	catch (Exception ex)
	{
		System.out.println("Cookies not displayed");
	}
	captureScreenshot(driver, "Browser launching Screenshots");
}






public static void SignOn(String UserName, String Password) throws InterruptedException, IOException {

	driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	System.out.println("------------>Entering User Credentials");

	driver.findElement(By.xpath("//*[@id='j_username']")).sendKeys(UserName);
	Thread.sleep(5000);

	driver.findElement(By.xpath("//*[@id='j_password']")).sendKeys(Password);
	Thread.sleep(5000);

	boolean b = driver.findElement(By.xpath("//*[@id='loginSubmit']")).isDisplayed();
	System.out.println("------------>Clicking Sign In is visiable and clicking it  "   +  b);

	driver.findElement(By.xpath("//*[@id='loginSubmit']")).click();	
	Thread.sleep(5000);

	System.out.println("------------>Logged In successfully");
	captureScreenshot(driver, "Login page Screenshots");
}

public static void Verify_Landing_Page_and_ClickMenu() throws InterruptedException, IOException {

	driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	System.out.println("------------>Successfully Logged In and verifying Landing page");
	Thread.sleep(3000);

	driver.findElement(By.xpath("//i[@class='far fa-bars v2-hamburger-menu']")).click();
	System.out.println("------------>Hamburger Mmenu Flyout Clicked Succesfully ");

	captureScreenshot(driver, "Landing Page Screenshots");
}

public static void Click_PartsandSupplies_and_CopressorsButton() throws InterruptedException, IOException {

	System.out.println("------------>Clicking Part & Supplies Option");
	Thread.sleep(3000);

	driver.findElement(By.xpath("(//div[contains(@class,'parent level-0 primary-nav-CommercialProductCatalogNode-2')]//a[contains(text(),'Parts and Supplies')])[3]")).click();
	Thread.sleep(3000);

	try
	{
		driver.findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']")).click();
		System.out.println("Accepted Cookies");
	}
	catch (Exception ex)
	{
		System.out.println("Cookies not displayed");
	}

	driver.findElement(By.xpath("(//a[contains(@title,'Compressors')])[2]")).click();
	Thread.sleep(3000);

	System.out.println("------------>Successfully Clicked Parts and Supplies & Compressors Link From Menu");
	captureScreenshot(driver, "Compressors Option Clicked Screenshots");
}


public static void ClickCompressorLink() throws IOException {

	System.out.println("------------>Compressors page Landed with List of Options");

	driver.manage().timeouts().implicitlyWait(14, TimeUnit.SECONDS);
	driver.findElement(By.xpath("(//li//following::a[contains(text(),'Compressors')][contains(@href,'compressors')])[1]")).click();

	System.out.println("------------>Clicked Compressors Options");
	captureScreenshot(driver, "Compressor product Selected Screenshots");
}

public static void SelectProduct() throws IOException, InterruptedException {

	driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

	String comm = driver.findElement(By.xpath("//h1[contains(text(),'Compressors')]")).getText();
	System.out.println("------------>Selecting Compressors  "   +  comm);

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//a[contains(text(),'Bristol Corp ')][contains(@href,'parts-and')]")).click();

	boolean b = driver.findElement(By.xpath("//b[contains(text(),'sele')]")).isDisplayed();
	System.out.println("------------>Bristol Corp selectioned and displayed  "  +   b );

	List<WebElement> Options =driver.findElements(By.xpath("//h2[@class='title']"));
	for(WebElement i : Options) {
		String a=i.getText();
		System.out.println("------------> Product description " + i.getText());
		Thread.sleep(2000);
		if(a.contains("Bristol H22J38BABC")){
			Thread.sleep(3000);
			driver.findElement(By.xpath("//h2[contains(text(),'Bristol H22J38BABC')]")).click();
			System.out.println("------------>Product 10T46 (Bristol H22J38BABC ) is available and selected on the page");
		}
	}
	captureScreenshot(driver, "Product Selected Screenshots");
}

public static void VerifyAndCompareProducts() {


	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	String ele1 = driver.findElement(By.xpath("//h1[@itemprop='name']")).getText();
	System.out.println("------------>Title Description Of the Product" + ele1);

	driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	String ele2 = driver.findElement(By.xpath("//p[@class='sku']")).getText();
	System.out.println("------------>Model of the Product" + ele2);

	driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	String ele3 = driver.findElement(By.xpath("//p[@class='price']")).getText();
	System.out.println("------------>Price Of the Product" + ele3);

	driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	String ele4 = driver.findElement(By.xpath("(//*[@id='shipping-fields']//label)[1]")).getText();
	System.out.println("------------>Standard Shipping of the Product" + ele4);

	driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	String ele5 = driver.findElement(By.xpath("(//*[@id='shipping-fields']//label)[2]")).getText();
	System.out.println("------------>Pick up Address Of the Product" + ele5);

	driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	String ele6 = driver.findElement(By.xpath("(//span[contains(text(),'ADD TO CART')])[1]")).getText();
	System.out.println("------------>Product in Add to cart" + ele6);


	captureScreenshot(driver, "Login page Screenshots");

}

@AfterTest
public static void closeDriver(){
	driver.quit();
}



}
