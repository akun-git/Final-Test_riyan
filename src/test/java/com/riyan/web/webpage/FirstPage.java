package com.riyan.web.webpage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class FirstPage {

    WebDriver driver;

    By signin = By.id("login2");
    By signup = By.id("signin2");

    public FirstPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openWeb() {
        driver.get("https://www.demoblaze.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nava")));
    }

    public void clickSignin() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        // Wait for visibility
        WebElement signinButton = wait.until(ExpectedConditions.visibilityOfElementLocated(signin));

        // Click using JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", signinButton);

        // Wait for the modal to appear
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("logInModalLabel")));

    }

    public void clickSignup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(signup));
        driver.findElement(signup).click();
    }

    public void validateOnFirstPage() {
        String text = driver.findElement(By.id("cat")).getText();
        assertEquals("CATEGORIES", text);
    }

}