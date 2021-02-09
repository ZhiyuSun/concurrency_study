package threadcoreknowledge.stopthreads;

/**
 * @Description:  带有sleep的中断线程的写法
 * @Author: sunzhiyu
 * @CreateDate: 2021/2/6 23:46
 */
public class RightWayStopThreadWithSleep {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;
            try {
                while (num <= 300 && !Thread.currentThread().isInterrupted()) {
                    if (num % 100 == 0) {
                        System.out.println(num + "是100的倍数");
                    }
                    num++;
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(500);
        thread.interrupt();
    }
}

// 因为程序带有了sleep，在线程阻塞过程中依然可以响应中断