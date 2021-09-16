package singleton;

/***********************************************************                                          *
 * Time: 2021/9/16
 * Author: HuHong
 * Desc:
 ***********************************************************/

public class Test {
    public static void main(String[] args) {
        Singleton2 instance2 = Singleton2.getInstance();
        Singleton instance = Singleton.getInstance();
    }
}
