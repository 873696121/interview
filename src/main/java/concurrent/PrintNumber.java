package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class PrintNumber extends Thread {
    /**
     * 多个线程共享这一个sequence数据
     */
    private static int sequence = 0;

    private static final int SEQUENCE_END = 75;

    private Integer id;
    private ReentrantLock lock;
    private Condition[] conditions;


    private PrintNumber(Integer id, ReentrantLock lock, Condition[] conditions) {
        this.id = id;
        this.setName("thread" + id);
        this.lock = lock;
        this.conditions = conditions;
    }

    @Override
    public void run() {
        while (sequence >= 0 && sequence < SEQUENCE_END) {
            lock.lock();
            try {
                //对序号取模,如果不等于当前线程的id,则先唤醒其他线程,然后当前线程进入等待状态
                while (sequence % conditions.length != id) {
                    conditions[(id + 1) % conditions.length].signal();
                    conditions[id].await();
                }
                System.out.println(Thread.currentThread().getName() + " " + sequence);
                //序号加1
                sequence = sequence + 1;
                //唤醒当前线程的下一个线程
                conditions[(id + 1) % conditions.length].signal();
                //当前线程进入等待状态
                conditions[id].await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //将释放锁的操作放到finally代码块中,保证锁一定会释放
                lock.unlock();
            }
        }
        //数字打印完毕,线程结束前唤醒其余的线程,让其他线程也可以结束
        end();
    }

    private void end() {
        lock.lock();
        conditions[(id + 1) % conditions.length].signal();
        conditions[(id + 2) % conditions.length].signal();
        lock.unlock();
    }

    public static void main(String[] args) {
        int threadCount = 3;
        ReentrantLock lock = new ReentrantLock();
        Condition[] conditions = new Condition[threadCount];
        for (int i = 0; i < threadCount; i++) {
            conditions[i] = lock.newCondition();
        }
        PrintNumber[] printNumbers = new PrintNumber[threadCount];
        for (int i = 0; i < threadCount; i++) {
            PrintNumber p = new PrintNumber(i, lock, conditions);
            printNumbers[i] = p;
        }
        for (PrintNumber printNumber : printNumbers) {
            printNumber.start();
        }
    }

}