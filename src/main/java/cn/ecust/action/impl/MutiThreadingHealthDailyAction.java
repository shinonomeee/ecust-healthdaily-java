package cn.ecust.action.impl;

import cn.ecust.action.HealthDailyAction;

import static cn.ecust.constants.Info.userInfos;

/**
 * @Description
 * @Author chris
 * @Date 2022/5/18, 00:35
 */
public class MutiThreadingHealthDailyAction extends HealthDailyAction {
    @Override
    public void fillin() {
        for (int i = 0; i < userInfos.length; ++i) {
            final int no = i;
            new Thread(() -> fillinWithUserAndPwd(userInfos[no][0], userInfos[no][1])).start();
        }
    }
}
