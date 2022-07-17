package cn.ecust.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @Description 实现steam编程，使语法更为简洁
 * @Author chris
 * @Date 2022/7/13, 01:09
 */
public class ChainActionUtil {

    /**
     * 单例
     */
    private static volatile ChainActionUtil instance;

    private static WebDriver driver;

    /**
     * @Description chain初始化，初始化driver，避免生成多余对象
     * @param inputDriver WebDriver
     * @return 类本身
     * @Author chris
     */
    public static ChainActionUtil init(WebDriver inputDriver) {
        driver = inputDriver;
        return getInstance();
    }

    /**
     * 考虑多线程环境，需要加锁
     * @return 类本身
     * @Author chris
     */
    public static ChainActionUtil getInstance() {
//        synchronized (ChainActionUtil.class) {
        if (instance == null) {
            instance = new ChainActionUtil();
        }
        return instance;
//        }
    }

    /**
     * 点按动作
     * @param xpath 元素的xpath位置
     * @return 类本身
     * @Author chris
     */
    public ChainActionUtil Click(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
        return instance;
    }
}
