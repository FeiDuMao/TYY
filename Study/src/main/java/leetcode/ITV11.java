package leetcode;

import org.junit.Test;

/**
 * 青蛙跳台阶：
 * 青蛙一次能跳1个或2个台阶，请问它跳到第n阶有多少种跳法
 */
public class ITV11 {

    /**
     * 动态规划：青蛙跳到第n个台阶时，跳法为它跳到n-1和n-2的可能性之和；
     * @param target
     * @return
     */
    public int jump(int target){
        if (target==1)
            return 1;
        if (target==2)
            return 2;
        return jump(target-1)+jump(target-2);
    }

    /**
     * 因为f(n)=f(n+1)+f(n-2)
     * 跳台阶问题可以转换为求斐波那契数列第n个值的问题
     * @param n
     * @return
     */
    public int Fibonacci(int n){
        if (n == 1) return 1;
        if (n == 2) return 2;
        int a = 0, b = 1,s=0;
        for (int i = 0; i < n ; i++) {
            s = (a + b)% 1000000007;
            a=b;
            b=s;
        }
        return b;
    }


    @Test
    public void test(){

        System.out.println(Fibonacci(44));
        System.out.println(1134903170 % 1000000007);
    }
}
