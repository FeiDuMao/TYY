package study;

import Entity.Person;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Date 2022/10/8 11:03
 * @Created by taoyuanyuan
 */
public class ObjectStudy {


//    @Test
    public void test() {

        Person origin = new Person("tyy", 10);

        Person clone = origin.clone();

        System.out.println(origin);
        System.out.println(clone);
        System.out.println(origin.hashCode());
        System.out.println(clone.hashCode());


        Assert.assertEquals(origin, clone);
        Assert.assertEquals(origin.hashCode(), clone.hashCode());


    }


}
