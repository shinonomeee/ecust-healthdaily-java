package cn.ecust.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @Description 实现steam编程，使语法更为简洁
 * @Author chris
 * @Date 2022/7/13, 01:09
 */
public class ChainActionUtil {

    private final WebDriver driver;

    /**
     *
     * @param inputDriver WebDriver
     */
    public ChainActionUtil(WebDriver inputDriver) {
        driver = inputDriver;
    }


    /**
     * 点按动作
     *
     * @param xpath 元素的xpath位置
     * @return 类本身
     * @Author chris
     */
    public ChainActionUtil Click(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
        return this;
    }
}
