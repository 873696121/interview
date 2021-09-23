package rpc.proxy;

/***********************************************************                                          *
 * Time: 2021/9/23
 * Author: HuHong
 * Desc:
 ***********************************************************/

public class DemoInterfaceImpl implements DemoInterface{
    @Override
    public String hello(String name) {
        return "hello, " + name;
    }
}
