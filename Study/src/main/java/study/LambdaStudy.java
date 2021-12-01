package study;

import Entity.ListNode;
import Entity.Person;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 表达式的参数类型与调用者的类型相同
 * 当参数只有一个时，可以省略（）
 * 当函数体只有一句时，可以同时省略 {}和return
 * <p>
 * 四大基础函数式接口：
 * 消费型接口：consumer<T>：  void accept(T t)   接收T类型，执行操作，没有返回值
 * 供给型接口：supplier<T>：  T get()            没有参数，执行操作，返回T类型
 * 函数型接口：function<T,R>：R apply(T t)       接收T类型，执行操作，返回R类型
 * 断定型接口：predicate<T>： boolean test(T t)  接收T类型，执行操作，返回boolean类型
 */
public class LambdaStudy {

    @Test
    public void consumer() {


        Map<Integer, String> map = Maps.newHashMap();
        /**
         * forEach是一种消费型接口，接受参数，进行操作
         */
        map.forEach((k, v) -> {
            //do something
            System.out.println(k + ": " + v);
        });

    }

    @Test
    public void predicateAndSupplier() {
        List<String> strings = Lists.newArrayList("a", "b", "c");


        /**
         * stream中的filter是一种断定型接口，根据指定规则进行过滤
         *          collect是一种供给型接口
         */
        List<String> a1 = strings.stream()
                .filter(s -> s.startsWith("a"))
                .collect(Collectors.toList());

    }

    @Test
    public void methodReference() {
        List<String> strings = Lists.newArrayList("a", "b", "c");
        /**
         * 方法引用：当要传递给lambda体进行操作时，已经有实现方法了，可以使用方法引用 eg：System.out::print
         * 注意：方法的参数要与表达式的参数类型相同！！
         * 对象::非静态方法
         * 类::非静态方法名
         * 类::静态方法名
         */
        //strings.forEach(s->System.out.println(s));
        strings.forEach(System.out::println);

        List<Person> list = Lists.newArrayList(new Person("tyy", 10), new Person("aa", 12));
        list.forEach(var_name -> {
            System.out.println(var_name.getName());
            System.out.println(var_name.getAge());
        });

        //对象::非静态方法
        Person person = new Person();
        list.forEach(person::print);
        //List to Map
        Map<String, Integer> maps = list.stream()
                .collect(Collectors.toMap(Person::getName, Person::getAge));
        maps.forEach((k, v) -> System.out.println(k + ": " + v));

        /**
         * Function<Double,Long>func=d->Math.round(d);
         * Math.round的参数类型和返回类型和fun1相同
         * 所以可以简写成下列式子
         */
        Function<Double, Long> func = Math::round;
        System.out.println(func.apply(10.2));


        /**
         * 构造器引用
         * Supplier<Person>fun=()->new Person();
         * Supplier<Person>fun2=Person::new;
         */
        Map<String, Integer> map = Maps.newHashMap();
        map.put("tyy", 18);
        List<Map<String, Integer>> list2 = Lists.newArrayList(map);


        /**
         * 类::非静态方法
         * Function<Person,String>fun=person->person.getName();
         * Function<Person,String>fun3=Person::getName;
         *
         */

        /**
         * BiPredicate<String,String>func2=(s1,s2)->s1.equals(s2);
         * BiPredicate<String,String>func3=String::equals;
         */


    }


}
