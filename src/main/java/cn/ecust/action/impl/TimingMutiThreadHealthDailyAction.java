package cn.ecust.action.impl;

import cn.ecust.utils.TimeUtil;

/**
 * @Description 计时的多线程填报
 * @Author chris
 * @Date 2022/5/22, 13:26
 */
public class TimingMutiThreadHealthDailyAction extends MutiThreadHealthDailyAction {

    private static final int hour = 0;

    private static final int min = 0;

    private static final int sec = 0;

    @Override
    public void fillIn() {
        // 等到指定时间执行
        while (!TimeUtil.timeTrigger(hour, min, sec)) {
        }
        super.fillIn();
    }
}
