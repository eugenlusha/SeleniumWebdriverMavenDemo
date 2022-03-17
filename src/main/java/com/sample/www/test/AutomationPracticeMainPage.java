package com.sample.www.test;

import org.openqa.selenium.By;

public class AutomationPracticeMainPage {
    public static By signInButton = By.className("login");
    public static By truckIcon = By.className("icon-truck");
    public static By creditCardIcon = By.cssSelector(".icon-credit-card");
    public static By tShirts = By.cssSelector("#block_top_menu > ul > li:nth-child(3) > a");
    public static By dresses = By.cssSelector("#block_top_menu > ul > li:nth-child(2) > a");
    public static By searchBox = By.id("search_query_top");
    public static By newsLetterEmailBox= By.id("newsletter-input");
    public static By contactUs = By.linkText("Contact us");
    public static By newProducts = By.linkText("New products");
    public static By womenCategory = By.linkText("Women");
    public static By bannerPhoto = By.tagName("img");
    public static By searchButtonIcon = By.tagName("button");
    public static By searchBoxUsingName = By.name("search_query");
    public static By getNewsLetterEmailBoxSubmitButton = By.name("submitNewsletter");

}
