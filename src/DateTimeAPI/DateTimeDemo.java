package DateTimeAPI;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.TemporalAdjusters;

public class DateTimeDemo {

    public static void main(String[] args) {

        // Local Date
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.toString());                //2013-05-15
        System.out.println(localDate.getDayOfWeek().toString()); //WEDNESDAY
        System.out.println(localDate.getDayOfMonth());           //15
        System.out.println(localDate.getDayOfYear());            //135
        System.out.println(localDate.isLeapYear());              //false
        System.out.println(localDate.plusDays(12).toString());   //2013-05-27

        // Time
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime.toString());    //12:20
        System.out.println(localTime.getHour());     //12
        System.out.println(localTime.getMinute());   //20
        System.out.println(localTime.getSecond());   //0
        System.out.println(localTime.MIDNIGHT);      //00:00
        System.out.println(localTime.NOON);          //12:00

        // Date and Time
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.toString());      //2013-05-15T10:01:14.911
        System.out.println(localDateTime.getDayOfMonth()); //15
        System.out.println(localDateTime.getHour());       //10
        System.out.println(localDateTime.getNano());       //911000000

        // Specific Local Date
        // LocalDate lds = LocalDate.of(2001,02,28);
        LocalDate lds = LocalDate.of(2001,Month.FEBRUARY,28);
        System.out.println(lds);

        // Format Date and Time
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String strDate = lds.format(dtf);
        System.out.println(strDate);

        DateTimeFormatterBuilder formatterBuilder = new DateTimeFormatterBuilder();
        formatterBuilder.append(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                .appendLiteral(':')
                .appendZoneOrOffsetId();
        DateTimeFormatter formatter = formatterBuilder.toFormatter();
        System.out.println(formatter.format(ZonedDateTime.now()));

        // Parse String Date
        LocalDate parsedDate = LocalDate.parse(strDate, dtf);
        System.out.println(parsedDate);

        // Select TimeZone
        ZonedDateTime zdt = ZonedDateTime.now();
        System.out.println(zdt);

        // Select Other TimeZone
        ZonedDateTime ist = LocalDateTime.now().atZone(ZoneId.of("Asia/Kolkata"));
        ZonedDateTime IST1 = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println(ist);
        System.out.println(IST1);

        // Offset
        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        System.out.println(offsetDateTime.toString());              //2013-05-15T10:10:37.257+05:30

        offsetDateTime = OffsetDateTime.now(ZoneId.of("+05:30"));
        System.out.println(offsetDateTime.toString());              //2013-05-15T10:10:37.258+05:30

        offsetDateTime = OffsetDateTime.now(ZoneId.of("-06:30"));
        System.out.println(offsetDateTime.toString());              //2013-05-14T22:10:37.258-06:30

        ZonedDateTime zonedDateTime =
                ZonedDateTime.now(ZoneId.of("Europe/Paris"));
        System.out.println(zonedDateTime.toString());               //2013-05-15T06:45:45.290+02:00[Europe/Paris]

        // Instant
        Instant instant = Instant.now();
        System.out.println(instant.toString());                                 //2013-05-15T05:20:08.145Z
        System.out.println(instant.plus(Duration.ofMillis(5000)).toString());   //2013-05-15T05:20:13.145Z
        System.out.println(instant.minus(Duration.ofMillis(5000)).toString());  //2013-05-15T05:20:03.145Z
        System.out.println(instant.minusSeconds(10).toString());                //2013-05-15T05:19:58.145Z

        //  when was given day in current week
        System.out.println(localDate.with(DayOfWeek.MONDAY));  //2013-05-13  i.e. when was monday in current week ?

        // Date adjusters
        LocalDate date = LocalDate.of(2013, Month.MAY, 15);                     //Today
        LocalDate endOfMonth = date.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(endOfMonth.toString());                              //2013-05-31
        LocalDate nextTue = date.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
        System.out.println(nextTue.toString());                                 //2013-05-21

        /* Get Available zones
        for (String zones : ZoneId.getAvailableZoneIds())
            System.out.println(zones); */
    }
}
