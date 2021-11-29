package reflect;

import Entity.TreeNode;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.TransferQueue;

public class Reflect {

    public static void main(String[] args) throws Exception {
        Class clazz=Class.forName("Entity.TreeNode");

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

        TreeNode node = (TreeNode)clazz.newInstance();
        System.out.println(clazz.getCanonicalName());

        Method setVal = clazz.getDeclaredMethod("setVal", int.class);
        setVal.invoke(node,1);
        System.out.println(node);


    }


}
