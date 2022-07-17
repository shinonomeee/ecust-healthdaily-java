package cn.ecust.action.impl;

import cn.ecust.action.HealthDailyAction;
import cn.ecust.entity.User;
import cn.ecust.utils.ChainActionUtil;
import cn.ecust.utils.FileUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.management.RuntimeErrorException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static cn.ecust.constants.Info.*;
import static cn.ecust.constants.Info.finalConfirm;

/**
 * @Description TODO
 * @Author chris
 * @Date 2022/7/18, 04:09
 */
public class BasicFillInAction implements HealthDailyAction {

    @Override
    public void fillIn() {}

    protected void completeFillIn(User user) {
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String finalOutPut = date + fillInWithUserAndPwd(user) + '\n';
        FileUtil.logWriter(finalOutPut);
        System.out.println(finalOutPut);
    }

    private String fillInWithUserAndPwd(User user) {
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
