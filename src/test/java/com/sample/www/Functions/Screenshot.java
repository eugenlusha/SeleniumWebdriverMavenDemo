package com.sample.www.Functions;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Screenshot {
    public static void captureScreenshot(WebDriver driver, String name){
        try{
            Date date=new Date();
            TakesScreenshot ts =(TakesScreenshot) driver;
            File source=ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/"+name+"_"+(date.getYear()-100)+"-"+(date.getMonth()+1)+"-"+date.getDay()+"_"+date.getHours()+"-"+date.getMinutes()+".png"));

            System.out.println("Screenshot was taken");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
