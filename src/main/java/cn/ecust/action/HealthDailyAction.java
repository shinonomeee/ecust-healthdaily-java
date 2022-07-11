package cn.ecust.action;


import cn.ecust.utils.FileHelper;
import cn.ecust.utils.FillInUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.management.RuntimeErrorException;

import java.text.SimpleDateFormat;
import java.util.Date;

import static cn.ecust.constants.Info.*;

public interface HealthDailyAction extends FileHelper, FillInUtil {

    void fillIn();

}
