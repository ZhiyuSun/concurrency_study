package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @Description: 3个线程，线程1和线程2首先被阻塞，线程3唤醒它们。
 * notify, notifyAll。 start先执行不代表线程先启动。
 * @Author: sunzhiyu
 * @CreateDate: 2021/2/9 11:14
 */
public class WaitNotifyAll implements Runnable{
    private static final Object resourceA = new Object();


    public static void main(String[] args) throws InterruptedException {
        Runnable r = new WaitNotifyAll();
        Thread threadA = new Thread(r);
        Thread threadB = new Thread(r);
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    resourceA.notifyAll();
//                    resourceA.notify();
                    System.out.println("ThreadC notified.");
                }
            }
        });
        threadA.start();
        threadB.start();
//        Thread.sleep(200);
        threadC.start();
    }
    @Override
    public void run() {
        synchronized (resourceA) {
            System.out.println(Thread.currentThread().getName()+" got resourceA lock.");
            try {
                System.out.println(Thread.currentThread().getName()+" waits to start.");
                resourceA.wait();
                System.out.println(Thread.currentThread().getName()+"'s waiting to end.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// 输出
// Thread-0 got resourceA lock.
//Thread-0 waits to start.
//Thread-1 got resourceA lock.
//Thread-1 waits to start.
//ThreadC notified.
//Thread-1's waiting to end.
//Thread-0's waiting to end.

// 解释：线程0和1都被唤醒
// 如果用notify，则只唤醒一个