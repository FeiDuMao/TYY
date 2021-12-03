package reflect;

import Entity.Person;
import Entity.TreeNode;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.TransferQueue;

public class Reflect {

    public static void main(String[] args) throws Exception {
        //加载类
        Class clazz=Class.forName("Entity.Person");
        Class clazz2=ClassLoader.getSystemClassLoader().loadClass(Person.class.getName());

        //获取所有属性
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        //获取所有方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }

        Method setName = clazz.getDeclaredMethod("setName", String.class);
        Person o = (Person) clazz.newInstance();
        setName.setAccessible(true);
        setName.invoke(o,"tyy");
        System.out.println(o);


    }


}
