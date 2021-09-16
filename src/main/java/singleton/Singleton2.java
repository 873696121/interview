package singleton;

/***********************************************************                                          *
 * Time: 2021/9/16
 * Author: HuHong
 * Desc: 懒汉
 ***********************************************************/

public class Singleton2 {
    private Singleton2(){

    }

    private static class InnerClass{
        private static final Singleton2 instance = new Singleton2();
    }

    public static Singleton2 getInstance(){
        return InnerClass.instance;
    }
}
