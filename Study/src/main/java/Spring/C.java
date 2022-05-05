package Spring;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.junit.Test;

/**
 * @Classname C
 * @Date 2022/4/19 18:28
 * @Created by taoyuanyuan
 */
public class C {

    A a;

    public C() {
        this.a = new A();
    }

    public void print() {
        System.out.println("cccccc");
    }

    public void test(){
        a.print();
    }

}
