package concurrent;

/**
 * @Classname test5
 * @Description TODO
 * @Date 2022/2/8 09:59
 * @Created by taoyuanyuan
 */
public class test5 {

    public void add(int x)  {
        for (int i = 0; i < 3; i++) {
            x++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
