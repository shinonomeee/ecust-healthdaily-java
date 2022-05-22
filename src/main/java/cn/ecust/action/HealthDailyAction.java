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
        FileHelper.logWriter(date + fillInWithUserAndPwd(user, pwd) + '\n');
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
            driver.findElement(By.xpath(flagbutton)).click();             // 点击填写按钮
        } catch (ElementNotInteractableException e) {
            driver.close();
            return " INFO: " + user + ": Requirement Already Satisfied!";
        }
        try {
            interactiveElements.forEach(x -> driver.findElement(By.xpath(x)).click()); // 点击交互元素
        } catch (NoSuchElementException e) {
            return " ERROR: Elements' Xpath Might have been changed";
        }
        driver.close();
        return " INFO: " + user + ": Successfully Fillin!";
    }
}
