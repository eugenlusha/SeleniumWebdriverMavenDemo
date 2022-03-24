package com.sample.www.nopCommercePageObject;

import com.sample.www.nopCommerce.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginPageService {
    private LoginPage loginPage;
    public LoginPageService(WebDriver driver){
        loginPage = new LoginPage(driver);
    }

    public void loginWithCredentials(String email, String password){
        loginPage.fillEmail(email);
        loginPage.fillPassword(password);
        loginPage.proceedToLogin();
    }
    public void navigateToRegisterPage(){
        loginPage.goToRegisterPage();
    }
}
