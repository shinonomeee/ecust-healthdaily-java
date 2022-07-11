package cn.ecust.action;


import cn.ecust.utils.FileHelper;
import cn.ecust.utils.FillInUtil;

public interface HealthDailyAction extends FileHelper, FillInUtil {

    void fillIn();

}
