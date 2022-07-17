package cn.ecust.utils;

import java.util.Calendar;

/**
 * @Description 单独创建Timing接口是为了更好的扩展性
 * @Author chris
 * @Date 2022/5/22, 23:11
 */
public class TimeUtil {

    /**
     * 每次触发timeTrigger，程序就会等待一秒，并且进行判断
     * @param hour
     * @param minute
     * @param second
     * @return 是否满足该时段
     * @Author chris
     */
    public static boolean timeTrigger(int hour, int minute, int second) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
        int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int currentMinute = Calendar.getInstance().get(Calendar.MINUTE);
        int currentSecond = Calendar.getInstance().get(Calendar.SECOND);
        return currentHour <= hour + 12 && currentMinute >= minute && currentSecond >= second;
    }

}
