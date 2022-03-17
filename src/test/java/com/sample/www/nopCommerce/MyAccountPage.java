package com.sample.www.nopCommerce;

import com.sample.www.Functions.Functions;
import com.sample.www.helpers.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage {
    Helpers helpers;
    Functions functions;

    public MyAccountPage(WebDriver driver){
        this.helpers=new Helpers(driver);
        this.functions=new Functions(driver);
    }
    public void setDriver(WebDriver driver){
        this.helpers=new Helpers(driver);
        this.functions=new Functions(driver);
    }

    @FindBy(xpath = "//h1[text()='My account - Customer info']")
    WebElement myAccountPageWelcomingTitle;
    @FindBy(xpath = "//input[@id='gender-male']")
    WebElement radioMaleGender;
    @FindBy(xpath = "//input[@id='gender-female']")
    WebElement radioFemaleGender;
    @FindBy(id = "FirstName")
    WebElement firstName;
    @FindBy(id = "LastName")
    WebElement lastName;
    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    WebElement birthDay;
    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    WebElement birthMonth;
    @FindBy(xpath = "//select[@name='DateOfBirthYear']")
    WebElement birthYear;
    @FindBy(id = "Email")
    WebElement emailBox;
    @FindBy(id = "Company")
    WebElement companyBox;
    @FindBy(id = "Newsletter")
    WebElement newsletter;

    public WebElement getRadioMaleGender() {
        return radioMaleGender;
    }

    public WebElement getRadioFemaleGender() {
        return radioFemaleGender;
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getBirthDay() {
        return birthDay;
    }

    public WebElement getBirthMonth() {
        return birthMonth;
    }

    public WebElement getBirthYear() {
        return birthYear;
    }

    public WebElement getEmailBox() {
        return emailBox;
    }

    public WebElement getCompanyBox() {
        return companyBox;
    }

    public WebElement getNewsletter() {
        return newsletter;
    }

    public WebElement getMyAccountPageWelcomingTitle() {
        return myAccountPageWelcomingTitle;
    }

    public void verifyNavigationToMyAccountPageWasSuccessful(){
        helpers.assertElementHasText(myAccountPageWelcomingTitle,"My account - Customer info");
    }

    public void verifyUserCredentialsInMyAccountPage(String gender, String emri,String mbiemri,String dita,String muaj,String viti, String email, String company,boolean news, String password){
    if(gender.equals("f")||gender.equals("F")){
        helpers.isElementSelected(radioFemaleGender);
    }else{
        helpers.isElementSelected(radioMaleGender);
    }
    helpers.assertElementHasTextFromInput(firstName,emri);
    helpers.assertElementHasTextFromInput(lastName,mbiemri);
    helpers.assertSelectedElementFromSelectList(birthDay,dita);
    helpers.assertSelectedElementFromSelectList(birthMonth,muaj);
    helpers.assertSelectedElementFromSelectList(birthYear,viti);
    helpers.assertElementHasTextFromInput(emailBox,email);
    helpers.assertElementHasTextFromInput(companyBox,company);
        if(news){
            helpers.isElementSelected(newsletter);
        }else{
            helpers.isElementNotSelected(newsletter);
        }
    }
}
