package cn.ecust.action.impl;

import cn.ecust.utils.JSONUtil;

/**
 * @Description 单线程填报
 * @Author chris
 * @Date 2022/5/17, 12:52
 */
public class SingleThreadHealthDailyAction extends BasicFillInAction {
    @Override
    public void fillIn() {
        JSONUtil.getUsers().forEach(super::completeFillIn);
    }

}
