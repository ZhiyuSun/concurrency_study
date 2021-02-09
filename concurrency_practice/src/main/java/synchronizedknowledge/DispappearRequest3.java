package synchronizedknowledge;

/**
 * @Description: 消失的请求数，同步代码块
 * @Author: sunzhiyu
 * @CreateDate: 2021/2/8 10:16
 */
public class DispappearRequest3 implements Runnable{
    static DispappearRequest3 instance = new DispappearRequest3();

    static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);

    }

    @Override
    public void run() {
        synchronized (this) {
            for (int j=0; j<100000; j++){
                i++;
            }
        }
    }
}
