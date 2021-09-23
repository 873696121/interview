package rpc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/***********************************************************                                          *
 * Time: 2021/9/23
 * Author: HuHong
 * Desc:
 ***********************************************************/

public class DemoProxy implements InvocationHandler {

    private DemoInterface demoInterface;

    public DemoProxy(DemoInterface demoInterface) {
        this.demoInterface = demoInterface;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(demoInterface, args);
    }
}
