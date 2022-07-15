package Entity;

import lombok.*;
import org.checkerframework.checker.units.qual.A;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Data
public class Person{
    private String name;
    private Integer age;
    private Integer id;
    private LocalDate birth;

    public Person(String name, LocalDate birth) {
        this.name = name;
        this.birth = birth;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }


    public void print(Person person){
        System.out.println(person.getName());
        System.out.println(person.getAge());
    }


    public static int compareByAge(Person o1, Person o2) {
        return o1.getAge().compareTo(o2.getAge());
    }
    public static int compareById(Person o1, Person o2) {
        return o1.getId().compareTo(o2.getId());
    }
    public static int compareByDate(Person o1, Person o2) {
       return o1.getBirth().compareTo(o2.getBirth());
    }
}
