package Spring;

import lombok.AllArgsConstructor;

/**
 * @Classname B
 * @Description TODO
 * @Date 2022/4/19 18:27
 * @Created by taoyuanyuan
 */

public class B {

    public B() {
        this.c = new C();
    }

    C c;

    public void print(){
        System.out.println("BBBBB");
    }






}
