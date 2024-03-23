//package com.lbg.everestbe.selenium;
//
//import java.time.Duration;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class ClickTest {
//
//	private RemoteWebDriver driver;
//	private WebDriverWait wait;
//
//	@BeforeEach
//	void init() {
//		this.driver = new ChromeDriver();
//		this.driver.manage().window().maximize();
//		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//	}
//
//	@Test
//	void testClick() {
//		this.driver.get("http://localhost:3000");
//
//		WebElement displayT1 = this.driver.findElement(By.cssSelector("#root > div:nth-child(2) > h2:nth-child(1)"));
//		Assertions.assertEquals(true, displayT1.getText().contains("CEO"));
//
//		WebElement displayT2 = this.driver.findElement(By.cssSelector("#root > div:nth-child(2) > h2:nth-child(2)"));
//		Assertions.assertEquals(true, displayT2.getText().contains("CEO"));
//
//		WebElement displayT3 = this.driver.findElement(By.cssSelector("#root > div:nth-child(2)"));
//		Assertions.assertEquals(true, displayT3.getText().contains("CEO"));
//
//		WebElement existingCustLink = this.driver.findElement(By.cssSelector(
//				"#root > div.main-navbar.shadow-sm.sticky-top > div > div > div > div.col-md-5.my-auto > ul > li:nth-child(3) > a"));
//		existingCustLink.click();
//
//		WebElement adminLink = this.driver.findElement(
//				By.cssSelector("#root > div > div > div > div > div.col-md-5.my-auto > ul > li:nth-child(4) > a"));
//		adminLink.click();
//
//		WebElement basketclick = this.driver.findElement(By.cssSelector("#basket"));
//		basketclick.click();
//
//	}
//}