package cn.ecust;

import cn.ecust.action.impl.TimingMutiThreadHealthDailyAction;

/**
 * @Description
 * @Author chris
 * @Date 2022/5/3, 01:02
 */
public class App {
    public static void main(String[] args) {
        new TimingMutiThreadHealthDailyAction().fillIn();
    }
}
