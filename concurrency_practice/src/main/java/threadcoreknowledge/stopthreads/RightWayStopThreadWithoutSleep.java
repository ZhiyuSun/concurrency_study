package threadcoreknowledge.stopthreads;

/**
 * @Description: run方法内没有sleep或wait方法时，停止线程
 * @Author: sunzhiyu
 * @CreateDate: 2021/2/6 23:39
 */
public class RightWayStopThreadWithoutSleep implements Runnable {

    @Override
    public void run() {
        int num = 0;
        while (!Thread.currentThread().isInterrupted() && num <= Integer.MAX_VALUE / 2) {
//        while (num <= Integer.MAX_VALUE / 2) {
            if (num % 10000 == 0) {
                System.out.println(num + "是10000的倍数");
            }
            num++;
        }
        System.out.println("任务运行结束了");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadWithoutSleep());
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();  // 如果不检测线程的状态，这里的interrupt不会有效果
    }
}
