package Spring;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @Classname A
 * @Date 2022/4/19 18:32
 * @Created by taoyuanyuan
 */
public class A {

    B b;

    public A() {
        this.b = new B();
    }

    public void print(){
        System.out.println("AAAAA");
    }



}
