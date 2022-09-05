package concurrent.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyRunnable instance = new MyRunnable();
        Thread thread = new Thread(instance);
        thread.start();

        MyCallable mc = new MyCallable();
        FutureTask<String> ft = new FutureTask<>(mc);
        Thread thread2 = new Thread(ft);
        thread2.start();
        System.out.println(ft.get());
    }
}
