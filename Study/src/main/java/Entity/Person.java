package Entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private Integer age;

    public void print(Person person){
        System.out.println(person.getName());
        System.out.println(person.getAge());
    }
}
