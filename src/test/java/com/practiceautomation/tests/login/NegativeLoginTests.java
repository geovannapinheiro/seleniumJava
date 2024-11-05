package com.practiceautomation.tests.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTests {
    @Test
    public void incorrectUsernameTest()
    {
        // Open page
        System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Type username incorrectUser into Username field
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("wrong_student");

        // Type password Password123 into Password field
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("Password123");

        // Push Submit button
        WebElement submitBtn = driver.findElement(By.id("submit"));
        submitBtn.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Verify error message is displayed
        WebElement errorUsernameMsg = driver.findElement(By.id("error"));
        Assert.assertTrue(errorUsernameMsg.isDisplayed());

        // Verify error message text is Your username is invalid!
        String expectedErrorMessage = "Your username is invalid!";
        String actualErrorMessage = errorUsernameMsg.getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

        driver.quit();

    }

    @Test
    public void incorrectPasswordTest()
    {
        // Open page
        WebDriver driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Type username student into Username field
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("student");

        // Type password incorrectPassword into Password field
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("wrong_password");

        // Push Submit button
        WebElement submitBtn = driver.findElement(By.id("submit"));
        submitBtn.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Verify error message is displayed
        WebElement errorPasswordMsg = driver.findElement(By.id("error"));
        Assert.assertTrue(errorPasswordMsg.isDisplayed());

        // Verify error message text is Your password is invalid!
        String expectedErrorMessage = "Your password is invalid!";
        String actualErrorMessage = errorPasswordMsg.getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

        driver.quit();
    }
}
