package cn.ecust.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @Description
 * @Author chris
 * @Date 2022/7/13, 01:09
 */
public class ChainActionUtil {

    private static volatile ChainActionUtil instance;

    private static WebDriver driver;

    public static ChainActionUtil init(WebDriver inputDriver) {
        driver = inputDriver;
        return getInstance();
    }

    public static ChainActionUtil getInstance() {
//        synchronized (ChainActionUtil.class) {
        if (instance == null) {
            instance = new ChainActionUtil();
        }
        return instance;
//        }
    }

    public ChainActionUtil Click(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
        return instance;
    }
}
