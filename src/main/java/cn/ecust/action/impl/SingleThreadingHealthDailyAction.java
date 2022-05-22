package cn.ecust.action.impl;

import cn.ecust.action.HealthDailyAction;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import static cn.ecust.constants.Info.*;

/**
 * @Description 单线程填报
 * @Author chris
 * @Date 2022/5/17, 12:52
 */
@Slf4j
public class SingleThreadingHealthDailyAction extends HealthDailyAction {
    @Override
    public void fillIn() {
        if (StringUtils.isAnyBlank(defaultUser, defaultPwd)) {
            log.error("No default user or password!");
            return;
        }
        completeFillIn(defaultUser, defaultPwd);
    }

}
