package cn.ecust.action.impl;

import cn.ecust.action.HealthDailyAction;

import static cn.ecust.constants.Info.userInfos;

/**
 * @Description 多线程填报
 * @Author chris
 * @Date 2022/5/18, 00:35
 */
public class MutiThreadHealthDailyAction implements HealthDailyAction {
    @Override
    public void fillIn() {
        for (int i = 0; i < userInfos.length; ++i) {
            final int no = i;
            new Thread(() -> completeFillIn(userInfos[no][0], userInfos[no][1])).start();
        }
    }
}
