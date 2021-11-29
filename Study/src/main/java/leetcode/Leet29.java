package leetcode;

import org.junit.Test;

public class Leet29 {
    public int divide(int dividend, int divisor) {
        double ans=0;
        boolean isminus=false;
        if(dividend<0){
            dividend=-dividend;
            isminus=!isminus;
        }
        if(divisor<0){
            divisor=-divisor;
            isminus=!isminus;
        }

        while(dividend>=divisor){
            dividend-=divisor;
            ans++;
        }
        if(isminus)ans=-ans;
        return (int) ans;
    }

    public int divide2(int dividend, int divisor) {
        // 当除数为1，直接返回被除数
        if (divisor == 1) {
            return dividend;
        }
        // 当除数为-1且被除数为Integer.MIN_VALUE时，将会溢出，返回Integer.MAX_VALUE
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        // 把被除数与除数调整为正数,为防止被除数Integer.MIN_VALUE转换为正数会溢出，使用long类型保存参数
        if (dividend < 0 && divisor < 0) {
            return divide(-(long) dividend, -(long) divisor);
        } else if (dividend < 0 || divisor < 0) {
            return -divide(Math.abs((long) dividend), Math.abs((long) divisor));
        } else {
            return divide((long) dividend, (long) divisor);
        }
    }

    public int divide(long dividend, long divisor) {
        // 如果被除数小于除数，结果明显为0
        if (dividend < divisor) {
            return 0;
        }
        long sum = divisor; // 记录用了count个divisor的和
        int count = 1; // 使用了多少个divisor
        while (dividend >= sum) {
            // 每次翻倍
            sum <<= 1;
            count <<= 1;
        }

        // 此时dividend < sum
        sum >>>= 1;
        count >>>= 1;

        // 此时dividend >= sum
        // 将count个divisor从dividend消耗掉，剩下的还需要多少个divisor交由递归函数处理
        return count + divide(dividend - sum, divisor);
    }


    @Test
    public void test(){
        System.out.println(divide2(-Integer.MAX_VALUE-1, -1));

    }
}
