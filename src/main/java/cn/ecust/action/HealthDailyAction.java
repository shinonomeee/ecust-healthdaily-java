package cn.ecust.action;


import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.management.RuntimeErrorException;

import static cn.ecust.constants.Info.*;

@Slf4j
public abstract class HealthDailyAction {

    public abstract void fillin();

    protected void fillinWithUserAndPwd(String user, String pwd) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get(loginURL);
        } catch (RuntimeErrorException e) {
            log.error("RuntimeErrorException occurs while getting loginURL");
            return;
        }
        try {
            driver.findElement(By.id("username")).sendKeys(user);
            driver.findElement(By.id("password")).sendKeys(pwd);
            driver.findElement(By.xpath(loginButton)).click(); // 点击登录按钮
        } catch (NoSuchElementException e) {
            log.error("Element Not Found");
            return;
        }
        try {
            driver.get(fillinURL);
        } catch (RuntimeErrorException e) {
            log.error("RuntimeErrorException occurs while getting fillinURL");
            return;
        }
        try {
            driver.findElement(By.xpath(flagbutton)).click();             // 点击填写按钮
        } catch (ElementNotInteractableException e) {
            driver.close();
            log.info(user + ": Requirement Already Satisfied!");
            return;
        }
        try {
            interactiveElements.forEach(x -> driver.findElement(By.xpath(x)).click()); // 点击交互元素
        } catch (NoSuchElementException e) {
            log.error("Elements' Xpath Might have been changed");
            return;
        }
        driver.close();
        log.info(user + ": Successfully Fillin!");
    }
}
