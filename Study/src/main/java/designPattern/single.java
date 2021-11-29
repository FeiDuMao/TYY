package designPattern;

/**
 * 单例模式
 */
public class single {

    //私有化构造器!!!!!
    private single(){}

    private static single Instance;

    //饿汉式加载：线程安全，在类加载的时候就实例化的一个单例对象。
    //此处只写了静态加载，没有写对外getInstance()接口。
    static {
        Instance=new single();
    }


    //懒汉式加载：第一次调用的时候才实例化对象
    //此方法线程安全
    public  single getInstance(){
        if (Instance==null){
            synchronized (single.class){
                //双重判断原因：当还有另外一个线程等在这个锁结束后，如果不再次检查，则会创建一个新的实例
                if (Instance==null)
                    return new single();
            }
        }
        return Instance;
    }


}
