
import org.junit.Test;

public class test {


    //0 1 1 2 3 5 8
    public int Fibonacci(int n){
        if (n==0||n==1)return n;
        int cur=0,pre=1,tmp=0;
        for (int i = 2; i <n ; i++) {
            cur=pre+tmp;
        }

        return cur;
    }


    @Test
    public void test(){

    }






}
