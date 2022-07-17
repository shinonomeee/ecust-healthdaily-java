package cn.ecust.action.impl;

import cn.ecust.action.HealthDailyAction;
import cn.ecust.utils.FillInUtil;
import cn.ecust.utils.JSONUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description 单线程填报
 * @Author chris
 * @Date 2022/5/17, 12:52
 */
@Slf4j
public class SingleThreadHealthDailyAction extends BasicFillInAction {
    @Override
    public void fillIn() {
        JSONUtil.getUsers().forEach(super::completeFillIn);
    }

}
