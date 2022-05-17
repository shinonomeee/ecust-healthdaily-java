package cn.ecust;

import cn.ecust.action.HealthDailyAction;
import cn.ecust.action.impl.HealthDailyActionImpl;

/**
 * @Description
 * @Author chris
 * @Date 2022/5/3, 01:02
 */
public class App {
    public static void main(String[] args) {
        HealthDailyAction healthDailyAction = new HealthDailyActionImpl();
        healthDailyAction.MultithreadingAction();
    }
}
