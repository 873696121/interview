package rpc.proxy;

import java.lang.reflect.Proxy;

/***********************************************************                                          *
 * Time: 2021/9/23
 * Author: HuHong
 * Desc:
 ***********************************************************/

public class Main {
    public static void main(String[] args) {
        DemoProxy proxy = new DemoProxy(new DemoInterfaceImpl());
        DemoInterface demoInterface = (DemoInterface) Proxy.newProxyInstance(DemoInterface.class.getClassLoader(), new Class[]{DemoInterface.class}, proxy);
        String s = demoInterface.hello("huhong");
        System.out.println(s);
    }
}
