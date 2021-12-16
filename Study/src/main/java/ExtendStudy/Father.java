package ExtendStudy;

/**
 * @Classname Parent
 * @Date 2022/2/6 20:15
 * @Created by taoyuanyuan
 */
public class Father {
    static int l;
    static int x = 20;
    private int n=100;
    public int m=100;
    public int o;
    protected int f=0;

    public static int add(int a, int b) {
        return a + b;
    }

    {
        System.out.println("父类代码块调用！");
    }

    static {
        System.out.println("父类静态代码块调用！");
    }

    public Father() {
        System.out.println("父类构造器调用！");
    }
}
