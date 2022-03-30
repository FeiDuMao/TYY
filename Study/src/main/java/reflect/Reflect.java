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
        Person person=new Person();
        System.out.println(validate(person));

    }


    //判断对象内的属性是否有值为null;
    private boolean validate(Object o){
        try {
            Class clazz = Class.forName(o.getClass().getName());
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field field:declaredFields){
                field.setAccessible(true);
                if (field.get(o)==null){
                    return false;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return true;
    }

}
