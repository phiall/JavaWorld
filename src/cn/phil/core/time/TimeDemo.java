package cn.phil.core.time;

import java.time.*;

/**
 * @author phil
 * @date 2021/7/7 17:25
 */
public class TimeDemo {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println(date);
        System.out.println(LocalTime.now());
        ZoneId zoneId = ZoneId.of("America/New_York");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
        System.out.println(zonedDateTime);
        System.out.println(0.3 == 3 * 0.1);
    }
}
