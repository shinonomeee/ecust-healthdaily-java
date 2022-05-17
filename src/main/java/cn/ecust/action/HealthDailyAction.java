package cn.ecust.action;

import cn.ecust.exception.WebContextException;

public interface HealthDailyAction {

    void fillinAction(String user, String pwd) throws WebContextException;

    void MultithreadingAction();
}
