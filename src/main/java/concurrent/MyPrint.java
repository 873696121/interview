package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/***********************************************************                                          *
 * Time: 2021/9/16
 * Author: HuHong
 * Desc:
 ***********************************************************/

public class MyPrint extends Thread{

    private static int sequence = 0;
    private static final int FINAL_SEQUENCE = 100;

    private int id;
    private ReentrantLock lock;
    private Condition[] conditions;

    public MyPrint(int id, ReentrantLock lock, Condition[] conditions) {
        this.id = id;
        this.lock = lock;
        this.conditions = conditions;
    }

    @Override
    public void run() {
        while(sequence >= 0 && sequence < FINAL_SEQUENCE){
            lock.lock();
            try {
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
        for (int i = 0; i < conditions.length; i++) {
            conditions[i].signal();
        }
        lock.unlock();
    }

    public static void main(String[] args) {
        int threadCount = 3;
        Condition[] conditions = new Condition[threadCount];
        ReentrantLock lock = new ReentrantLock();
        MyPrint[] myPrints = new MyPrint[threadCount];
        for (int i = 0; i < threadCount; i++) {
            conditions[i] = lock.newCondition();
            myPrints[i] = new MyPrint(i, lock, conditions);
        }
        for (int i = 0; i < threadCount; i++) {
            myPrints[i].start();
        }
    }
}
