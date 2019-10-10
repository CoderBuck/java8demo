package me.buck.java8demo.share;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

/**
 * Created by gwf on 2019/10/10
 */
public class Java8TimeApi {

    /**
     * Instant  时间戳
     *
     * LocalDate
     * LocalTime
     * LocalDateTime 本地日期时间
     *
     * Duration  时间间隔，时间段： 秒
     * Period    时间间隔，时间段： 年月日
     *
     * @param args
     */

    public static void main(String[] args) {
        // minSdkVersion 26
        //System.out.println("Instant.now() = " + Instant.now());
        //System.out.println("LocalDate.now() = " + LocalDate.now());
        //System.out.println("LocalTime.now() = " + LocalTime.now());
        //System.out.println("LocalDateTime.now() = " + LocalDateTime.now());
        //
        //LocalDateTime localDateTime = LocalDateTime.now();
        //int year = localDateTime.getYear();
        //Month month = localDateTime.getMonth();
        //int day = localDateTime.getDayOfMonth();
        //
        //int hour = localDateTime.getHour();
        //String format = String.format("year = %s, month = %s, day = %s", year, month.getValue(), day);
        //System.out.println(format);
        //
        //String format1 = localDateTime.format(DateTimeFormatter.ofPattern("yyyy -- MM -- dd -- HH -- mm -- ss"));
        //System.out.println(format1);


        //localDataTime();
        //durationTest();
        //dateTimeFormatter();
        //zone();
    }

    static void instantTest() {
        System.out.println("Instant.now() = " + Instant.now());
    }

    static void localDataTime() {
        LocalDate now = LocalDate.now();
        LocalDate with = now.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        System.out.println(with);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(" localDateTime = " + localDateTime);

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(" zonedDateTime = " + zonedDateTime);


        OffsetDateTime offsetDateTime = Instant.now().atOffset(ZoneOffset.of("+8:00"));
        System.out.println(" offsetDateTime = " + offsetDateTime);
    }

    static void durationTest() {
        LocalDateTime start = LocalDateTime.of(1993, 4, 14, 8, 8, 8);
        LocalDateTime end = LocalDateTime.of(2019, 10, 10, 8, 8, 9);

        Duration duration = Duration.between(start, end);
        System.out.println(duration);
        System.out.println(duration.toDays());

        Period period = Period.between(start.toLocalDate(), end.toLocalDate());
        System.out.println("period = " + period);
        System.out.println("period getYears = " + period.getYears());
        System.out.println("period getMonths = " + period.getMonths());
        System.out.println("period getDays = " + period.getDays());

    }

    static void dateTimeFormatter() {

        LocalDateTime dateTime = LocalDateTime.now();
        String strDate1 = dateTime.format(DateTimeFormatter.BASIC_ISO_DATE);    // 20170105
        String strDate2 = dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE);    // 2017-01-05
        String strDate3 = dateTime.format(DateTimeFormatter.ISO_LOCAL_TIME);    // 14:20:16.998
        String strDate4 = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));   // 2017-01-05
        String strDate5 = dateTime.format(DateTimeFormatter.ofPattern("今天是：yyyy年 MMMM dd日 E", Locale.CHINESE));

        System.out.println(strDate1);
        System.out.println(strDate2);
        System.out.println(strDate3);
        System.out.println(strDate4);
        System.out.println(strDate5);
    }

    static void zone() {
        ZoneId.getAvailableZoneIds().forEach(System.out::println);
    }
}
