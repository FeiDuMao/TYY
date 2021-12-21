package normal;

import Entity.Person;
import com.sun.tools.javac.util.StringUtils;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.TemporalField;
import java.util.Date;

public class Hello {
    public static void main(String[] args) {

        String s = "fd6507a5-561b-471d-9c59-7d3c7c238c6b?_t=1639559238257";
        String substring = s.substring(0, s.indexOf('?'));
        System.out.println(substring);


    }


    @Test
    public void test(){

        LocalDate parse = LocalDate.parse("2004-01-01");
        LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        parse.plusDays(3);
        System.out.println(parse);


        LocalDate start = LocalDate.parse("2020-01-01");
        LocalDate now = LocalDate.now();

        long year,month,day;
        long days = Duration.between(start.atStartOfDay(), now.atStartOfDay()).toDays();

        days=375;

        long l = Long.parseLong("1102176000000");
        LocalDate date = LocalDateTime.ofInstant(Instant.ofEpochMilli(l), ZoneId.systemDefault()).toLocalDate();
        System.out.println(date);

        System.out.println(parse.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());

    }


    @Test
    public void test2(){
        LocalDate now = LocalDate.now();

        System.out.println(now.getDayOfYear());
        System.out.println(now.getDayOfMonth());
        System.out.println(now.getDayOfWeek().getValue());

        System.out.println(now.minusDays(20));
        System.out.println(now.minusDays(1));

        System.out.println(now.minusDays(90));

        System.out.println(now.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
    }




}
