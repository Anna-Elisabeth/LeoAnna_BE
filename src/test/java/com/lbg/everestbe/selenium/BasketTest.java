package com.lbg.everestbe.selenium;

import static org.assertj.core.api.Assertions.fail;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@TestMethodOrder(OrderAnnotation.class)

@Sql(scripts = { "classpath:everest-schema.sql",
		"classpath:everest-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

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
	@Order(3)
	void testBasket() throws InterruptedException {
		this.driver.get("http://localhost:3000/");

		WebElement nameAttempt = this.driver.findElement(By.cssSelector("#username"));
		nameAttempt.sendKeys("Lb4lD£");

		WebElement failedPassword = this.driver.findElement(By.cssSelector("#password"));
		failedPassword.sendKeys("Testng");

		WebElement clickSubmit = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/main/form/div/div/button")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickSubmit);
		Thread.sleep(500);
		clickSubmit.click();

		Alert failAlert = wait.until(ExpectedConditions.alertIsPresent());
		failAlert.accept();

		WebElement name = this.driver.findElement(By.cssSelector("#name"));
		name.sendKeys("Liliano");

		WebElement address = this.driver.findElement(By.cssSelector("#address"));
		address.sendKeys("456 Road");

		WebElement email = this.driver.findElement(By.cssSelector("#email"));
		email.sendKeys("LB@domain.com");

		WebElement phone = this.driver.findElement(By.cssSelector("#phone"));
		phone.sendKeys("012345678");

		WebElement username = this.driver.findElement(By.cssSelector("#username"));
		username.sendKeys("Lb4lD£");

		WebElement password = this.driver.findElement(By.cssSelector("#password"));
		password.sendKeys("Testing");

		WebElement clickRegister = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"al\"]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickRegister);
		Thread.sleep(500);
		clickRegister.click();

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();

		WebElement name2 = this.driver.findElement(By.cssSelector("#username"));
		name2.sendKeys("Lb4lD£");

		WebElement password2 = this.driver.findElement(By.cssSelector("#password"));
		password2.sendKeys("Testing");

		WebElement clickSubmit2 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/main/form/div/div/button")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickSubmit2);
		Thread.sleep(500);
		clickSubmit2.click();

		Alert alert2 = wait.until(ExpectedConditions.alertIsPresent());
		alert2.accept();

		WebElement clickAddItem1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("#root > div > main > div > div > div > div:nth-child(1) > div > button")));
		clickAddItem1.click();

		Alert alertItem1 = wait.until(ExpectedConditions.alertIsPresent());
		alertItem1.accept();

		WebElement clickAddItem2 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("#root > div > main > div > div > div > div:nth-child(2) > div > button")));
		clickAddItem2.click();

		Alert alertItem2 = wait.until(ExpectedConditions.alertIsPresent());
		alertItem2.accept();

		WebElement clickAddItem3 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("#root > div > main > div > div > div > div:nth-child(3) > div > button")));
		clickAddItem3.click();

		Alert alertItem3 = wait.until(ExpectedConditions.alertIsPresent());
		alertItem3.accept();

		WebElement clickBasket = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#basket")));
		clickBasket.click();

		WebElement clickClear = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"#root > div > main > table > tbody > tr:nth-child(1) > td:nth-child(4) > div > button:nth-child(4)")));
		clickClear.click();

		WebElement checkDeletedItem = this.driver.findElement(
				By.cssSelector("#root > div > main > table > tbody > tr:nth-child(1) > td:nth-child(6) > button"));
		checkDeletedItem.click();

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//td[contains(text(), 'Strawberries')]")));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/main/table/tbody/tr[3]")));

		try {
			this.driver.findElement(By.xpath("//*[@id='root']/div/main/table/tbody/tr[3]"));
			fail("Delete has failed");
		} catch (NoSuchElementException ex) {

		}

		WebElement clickClear2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"#root > div > main > table > tbody > tr:nth-child(1) > td:nth-child(4) > div > button:nth-child(4)")));
		clickClear2.click();

		WebElement clickIncrease = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"#root > div > main > table > tbody > tr:nth-child(1) > td:nth-child(4) > div > button:nth-child(5)")));
		clickIncrease.click();

		WebElement clickIncrease2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"#root > div > main > table > tbody > tr:nth-child(1) > td:nth-child(4) > div > button:nth-child(5)")));
		clickIncrease2.click();

		WebElement clickDecrease = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"#root > div > main > table > tbody > tr:nth-child(2) > td:nth-child(4) > div > button:nth-child(3)")));
		clickDecrease.click();

		WebElement checkItemName = this.wait.until(ExpectedConditions.presenceOfElementLocated(
				By.cssSelector("#root > div > main > table > tbody > tr:nth-child(1) > td:nth-child(2)")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkItemName);
		Assertions.assertEquals("Camera", checkItemName.getText());

		WebElement checkPrice = this.wait.until(ExpectedConditions.presenceOfElementLocated(
				By.cssSelector("#root > div > main > table > tbody > tr:nth-child(1) > td:nth-child(3)")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkPrice);
		Assertions.assertEquals("£ 149.99", checkPrice.getText());

		WebElement checkIteName2 = this.wait.until(ExpectedConditions.presenceOfElementLocated(
				By.cssSelector("#root > div > main > table > tbody > tr:nth-child(2) > td:nth-child(2)")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkIteName2);
		Assertions.assertEquals("Drone", checkIteName2.getText());

		WebElement checkPrice2 = this.wait.until(ExpectedConditions.presenceOfElementLocated(
				By.cssSelector("#root > div > main > table > tbody > tr:nth-child(2) > td:nth-child(3)")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkPrice2);
		Assertions.assertEquals("£ 1500", checkPrice2.getText());

		WebElement checkTotal = this.wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#root > div > main > div > h2")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkTotal);
		Assertions.assertEquals("Basket Total : £1799.98", checkTotal.getText());

		WebElement clickCheckout = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#root > div > main > button")));
		clickCheckout.click();

	}
}