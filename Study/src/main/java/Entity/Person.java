package Entity;

import lombok.*;

import java.util.List;

@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {
    private String name;
    private Integer age;



    public void print(Person person){
        System.out.println(person.getName());
        System.out.println(person.getAge());
    }
}
