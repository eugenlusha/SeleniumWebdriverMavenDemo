package com.sample.www.nopCommercePageObject;

import com.sample.www.nopCommerce.LoginPage;
import com.sample.www.nopCommerce.MainPage;
import org.openqa.selenium.WebDriver;

import java.util.WeakHashMap;

public class MainPageService {
    MainPage mainPage;
     public MainPageService(WebDriver driver){
         mainPage=new MainPage(driver);
     }
     public void navigateToLoginPage(){
         mainPage.goToLoginPage();
     }
     public void navigateToMyAccountPage(){
         mainPage.goToMyAccountPage();
     }
     public void navigateToNotebooksPage(){
         mainPage.goToNotebooksPage();
     }
     public void navigateToCartPage(){
         mainPage.goToCart();
     }
     public void navigateToCartPageThroughCartMenu(){
         mainPage.goToCartThroughButtonAfterHoveringCartMenu();
     }

     public void logoutOfAccount(){
         mainPage.logOutOfAccount();
     }

      public void verifyLoginWasSuccessful(){
         mainPage.verifyLoginWasSuccessful();
      }

      public void printActualURL(){
        mainPage.getCurrentUrl();
    }


}
