package com.sample.www.nopCommerce;
import com.sample.www.Functions.Functions;
import com.sample.www.helpers.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage {
    private Helpers helpers;
    Functions functions;

    @FindBy(className = "email")
    WebElement emailBox;

    @FindBy(className = "password")
    WebElement passwordBox;

    @FindBy(xpath = "//button[@type='submit'][@class='button-1 login-button']")
    WebElement loginButton;

    @FindBy(xpath = "//button[@class='button-1 register-button']")
    WebElement registerButton;

    public LoginPage(WebDriver driver){
        this.helpers=new Helpers(driver);
        this.functions=new Functions(driver);
    }
    public void setDriver(WebDriver driver){
        this.helpers=new Helpers(driver);
        this.functions=new Functions(driver);
    }

    public WebElement getEmailBox() {
        return emailBox;
    }

    public WebElement getPasswordBox() {
        return passwordBox;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getRegisterButton() {
        return registerButton;
    }

    public void loginWithCredentials(String email, String password){
        helpers.sendKeys(emailBox,email);
        helpers.sendKeys(passwordBox,password);
        helpers.clickElement(loginButton);
    }
    public void goToRegisterPage(){
        helpers.clickElement(registerButton);
    }

}
