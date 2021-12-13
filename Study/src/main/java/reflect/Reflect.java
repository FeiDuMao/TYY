package reflect;

import Entity.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

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

    @Test
    public void test(){
        Person person=new Person("tyy",10);
        Class clazz= null;
        try {
            clazz = Class.forName(person.getClass().getName());

            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field field:declaredFields){
                System.out.println(field.toString());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
