package cn.ecust.utils;

import cn.ecust.entity.User;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.management.RuntimeErrorException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static cn.ecust.constants.Info.*;

/**
 * @Description
 * @Author chris
 * @Date 2022/7/9, 00:01
 */
public class FillInUtil {

    public static void completeFillIn(User user) {
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String finalOutPut = date + fillInWithUserAndPwd(user) + '\n';
        FileHelper.logWriter(finalOutPut);
        System.out.println(finalOutPut);
    }

    private static String fillInWithUserAndPwd(User user) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get(loginURL);
        } catch (RuntimeErrorException e) {
            return " ERROR: RuntimeErrorException occurs while getting loginURL";
        }
        try {
            driver.findElement(By.id("username")).sendKeys(user.getAccount());
            driver.findElement(By.id("password")).sendKeys(user.getPassword());
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
            return " INFO: " + user.getAccount() + ": Requirement Already Satisfied!";
        }
        try {
            ChainActionUtil.init(driver)
                    .Click(location.get(user.getLocation()))  // 根据用户位置去哈希表里搜
                    .Click(tripCode)
                    .Click(outOrNot)
                    .Click(submit)
                    .Click(confirmSubmit)
                    .Click(finalConfirm);
        } catch (NoSuchElementException e) {
            return " ERROR: Elements' Xpath Might have been changed";
        }
        driver.close();
        return " INFO: " + user.getAccount() + ": Successfully Fillin!";
    }
}
