package com.sample.www.nopCommerce;

import com.sample.www.Functions.Functions;
import com.sample.www.helpers.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RegisterPage {
    private Helpers helpers;
    Functions functions;
    public RegisterPage(WebDriver driver){
        this.helpers=new Helpers(driver);
        this.functions=new Functions(driver);
    }
    public void setDriver(WebDriver driver){
        this.helpers=new Helpers(driver);
        this.functions=new Functions(driver);
    }
    @FindBy(css = "span.male > label")
    WebElement maleRadioButton;

    @FindBy(css = "span.female > label")
    WebElement femaleRadioButton;

    @FindBy(id = "FirstName")
    WebElement firstnameTextBox;

    @FindBy(id = "LastName")
    WebElement lastnameTextBox;

    @FindBy(name = "DateOfBirthDay")
    WebElement daySelectlist;

    @FindBy(name = "DateOfBirthMonth")
    WebElement monthSelectList;

    @FindBy(name = "DateOfBirthYear")
    WebElement yearSelectList;

    @FindBy(id = "Email")
    WebElement emailTextBox;

    @FindBy(id = "Company")
    WebElement companyTextBox;

    @FindBy(id = "Newsletter")
    WebElement newsletterCheckBox;

    @FindBy(id = "Password")
    WebElement passwordTextBox;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordTextBox;

    @FindBy(id = "register-button")
    WebElement completeRegisterButton;

    @FindBy(className = "result")
    WebElement registerResultTextElement;

    public WebElement getMaleRadioButton() {
        return maleRadioButton;
    }

    public WebElement getFemaleRadioButton() {
        return femaleRadioButton;
    }

    public WebElement getFirstnameTextBox() {
        return firstnameTextBox;
    }

    public WebElement getLastnameTextBox() {
        return lastnameTextBox;
    }

    public WebElement getDaySelectList() {
        return daySelectlist;
    }

    public WebElement getMonthSelectList() {
        return monthSelectList;
    }

    public WebElement getYearSelectList() {
        return yearSelectList;
    }

    public WebElement getEmailTextBox() {
        return emailTextBox;
    }

    public WebElement getCompanyTextBox() {
        return companyTextBox;
    }

    public WebElement getNewsletterCheckBox() {
        return newsletterCheckBox;
    }

    public WebElement getPasswordTextBox() {
        return passwordTextBox;
    }

    public WebElement getConfirmPasswordTextBox() {
        return confirmPasswordTextBox;
    }

    public WebElement getCompleteRegisterButton() {
        return completeRegisterButton;
    }

    public WebElement getRegisterResultTextElement() {
        return registerResultTextElement;
    }

    public void registerNewUser(String gender, String emri,String mbiemri,String dita,String muaj,String viti, String email, String company,boolean getNews, String password) throws InterruptedException {
        if (gender.equals("f")||gender.equals("F")) {
            helpers.clickElement(femaleRadioButton);
        }else{
            helpers.clickElement(maleRadioButton);
        }
        helpers.sendKeys(firstnameTextBox,emri);
        helpers.sendKeys(lastnameTextBox,mbiemri);
        helpers.selectByVisibleText(daySelectlist,dita);
        helpers.selectByVisibleText(monthSelectList,muaj);
        helpers.selectByVisibleText(yearSelectList,viti);
        helpers.sendKeys(emailTextBox,email);
        helpers.sendKeys(companyTextBox,company);
        if(getNews!=helpers.isElementSelected(newsletterCheckBox)){
            helpers.clickElement(newsletterCheckBox);
        }
        helpers.sendKeys(passwordTextBox,password);
        helpers.sendKeys(confirmPasswordTextBox,password);
        helpers.clickElement(completeRegisterButton);
    }

    public void verifyRegisterProcessWasSuccessful(){
        helpers.assertElementHasText(registerResultTextElement,"Your registration completed");
    }

}
