package com.curso.selenium.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    private final By usernameInput = By.name("username");
    private final By passwordInput = By.name("password");
    private final By loginButton = By.cssSelector("button[type='submit']");

    public DashboardPage loginAs(String username, String password){
        waitFor(usernameInput).sendKeys(username);
        waitFor(passwordInput).sendKeys(password);
        waitFor(loginButton).click();
        return new DashboardPage();
    }
}
