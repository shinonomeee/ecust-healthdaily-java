package cn.ecust.action;


import cn.ecust.utils.FileHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.management.RuntimeErrorException;

import java.text.SimpleDateFormat;
import java.util.Date;

import static cn.ecust.constants.Info.*;

public abstract class HealthDailyAction implements FileHelper {

    public abstract void fillIn();

    protected void completeFillIn(String user, String pwd) {
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String finalOutPut = date + fillInWithUserAndPwd(user, pwd) + '\n';
        FileHelper.logWriter(finalOutPut);
        System.out.println(finalOutPut);
    }

    private String fillInWithUserAndPwd(String user, String pwd) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get(loginURL);
        } catch (RuntimeErrorException e) {
            return " ERROR: RuntimeErrorException occurs while getting loginURL";
        }
        try {
            driver.findElement(By.id("username")).sendKeys(user);
            driver.findElement(By.id("password")).sendKeys(pwd);
            driver.findElement(By.xpath(loginButton)).click(); // 点击登录按钮
        } catch (NoSuchElementException e) {
            return " ERROR: Element Not Found";
        }
        try {
            driver.get(fillinURL);
        } catch (RuntimeErrorException e) {
            return " ERROR: RuntimeErrorException occurs while getting fillinURL";
        }
        try {
            driver.findElement(By.xpath(flagButton)).click();             // 点击填写按钮
        } catch (ElementNotInteractableException e) {
            driver.close();
            return " INFO: " + user + ": Requirement Already Satisfied!";
        }
        try {
            driver.findElement(By.xpath(location.get(user))).click();   // 根据用户学号去哈希表里搜，因此如果添加新的用户需要修改此处
            driver.findElement(By.xpath(tripCode)).click();
            driver.findElement(By.xpath(outOrNot)).click();
            driver.findElement(By.xpath(submit)).click();
            driver.findElement(By.xpath(confirmSubmit)).click();
            driver.findElement(By.xpath(finalConfirm)).click();
        } catch (NoSuchElementException e) {
            return " ERROR: Elements' Xpath Might have been changed";
        }
        driver.close();
        return " INFO: " + user + ": Successfully Fillin!";
    }
}
