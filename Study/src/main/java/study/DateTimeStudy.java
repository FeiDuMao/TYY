package study;

import lombok.SneakyThrows;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @Date 2022/7/1 10:32
 * @Created by taoyuanyuan
 */
public class DateTimeStudy {




    @Test
    @SneakyThrows
    public void test(){

        LocalDateTime now = LocalDateTime.now();
        LocalDate localDate = now.toLocalDate();
        long epochMilli = localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
        Date date = new Date(epochMilli);
        LocalDate ofInstant = LocalDate.ofInstant(Instant.ofEpochMilli(epochMilli), ZoneId.systemDefault());


        System.out.println(epochMilli);
        System.out.println(date);
        System.out.println(localDate);
        System.out.println(ofInstant);


    }





}
