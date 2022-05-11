package cn.ecust.action;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.management.RuntimeErrorException;

import static cn.ecust.constants.Info.*;

public interface HealthDailyAction {

    static void fillinAction(String user, String pwd) throws WebDriverException {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get(loginURL);
        } catch (RuntimeErrorException e) {
            throw new WebDriverException("RuntimeErrorException occurs while getting loginURL");
        }
        try {
            driver.findElement(By.id("username")).sendKeys(user);
            driver.findElement(By.id("password")).sendKeys(pwd);
            driver.findElement(By.xpath(loginButton)).click(); // 点击登录按钮
        } catch (NoSuchElementException e) {
            throw new WebDriverException("Element Not Found");
        }
        try {
            driver.get(fillinURL);
        } catch (RuntimeErrorException e) {
            throw new WebDriverException("RuntimeErrorException occurs while getting fillinURL");
        }
        try {
            driver.findElement(By.xpath(flagbutton)).click();             // 点击填写按钮
        } catch (ElementNotInteractableException e) {
            driver.close();
            System.out.println("[user]" + user + ": Requirement Already Satisfied!");
            return;
        }
        try {
            interactiveElements.forEach(x -> driver.findElement(By.xpath(x)).click()); // 点击交互元素
        } catch (NoSuchElementException e) {
            throw new WebDriverException("Elements' Xpath Might have been changed");
        }
        driver.close();
        System.out.println("[user]" + user + ": Successfully Fillin!");
    }
    static void MultithreadingAction() {
        for (int i = 0; i < userInfos.length; ++i) {
            final int no = i;
            new Thread(() -> fillinAction(userInfos[no][0], userInfos[no][1])).start();
        }
    }
}
