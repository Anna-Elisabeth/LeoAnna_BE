package com.lbg.everestbe.selenium;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasketTest {

	private RemoteWebDriver driver;
	private WebDriverWait wait;

	@BeforeEach
	void init() {
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	@Test
	void testBasket() {
		this.driver.get("http://localhost:3000/items");

		WebElement newItemLink = this.driver.findElement(By.cssSelector(
				"#root > div.main-navbar.shadow-sm.sticky-top > div > div > div > div.col-md-5.my-auto > ul > li:nth-child(2) > a"));
		newItemLink.click();

		WebElement name = this.driver.findElement(By.cssSelector("#iname"));
		name.sendKeys("Strawberries");

		WebElement description = this.driver.findElement(By.cssSelector("#idesc"));
		description.sendKeys("Organic - 200g");

		WebElement price = this.driver.findElement(By.cssSelector("#iprice"));
		price.sendKeys("5.99");

		WebElement quantity = this.driver.findElement(By.cssSelector("#iquant"));
		quantity.sendKeys("1");

		WebElement clickSubmit = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("#root > div:nth-child(2) > form > div > button")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickSubmit);
		clickSubmit.click();

		WebElement display = this.driver
				.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div/div[1]/div/h4/p[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", display);
		Assertions.assertEquals(true, display.getText().contains("Strawberries"));

		WebElement addToCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"#root > div:nth-child(2) > div > div > div > div > div > button.btn.btn-success.btn-md")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCart);
		addToCart.click();

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assertions.assertEquals(null, alert.getText());

		wait.until(ExpectedConditions.alertIsPresent());
		Assertions.assertEquals(true, this.driver.switchTo().alert().getText().contains("Quantity"));

		WebElement basketclick = this.driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div/div/div[4]/a/svg"));
		basketclick.click();
	}

}
