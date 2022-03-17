package com.sample.www.test;

import org.openqa.selenium.By;

public class FacebookLoginPage {
    public static By title= By.cssSelector(".fb_logo");
    public static By description = By.tagName("h2");
    public static By email = By.id("email");
    public static By password = By.id("pass");
    public static By loginButton = By.name("pass");
    public static By forgotPassword = By.linkText("Forgot password?");
    public static By createNewAccount = By.cssSelector("._6ltg > a");
}
