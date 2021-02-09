package threadcoreknowledge.stopthreads;

/**
 * @Description: 如果while里面放try/catch，会导致中断失效
 * @Author: sunzhiyu
 * @CreateDate: 2021/2/6 23:54
 */
public class CantInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;
            while (num <= 10000 && !Thread.currentThread().isInterrupted()) {
                if (num % 100 == 0) {
                    System.out.println(num + "是100的倍数");
                }
                num++;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }
}
// 因为sleep的设计问题，导致程序无法中断