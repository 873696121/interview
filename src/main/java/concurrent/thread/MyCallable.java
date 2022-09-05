package concurrent.thread;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("MyCallable");
        return "return of callable";
    }
}
