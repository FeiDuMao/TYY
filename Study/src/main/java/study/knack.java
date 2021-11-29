package study;

import org.junit.Test;

public class knack {



    /**
     *  1 2 3 4 5 6 7 8  9
     *  0 1 1 2 3 5 8 13 21
     */
    //Fibonacci数列递归法：效率低
    public int Fibonacci(int n){
        if (n==1) return 0;
        if (n==2) return 1;
        return Fibonacci(n-1)+Fibonacci(n-2);
    }

    //非递归
    public int getFibonacci(int n){
        if (n==1)return 0;
        if (n==2)return 1;
        //pre:前一个数，cur：后一个数，tmp：暂存下一个数
        int pre=0,cur=1,tmp;
        for (int i = 2; i < n; i++) {
            tmp=pre+cur;
            pre=cur;
            cur=tmp;
        }
        return cur;
    }


    @Test
    public void test(){
        System.out.println(getFibonacci(9));
    }


}
