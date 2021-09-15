package concurrent;

/**
 * 交替打印
 *
 * @author HuHong
 * @date 2021/9/15
 */
public class PrintTest {
    public static void main(String[] args) {
        Ticket ticket = new Ticket(400);
        for (int i = 0; i < 5; i++) {
            int t = i;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(ticket.getNum() > 0){
                        if(ticket.getNum() % 3 == t){
                            ticket.print(t);
                        }
                    }
                }
            });
            thread.start();
        }
    }
}
