package singleton;

/***********************************************************                                          *
 * Time: 2021/9/16
 * Author: HuHong
 * Desc: 饿汉
 ***********************************************************/

public class Singleton {
    private Singleton(){

    }

    private static Singleton instance = new Singleton();

    public static Singleton getInstance(){
        return instance;
    }
}
