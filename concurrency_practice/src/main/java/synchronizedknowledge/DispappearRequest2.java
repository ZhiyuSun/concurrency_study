package synchronizedknowledge;

/**
 * @Description: 消失的请求数，解决方案1，同步方法
 * @Author: sunzhiyu
 * @CreateDate: 2021/2/8 10:16
 */
public class DispappearRequest2 implements Runnable{
    static DispappearRequest2 instance = new DispappearRequest2();

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
    public synchronized void run() {
        for (int j=0; j<100000; j++){
            i++;
        }
    }
}
