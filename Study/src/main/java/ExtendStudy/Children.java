package ExtendStudy;

/**
 * @Classname Children
 * @Date 2022/2/6 20:16
 * @Created by taoyuanyuan
 */
public class Children extends Father {


    static int x = 10;
    private int a = 1;
    public int b = 2;
    int c = 3;
    protected int f=-1;

    public Children() {
        System.out.println(super.f);
        System.out.println(this.f);
        System.out.println("子类构造器调用！");
    }

    {
        System.out.println("子类代码块调用！");
    }

    static {
        System.out.println("子类静态代码块调用！");
    }

    public int add(int a, int b, int c) {
        System.out.println(a);
        System.out.println(b);
        return a + b;
    }
}
