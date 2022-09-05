package concurrent;

import com.sun.org.apache.xpath.internal.compiler.FuncLoader;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 交替打印
 *
 * @author HuHong
 * @date 2021/9/15
 */
public class PrintNum extends Thread {

    private static int sequence = 0;
    private static int FINAL_SEQUENCE = 75;

    private Integer id;
    private ReentrantLock lock;
    private Condition[] conditions;

    public PrintNum(Integer id, ReentrantLock lock, Condition[] conditions) {
        this.id = id;
        this.lock = lock;
        this.conditions = conditions;
    }

    @Override
    public void run() {
        while (sequence >= 0 && sequence < FINAL_SEQUENCE) {
            lock.lock();
            try {
                if (sequence % conditions.length != id) {
                    conditions[sequence % conditions.length].signal();
                    conditions[id].await();
                }
                System.out.println(Thread.currentThread().getName() + " " + (char) (id + 'A'));
                sequence++;
                conditions[sequence % conditions.length].signal();
                conditions[id].await();


            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        lock.lock();
        for (int i = 0; i < conditions.length - 1; i++) {
            int index = (id + i) % conditions.length;
            conditions[index].signal();
        }
        lock.unlock();
    }

    public static void main(String[] args) {
        int totalThreads = 3;
        Condition[] conditions = new Condition[totalThreads];
        PrintNum[] printNums = new PrintNum[totalThreads];
        ReentrantLock lock = new ReentrantLock();
        for (int i = 0; i < conditions.length; i++) {
            conditions[i] = lock.newCondition();
        }
        for (int i = 0; i < conditions.length; i++) {
            printNums[i] = new PrintNum(i, lock, conditions);
        }
        for (int i = 0; i < conditions.length; i++) {
            printNums[i].start();
        }
    }
}
