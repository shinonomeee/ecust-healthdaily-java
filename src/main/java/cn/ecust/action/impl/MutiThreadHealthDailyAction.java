package cn.ecust.action.impl;

import cn.ecust.action.HealthDailyAction;
import cn.ecust.entity.User;
import cn.ecust.utils.FillInUtil;
import cn.ecust.utils.JSONUtil;

import java.util.List;


/**
 * @Description 多线程填报
 * @Author chris
 * @Date 2022/5/18, 00:35
 */
public class MutiThreadHealthDailyAction implements HealthDailyAction {
    @Override
    public void fillIn() {
        List<User> users = JSONUtil.getUsers();
        users.forEach(
                user -> new Thread(() -> FillInUtil.completeFillIn(user)).start()
        );
    }
}
