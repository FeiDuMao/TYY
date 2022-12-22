package generic;

import lombok.SneakyThrows;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class GenericTest {


    /**
     * The term List<Number> is more restrictive than List<? extends Number>
     * because the former matches a list of type Number only,
     * whereas the latter matches a list of type Number or any of its subclasses.
     */
    @Test
    public void test0() {
        List<Level1> list1 = new ArrayList<>();
        List<Level2> list2 = new ArrayList<>();
        List<Level3> list3 = new ArrayList<>();
        List<? extends Level2> list4 = new ArrayList<>();


        list4 = list2;//通过编译，因为 List<Level2>  是 List<? extends Level2>的子类

        fooHelper(list4, 0);
        fooHelper(list3, 0, new Level2());
        //  会报错，带泛型的方法只支持内部操作，不能从外部往内部添加元素
        //fooHelper(list4,0,new Level2());


    }

    /**
     * for list with generic
     * You can add null.
     * You can invoke clear.
     * You can get the iterator and invoke remove.
     * You can capture the wildcard and write elements that you've read from the list.
     */
    private <T> void fooHelper(List<T> list, int index) {
        list.set(index, list.get(index));
    }

    private <T> void fooHelper(List<T> list, int index, T val) {
        list.set(index, val);
    }


    @Test
    public void test() {


        Level1 level1 = new Level1();
        Level2 level2 = new Level2();
        Level3 level3 = new Level3();


        List<? extends Level2> list1 = new ArrayList<>();
        List<? super Level2> list2 = new ArrayList<>();
        List<Level2> list3 = new ArrayList<>();
        List<Level1> list4 = new ArrayList<>();
        List<Level3> list5 = new ArrayList<>();


        list2.add(level1);
        list3.add(level1);
        System.out.println(list2);
        System.out.println(list3);

    }


    @SneakyThrows
    @Test
    public void erase_test() {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        Method method = list.getClass().getDeclaredMethod("add", Object.class);
        /**
         * Method method2 = list.getClass().getDeclaredMethod("add", Integer.class);
         * 报错：java.lang.NoSuchMethodException: java.util.ArrayList.add(java.lang.Integer)
         * 原因：java在处理泛型参数的是时候，会转换为Object类型处理
         */
        //向整型list中添加字符串
        method.invoke(list,"aaa");

        System.out.println(list);

    }


}
