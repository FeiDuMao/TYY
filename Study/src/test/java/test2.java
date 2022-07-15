import Entity.Person;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Optional;

/**
 * @Date 2022/7/14 10:00
 * @Created by taoyuanyuan
 */
public class test2 {


    @Test
    public void test() {

        Optional<Person> optionalPerson = Optional.ofNullable(new Person("tyy",1,1, LocalDate.now()));

        Optional<Integer> integer = optionalPerson.map(Person::getId);

        if (integer.isPresent()) {
            System.out.println(integer.get());
        }else {
            System.out.println("111");
        }


    }

}
