package qian.xun.utils;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class TimeUtil {
    static final DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    static final DateTimeFormatter localTimeDf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private TimeUtil(){}

    public static String localDateTImeToString(LocalDateTime time){
        if(Objects.isNull(time)){
            time = LocalDateTime.now();
        }
        return  localTimeDf.format(time);
    }
    public static String localDateToString(LocalDate time){
        if(Objects.isNull(time)){
            time = LocalDate.now();
        }
        return  df.format(time);
    }
    public  static LocalDateTime toLocalDateTime(Date date){
        if(Objects.isNull(date)){
            return LocalDateTime.now();
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static Date fromLocalDateTime(LocalDateTime time){
        if(Objects.isNull(time)){
            time = LocalDateTime.now();
        }
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = time.atZone(zoneId);

        return (Date) Date.from(zdt.toInstant());
    }

    public static Date ofDate(long time){
        if(time<=0){
            time = System.currentTimeMillis();
        }
        return new Date(time);
    }
}
