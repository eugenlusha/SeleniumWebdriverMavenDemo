package com.sample.www.nopCommerce;

import com.sample.www.Functions.Functions;
import com.sample.www.helpers.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class NotebooksPage {

     Helpers helpers;
     Functions functions;

     public NotebooksPage(WebDriver driver){
          this.helpers=new Helpers(driver);
          this.functions=new Functions(driver);
     }
     public void setDriver(WebDriver driver){
          this.helpers=new Helpers(driver);
          this.functions=new Functions(driver);
     }
     @FindBy(xpath = "//select[@id='products-pagesize']")
     WebElement numberOfProductsPerPageSelectList;

     @FindBy(id = "attribute-option-10")
     WebElement filterBy16Gb;

     @FindBy(xpath = "//div[@class='item-grid']/div")
     List<WebElement> listOfDisplayedElements;

     @FindBy(xpath = "//button[@class='button-2 add-to-wishlist-button']")
     List<WebElement> addProductToWishlistButtonList;

     @FindBy(xpath = "//div[@class='bar-notification success']")
     WebElement addingToWishlistOrCartSuccessNotification;


     @FindBy(xpath = "//div[@id='bar-notification']//span")
     WebElement successBannerClosingButton;

     @FindBy(xpath = "//button[@class='button-2 product-box-add-to-cart-button']")
     List<WebElement> addProductToShoppingCartButtonList;


     @FindBy(xpath = "//a[@href='/wishlist']//span[2]")
     WebElement wishlistNumberOfProductsAdded;

     @FindBy(xpath = "//a[@href='/cart']//span[2]")
     WebElement cartNumberOfProductsAdded;


     public WebElement getNumberOfProductsPerPageSelectList() {
          return numberOfProductsPerPageSelectList;
     }

     public WebElement getFilterBy16Gb() {
          return filterBy16Gb;
     }

     public List<WebElement> getListOfDisplayedElements() {
          return listOfDisplayedElements;
     }

     public WebElement getAddingToWishlistOrCartSuccessNotification() {
          return addingToWishlistOrCartSuccessNotification;
     }

     public WebElement getSuccessBannerClosingButton() {
          return successBannerClosingButton;
     }

     public WebElement getWishlistNumberOfProductsAdded() {
          return wishlistNumberOfProductsAdded;
     }

     public WebElement getCartNumberOfProductsAdded() {
          return cartNumberOfProductsAdded;
     }

     public List<WebElement> getAddProductToWishlistButtonList() {
          return addProductToWishlistButtonList;
     }

     public List<WebElement> getAddProductToShoppingCartButtonList() {
          return addProductToShoppingCartButtonList;
     }

     public void selectNumberOfProductsPerPage(String str){
          helpers.selectByVisibleText(numberOfProductsPerPageSelectList,str);
          helpers.waitUntilStalenessOfElement(listOfDisplayedElements.get(0));
     }

     public void filterProductsBy16Gb(){
          if(!helpers.isElementSelected(filterBy16Gb)){
              helpers.clickElement(filterBy16Gb);
          }
          helpers.waitUntilStalenessOfElement(listOfDisplayedElements.get(0));
     }
     public void unfilterProductsBy16Gb(){
          if(helpers.isElementSelected(filterBy16Gb)){
               helpers.clickElement(filterBy16Gb);
          }
          helpers.waitUntilStalenessOfElement(listOfDisplayedElements.get(0));
     }

     public void verifyUrlOfNotebooksPage(){
          helpers.assertWebpageLinkIsAsExpected("https://demo.nopcommerce.com/notebooks");
     }
     public void verifyNumberOfProductsDisplayed(int number){
          helpers.waitUntilAllElementsAreVisible(listOfDisplayedElements);
          Assert.assertEquals(listOfDisplayedElements.size(),number);
     }

     public void addProductToWishlistByIndex(int position){
          if(position<=addProductToWishlistButtonList.size()){
               helpers.clickElement(addProductToWishlistButtonList.get(position-1));
               helpers.waitUntilElementIsVisible(addingToWishlistOrCartSuccessNotification);
               helpers.assertElementHasText(addingToWishlistOrCartSuccessNotification,"The product has been added to your wishlist");
               helpers.waitUntilElementIsInvisible(addingToWishlistOrCartSuccessNotification);
          }
     }

     public void addProductToCartByIndex(int position){
          if(position<=addProductToShoppingCartButtonList.size()){
               helpers.clickElement(addProductToShoppingCartButtonList.get(position-1));
               helpers.waitUntilElementIsVisible(addingToWishlistOrCartSuccessNotification);
               helpers.assertElementHasText(addingToWishlistOrCartSuccessNotification,"The product has been added to your shopping cart");
               helpers.waitUntilElementIsInvisible(addingToWishlistOrCartSuccessNotification);
          }
     }

     public void verifyNumberOfProductsInCart(int number){
        String value="("+number+")";;
        helpers.waitUntilElementIsVisible(cartNumberOfProductsAdded);
        Assert.assertEquals(cartNumberOfProductsAdded.getText(),value);
    }
    public void verifyNumberOfProductsInWishlist(int number){
        String value="("+number+")";;
        helpers.waitUntilElementIsVisible(wishlistNumberOfProductsAdded);
        Assert.assertEquals(wishlistNumberOfProductsAdded.getText(),value);
    }

}
