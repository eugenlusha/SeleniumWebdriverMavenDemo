package com.sample.www.Functions;
import com.sample.www.helpers.Helpers;
import com.sample.www.nopCommerce.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Functions {
    WebDriver driver;
    WebDriverWait waiter;

    public Functions(WebDriver driver){
        this.driver=driver;
        this.waiter=new WebDriverWait(driver,5);
    }

    public double parseToDoubleFromString(String str){
        char c=0;
        String value="";
        for(int i=0;i<str.length();i++){
            c=str.charAt(i);
            if(Character.isDigit(c)){
                value=value+c;
            }
        }
        return Double.parseDouble(value);
    }




}
