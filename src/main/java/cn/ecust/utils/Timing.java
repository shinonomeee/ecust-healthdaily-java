package cn.ecust.utils;

import java.util.Calendar;

/**
 * @Description 单独创建Timing接口是为了更好的扩展性
 * @Author chris
 * @Date 2022/5/22, 23:11
 */
public interface Timing {

    static boolean timeTrigger(int hour, int minute, int second) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
        int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int currentMinute = Calendar.getInstance().get(Calendar.MINUTE);
        int currentSecond = Calendar.getInstance().get(Calendar.SECOND);
        return currentHour == hour && currentMinute == minute && currentSecond >= second;
    }

}
