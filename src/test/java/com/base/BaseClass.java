package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	

public static WebDriver driver;


WebDriver getL() {
		return driver;
	}

	public void browserSteup() {
		driver = new ChromeDriver();
		//return driver;
	}
	
	public void CloseWindow() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
	
	public String getPath() {
		String s = System.getProperty("user.dir");
		return s;	
	}
	public String getPropertiesValue(String key) throws FileNotFoundException, IOException {
		
		Properties prop = new Properties();
		
		prop.load(new FileInputStream(getPath() + "\\Config\\config.properties"));
		
		Object obj = prop.get(key);
		
		String value = (String)obj;
		return value;
	}

	public void launchUrl(String s) {
		driver.get(s);
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public WebElement findElement(String xpath) {
		WebElement ele = driver.findElement(By.xpath(xpath));
		return ele;
	}

	public String getText(WebElement e) {
		
		String text = e.getText();
		return text;	
	}

	
	public List<WebElement> lstOfElements(String xpath) {
		List<WebElement> ele = driver.findElements(By.xpath(xpath));
		return ele;
	}

	public void enterKey() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

	public void downKey() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);

	}

	public void passTxt(WebElement e, String s) {
		e.sendKeys(s);
	}

	public void moveToElement(WebElement e) {
		Actions a = new Actions(driver);
		a.moveToElement(e).perform();
	}

	public void rightClick(WebElement e) {
		Actions a = new Actions(driver);
		a.contextClick(e).perform();
	}

	public void doubleClick(WebElement e) {
		Actions a = new Actions(driver);
		a.doubleClick(e).perform();
	}

	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void dismissAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public void scrollDownToElement(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", e);
	}

	public void scrollUpToElement(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false);", e);
	}

	public void ddnSelectByTxt(WebElement e, String s1) {
		Select s = new Select(e);
		s.selectByVisibleText(s1);
	}

	public void ddnSelectByValue(WebElement e, String s1) {
		Select s = new Select(e);
		s.selectByValue(s1);
	}

	public void switchToFrame(WebElement e) {

		driver.switchTo().frame(e);
	}

	public void switchToDefaultContent() {

		driver.switchTo().defaultContent();
	}

	public byte[] takeScreenShot() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] b = ts.getScreenshotAs(OutputType.BYTES);
		
		return b;
	}

}
