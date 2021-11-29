package leetcode;

import org.junit.Test;

import java.util.LinkedList;

/**
 * 用两个栈实现队列
 */

public class ITV06 {

        LinkedList<Integer> A, B;
        public ITV06() {
            A = new LinkedList<Integer>();
            B = new LinkedList<Integer>();
        }

        //两个栈实现队列
        public void appendTail(int value) {
            A.addLast(value);
        }

    /**
     * B是A的逆序，负责出栈，当B不为空时，一直出栈。
     * 当B全部出栈后，A再将自己的栈帧压入B中。（如果B不为空时，将A中的元素放入则会影响顺序）
     */
    public int deleteHead() {
            if(!B.isEmpty()) return B.removeLast();
            //如果A、B中都为空，返回-1
            if(A.isEmpty()) return -1;
            while(!A.isEmpty())
                B.addLast(A.removeLast());
            return B.removeLast();
        }


        @Test
        public void test(){

           appendTail(1);
           appendTail(2);
           appendTail(3);

            System.out.println(deleteHead());
            System.out.println(deleteHead());
            appendTail(4);
            appendTail(5);
            System.out.println(deleteHead());
            System.out.println(deleteHead());



        }




}
