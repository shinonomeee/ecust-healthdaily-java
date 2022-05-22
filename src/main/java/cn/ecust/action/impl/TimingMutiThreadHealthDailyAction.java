package cn.ecust.action.impl;

import cn.ecust.utils.Timing;

/**
 * @Description 计时的多线程填报
 * @Author chris
 * @Date 2022/5/22, 13:26
 */
public class TimingMutiThreadHealthDailyAction extends MutiThreadHealthDailyAction implements Timing {
    @Override
    public void fillIn() {
        // 等到指定时间执行
        while (!Timing.timeTrigger(0, 0, 0));

        super.fillIn();
    }
}
