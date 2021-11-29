
import org.junit.Test;

public class test {


    //0 1 1 2 3 5 8
    public int Fibonacci(int n){
        if (n==0||n==1)return n;
        int pre=0,cur=1,tmp;
        for (int i = 2; i <n ; i++) {
            tmp=pre+cur;
            pre=cur;
            cur=tmp;
        }

        return cur;
    }


    @Test
    public void test(){
        System.out.println(Fibonacci(5));
    }






}
