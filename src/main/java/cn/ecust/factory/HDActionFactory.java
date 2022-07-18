package cn.ecust.factory;

import cn.ecust.action.HealthDailyAction;
import cn.ecust.action.impl.MutiThreadHealthDailyAction;
import cn.ecust.action.impl.SingleThreadHealthDailyAction;
import cn.ecust.action.impl.TimingMutiThreadHealthDailyAction;
import cn.ecust.constants.ActionType;

/**
 * @Description Action工厂
 * @Author chris
 * @Date 2022/7/18, 13:39
 */
public class HDActionFactory {

    public HealthDailyAction getAction(ActionType actionType) {
        switch (actionType) {
            case SINGLE_THREAD: {
                return new SingleThreadHealthDailyAction();
            }
            case MUTI_THREAD: {
                return new MutiThreadHealthDailyAction();
            }
            case TIMING_MUTI_THREAD: {
                return new TimingMutiThreadHealthDailyAction();
            }
        }
        return null;
    }

}
