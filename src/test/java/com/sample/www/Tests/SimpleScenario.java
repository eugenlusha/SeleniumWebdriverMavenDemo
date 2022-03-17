package com.sample.www.Tests;
import com.sample.www.nopCommerce.*;
import com.sample.www.nopCommerce.MainPage;
import common.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.sample.www.helpers.UserData;

import java.util.concurrent.TimeUnit;

public class SimpleScenario extends TestBase {


    @Test
    public void testi() throws InterruptedException {
        test = extent.createTest("Test te ndryshme", "test")
                .assignCategory("e2e testin")
                .assignAuthor("eugen");
        //Initialization of page object classes
        LoginPage loginPage=PageFactory.initElements(driver,LoginPage.class);
        loginPage.setDriver(driver);
        MainPage mainPage=PageFactory.initElements(driver,MainPage.class);
        mainPage.setDriver(driver);
        RegisterPage registerPage=PageFactory.initElements(driver,RegisterPage.class);
        registerPage.setDriver(driver);

        //Navigate to main page
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");

        //Go to login page
        mainPage.goToLoginPage();

        //Go to register page and print browser title in console
        loginPage.goToRegisterPage();
        System.out.println(driver.getTitle());

        //Register new user and verify registration was successful
        registerPage.registerNewUser(UserData.gender,UserData.emri,UserData.mbiemri,UserData.dit,UserData.muaj,UserData.vit,UserData.email,UserData.company,UserData.getNews,UserData.password);
        registerPage.verifyRegisterProcessWasSuccessful();

        //Logout and then go to login page and login with the same credentials
        mainPage.logOutOfAccount();
        mainPage.goToLoginPage();
        loginPage.loginWithCredentials(UserData.email,UserData.password);

        //Verify login was successful and then logout
        mainPage.verifyLoginWasSuccessful();
        mainPage.logOutOfAccount();


    }
    @Test
    public void testi2() throws InterruptedException {
        test = extent.createTest("Test te ndryshme", "test")
                .assignCategory("e2e testin")
                .assignAuthor("eugen");
        //Initialization of page object classes
        MainPage mainPage = PageFactory.initElements(driver,MainPage.class);
        mainPage.setDriver(driver);
        NotebooksPage notebooksPage = PageFactory.initElements(driver,NotebooksPage.class);
        notebooksPage.setDriver(driver);
        LoginPage loginPage= PageFactory.initElements(driver,LoginPage.class);
        loginPage.setDriver(driver);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        //Navigate to main page and login after going to login page
        driver.get("https://demo.nopcommerce.com/");
        mainPage.goToLoginPage();
        loginPage.loginWithCredentials(UserData.email,UserData.password);

        //Go to notebooks page and verify if the url is that of notebooks page
        mainPage.goToNotebooksPage();
        notebooksPage.verifyUrlOfNotebooksPage();

        //Show 9 products per page
        notebooksPage.selectNumberOfProductsPerPage("9");
        notebooksPage.verifyNumberOfProductsDisplayed(6);

        //Filter products by 16gb
        notebooksPage.filterProductsBy16Gb();
        notebooksPage.verifyNumberOfProductsDisplayed(1);

        //Remove 16gb filter
        notebooksPage.unfilterProductsBy16Gb();
        notebooksPage.verifyNumberOfProductsDisplayed(6);

        //Add second and third product to wishlist
        notebooksPage.addProductToWishlistByIndex(2);
        notebooksPage.addProductToWishlistByIndex(3);


        //Add 4th 5th and 6th product to shopping cart
        notebooksPage.addProductToCartByIndex(4);
        notebooksPage.addProductToCartByIndex(5);
        notebooksPage.addProductToCartByIndex(6);


        //Verify we have 2 products in wishlist and 3 in cart
        notebooksPage.verifyNumberOfProductsInWishlist(2);
        notebooksPage.verifyNumberOfProductsInCart(3);
        mainPage.logOutOfAccount();
//         driver.quit();
    }

    @Test
    public void testi3() throws InterruptedException {
        test = extent.createTest("Test te ndryshme", "test")
                .assignCategory("e2e testin")
                .assignAuthor("eugen");

        MainPage mainPage = PageFactory.initElements(driver,MainPage.class);
        mainPage.setDriver(driver);
        LoginPage loginPage= PageFactory.initElements(driver,LoginPage.class);
        loginPage.setDriver(driver);
        MyAccountPage myAccountPage = PageFactory.initElements(driver,MyAccountPage.class);
        myAccountPage.setDriver(driver);


        //Navigate to main page and then login
        driver.get("https://demo.nopcommerce.com/");
        mainPage.goToLoginPage();
        loginPage.loginWithCredentials(UserData.email,UserData.password);

        //Go to My Account page and verify we did navigate to my account page
        mainPage.goToMyAccountPage();
        myAccountPage.verifyNavigationToMyAccountPageWasSuccessful();

        //Validate the data of the account
        myAccountPage.verifyUserCredentialsInMyAccountPage(UserData.gender,UserData.emri,UserData.mbiemri,UserData.dit,UserData.muaj,UserData.vit,UserData.email,UserData.company,UserData.getNews, UserData.password);
        mainPage.logOutOfAccount();
       // driver.quit();
    }

    @Test
    public void testi4() throws InterruptedException {
        test = extent.createTest("Test te ndryshme", "test")
                .assignCategory("e2e testin")
                .assignAuthor("eugen");
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.setDriver(driver);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.setDriver(driver);
        CartPage cartPage= PageFactory.initElements(driver,CartPage.class);
        cartPage.setDriver(driver);


        //Navigate to main page and then login
        driver.get("https://demo.nopcommerce.com/");
        mainPage.goToLoginPage();
        loginPage.loginWithCredentials(UserData.email,UserData.password);

        //Navigate to cart page after hovering cart menu and verify navigation was successful and buttons are shown
        mainPage.goToCartThroughButtonAfterHoveringCartMenu();
        cartPage.verifyNavigationToCartPageWasSuccessful();
        cartPage.verifyButtonsAreShown();

        //Verify sum of prices is correct
        cartPage.verifySumOfProductsIsCorrect();
        mainPage.logOutOfAccount();

    }



    @Test
    public void testi5() throws InterruptedException {
        test = extent.createTest("Test te ndryshme", "test")
                .assignCategory("e2e testin")
                .assignAuthor("eugen");
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.setDriver(driver);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.setDriver(driver);
        CartPage cartPage= PageFactory.initElements(driver,CartPage.class);
        cartPage.setDriver(driver);


        //Navigate to main page and then login
        driver.get("https://demo.nopcommerce.com/");
        mainPage.goToLoginPage();
        loginPage.loginWithCredentials(UserData.email,UserData.password);

        //Navigate to cart page
        mainPage.goToCart();

        //Delete first product and wait for list to update
        cartPage.deleteFirstProduct();
        //cartPage.waitUntilProductIsRefreshed(cartPage.getProductsRemoveButtonList().get(cartPage.getProductsRemoveButtonList().size()-1));
        cartPage.deleteAllProductsInCart();
        cartPage.verifyCartIsEmpty();

    }

}
