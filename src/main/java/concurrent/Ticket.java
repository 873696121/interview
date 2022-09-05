package concurrent;

/**
 * @author HuHong
 * @date 2021/9/15
 */
public class Ticket {
    private int num = 100;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Ticket(int num) {
        this.num = num;
    }

    public synchronized void print(int t) {
        if (num > 0) {
            num--;
            System.out.println(t + "    卖出了一张票，还剩" + num + "张票");
        }
    }
}
