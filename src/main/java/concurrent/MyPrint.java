package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author HuHong
 * @date 2021/9/15
 */
public class MyPrint extends Thread{

    private static int sequence;
    private static final int FINAL_SEQUENCE = 100;

    private int id;
    private Condition[] conditions;
    private ReentrantLock lock;

    public MyPrint(int id, Condition[] conditions, ReentrantLock lock) {
        this.id = id;
        this.conditions = conditions;
        this.lock = lock;
    }

    @Override
    public void run() {
        while(sequence >= 0 && sequence < FINAL_SEQUENCE){
            try {
                lock.lock();
                if(sequence % conditions.length != id){
                    conditions[sequence % conditions.length].signal();
                    conditions[id].await();
                }
                System.out.println(Thread.currentThread().getName() + " " + sequence);
                sequence ++;
                conditions[sequence % conditions.length].signal();
                conditions[id].await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
        lock.lock();
        conditions[(id + 1) % conditions.length].signal();
        lock.unlock();
    }

    public static void main(String[] args) {
        int threadCount = 4;
        Condition[] conditions = new Condition[threadCount];
        MyPrint[] myPrints = new MyPrint[threadCount];
        ReentrantLock lock = new ReentrantLock();
        for (int i = 0; i < conditions.length; i++) {
            conditions[i] = lock.newCondition();
            myPrints[i] = new MyPrint(i, conditions, lock);
            myPrints[i].start();
        }
    }
}
