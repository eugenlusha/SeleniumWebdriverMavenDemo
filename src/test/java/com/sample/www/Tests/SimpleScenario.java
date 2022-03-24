package com.sample.www.Tests;
import com.sample.www.nopCommerce.*;
import com.sample.www.nopCommerce.MainPage;
import common.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.sample.www.helpers.Constants;

import java.util.concurrent.TimeUnit;

public class SimpleScenario extends TestBase {


    @Test
    public void testi() throws InterruptedException {

        //Go to login page
        mainPageService.navigateToLoginPage();

        //Go to register page and print browser title in console
        loginPageService.navigateToRegisterPage();
        mainPageService.printActualURL();

        //Register new user and verify registration was successful
        registerPageService.registerNewUser(Constants.gender, Constants.emri, Constants.mbiemri, Constants.dit, Constants.muaj, Constants.vit, Constants.email, Constants.company, Constants.getNews, Constants.password);
        registerPageService.verifyRegisterWasSuccessful();

        //Logout and then go to login page and login with the same credentials
        mainPageService.logoutOfAccount();
        mainPageService.navigateToLoginPage();
        loginPageService.loginWithCredentials(Constants.email, Constants.password);

        //Verify login was successful and then logout
        mainPageService.verifyLoginWasSuccessful();
        mainPageService.logoutOfAccount();


    }
    @Test
    public void testi2() throws InterruptedException {

        //Navigate to login page and login with credentials
        mainPageService.navigateToLoginPage();
        loginPageService.loginWithCredentials(Constants.email, Constants.password);

        //Go to notebooks page and verify if the url is that of notebooks page
        mainPageService.navigateToNotebooksPage();
        notebooksPageService.verifyUrlOfNotebooksPage();

        //Show 9 products per page
        notebooksPageService.selectNumberOfProductsToBeShown("9");
        notebooksPageService.verifyNumberOfDisplayedProductsIsCorrect(6);

        //Filter products by 16gb
        notebooksPageService.filterProductsBy16Gb();
        notebooksPageService.verifyNumberOfDisplayedProductsIsCorrect(1);

        //Remove 16gb filter
        notebooksPageService.unfilterProductsBy16Gb();
        notebooksPageService.verifyNumberOfDisplayedProductsIsCorrect(6);

        //Add second and third product to wishlist
        notebooksPageService.addProductToWishlistByIndex(2);
        notebooksPageService.addProductToWishlistByIndex(3);

        //Add 4th 5th and 6th product to shopping cart
        notebooksPageService.addProductToCartByIndex(4);
        notebooksPageService.addProductToCartByIndex(5);
        notebooksPageService.addProductToCartByIndex(6);

        //Verify we have 2 products in wishlist and 3 in cart
        notebooksPageService.verifyNumberOfProductsInWishList(2);
        notebooksPageService.verifyNumberOfProductsInCart(3);
        mainPageService.logoutOfAccount();

    }

    @Test
    public void testi3() throws InterruptedException {

        //Navigate to login page and login with credentials
        mainPageService.navigateToLoginPage();
        loginPageService.loginWithCredentials(Constants.email, Constants.password);

        //Go to My Account page and verify we did navigate to my account page
        mainPageService.navigateToMyAccountPage();
        myAccountPageService.verifyNavigationToMyAccountPageWasSuccessful();

        //Validate the data of the account
        myAccountPageService.verifyUserCredentialsAreCorrect(Constants.gender, Constants.emri, Constants.mbiemri, Constants.dit, Constants.muaj, Constants.vit, Constants.email, Constants.company, Constants.getNews, Constants.password);
        mainPageService.logoutOfAccount();
    }

    @Test
    public void testi4() throws InterruptedException {


        //Navigate to login page and login with credentials
        mainPageService.navigateToLoginPage();
        loginPageService.loginWithCredentials(Constants.email, Constants.password);

        //Navigate to cart page after hovering cart menu and verify navigation was successful and buttons are shown
        mainPageService.navigateToCartPageThroughCartMenu();
        cartPageService.verifyNavigationToCartPageWasSuccessful();
        cartPageService.verifyButtonsAreShown();

        //Verify sum of prices is correct
        cartPageService.verifySumOfProductsIsCorrect();
        mainPageService.logoutOfAccount();

    }



    @Test
    public void testi5() throws InterruptedException {


        //Navigate to login page and login with credentials
        mainPageService.navigateToLoginPage();
        loginPageService.loginWithCredentials(Constants.email, Constants.password);

        //Navigate to cart page
        mainPageService.navigateToCartPage();

        //Delete first product
        cartPageService.deleteFirstProduct();

        //Delete all products and verify cart is empty
        cartPageService.deleteAllProducts();
        cartPageService.verifyCartIsEmpty();

    }

}
