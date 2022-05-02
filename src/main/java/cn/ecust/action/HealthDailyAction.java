package cn.ecust.action;

import cn.ecust.constants.error.ErrorType;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.management.RuntimeErrorException;

import static cn.ecust.constants.Info.*;

public final class HealthDailyAction {
    private HealthDailyAction() {}

    public static ErrorType fillinAction(String user, String pwd) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get(loginURL);
        } catch (RuntimeErrorException e) {
            return ErrorType.RuntimeError_Login;
        }
        try {
            driver.findElement(By.id("username")).sendKeys(user);
            driver.findElement(By.id("password")).sendKeys(pwd);
            driver.findElement(By.xpath(loginButton)).click(); // 点击登录按钮
        } catch (NoSuchElementException e) {
            return ErrorType.NoSuchElement;
        }
        try {
            driver.get(fillinURL);
        } catch (RuntimeErrorException e) {
            return ErrorType.RuntimeError_Fillin;
        }
        try {
            driver.findElement(By.xpath(flagbutton)).click();             // 点击填写按钮
        } catch (ElementNotInteractableException e) {
            driver.close();
            return ErrorType.ElementNotInteractable;
        }
        try {
            interactiveElements.forEach(x -> driver.findElement(By.xpath(x)).click()); // 点击交互元素
        } catch (NoSuchElementException e) {
            return ErrorType.NoSuchElement_FillinButton;
        }
        driver.close();
        return ErrorType.SUCCESS;
    }
    public static void MultithreadingAction() throws InterruptedException {
        for (int i = 0; i < userInfos.length; ++i) {
            final int no = i;
            new Thread(() -> {
                switch (fillinAction(userInfos[no][0], userInfos[no][1])) {
                    case SUCCESS:
                        System.out.println("[user]" + userInfos[no][0] + ": Successfully Fillin!");
                        break;
                    case ElementNotInteractable:
                        System.out.println("[user]" + userInfos[no][0] + ": Requirement Already Satisfied!");
                        break;
                    case NoSuchElement_FillinButton:
                        System.out.println("Elements' Xpath Might have been changed, plaese check!");
                        break;
                    case RuntimeError_Login:
                        System.out.println("RuntimeErrorException occurs while getting loginURL, please check!");
                        break;
                    case NoSuchElement:
                        System.out.println("Element Not Found!");
                        break;
                    case RuntimeError_Fillin:
                        System.out.println("RuntimeErrorException occurs while getting fillinURL, please check!");
                        break;
                    default:
                        System.out.println("Unknown ERROR!");
                        break;
            }
            }).start();
        }
    }
}
