package study;

import Entity.Person;
import org.junit.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

public class OptionalStudy {

    @Test
    public void test(){


        System.out.println(Optional.ofNullable(new Person("tyy",20))
                .filter(person -> person.getAge()>10)
        );



    }

}
