package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/***********************************************************                                          *
 * Time: 2021/9/23
 * Author: HuHong
 * Desc:
 ***********************************************************/

public class PrintText extends Thread{
    private static int sequence = 0;
    private static final int END = 100;

    private ReentrantLock lock;
    private Condition[] conditions;
    private int id;

    public PrintText(ReentrantLock lock, Condition[] conditions, int id) {
        this.lock = lock;
        this.conditions = conditions;
        this.id = id;
    }

    @Override
    public void run() {
        while(sequence >= 0 && sequence < END){
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
        for(int i = 0; i < conditions.length; i ++){
            conditions[i].signal();
        }
        lock.unlock();
    }

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        int threadCnt = 10;
        Condition[] conditions = new Condition[threadCnt];
        PrintText[] printTexts = new PrintText[threadCnt];
        for (int i = 0; i < threadCnt; i++) {
            conditions[i] = lock.newCondition();
            printTexts[i] = new PrintText(lock, conditions, i);
            printTexts[i].start();
        }
    }
}
