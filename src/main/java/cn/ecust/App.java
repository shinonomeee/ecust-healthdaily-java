package cn.ecust;

import cn.ecust.action.HealthDailyAction;
import cn.ecust.constants.ActionType;
import cn.ecust.factory.HDActionFactory;

/**
 * @Description
 * @Author chris
 * @Date 2022/5/3, 01:02
 */
public class App {
    public static void main(String[] args) {
        HDActionFactory actionFactory = new HDActionFactory();
        HealthDailyAction action = actionFactory.getAction(ActionType.TIMING_MUTI_THREAD);
        action.fillIn();
    }
}
