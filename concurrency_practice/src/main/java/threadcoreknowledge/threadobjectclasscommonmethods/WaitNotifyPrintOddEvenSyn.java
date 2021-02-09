package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @Description: 两个线程交替打印0~100的奇偶数，用synchronized关键字实现
 * @Author: sunzhiyu
 * @CreateDate: 2021/2/9 11:50
 */
public class WaitNotifyPrintOddEvenSyn {
    private static int count;

    private static final Object lock = new Object();

    //新建2个线程
    //1个只处理偶数，第二个只处理奇数（用位运算）
    //用synchronized来通信
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (lock) {
                        if ((count & 1) == 0) {
                            System.out.println(Thread.currentThread().getName() + ":" + count++);
                        }
                    }
                }
            }
        }, "偶数").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (lock) {
                        if ((count & 1) == 1) {
                            System.out.println(Thread.currentThread().getName() + ":" + count++);
                        }
                    }
                }
            }
        }, "奇数").start();
    }
}

// 输出
// 偶数:0
//奇数:1
//偶数:2
//奇数:3
//偶数:4
//奇数:5
//偶数:6

// 两个线程去竞争条件，如果不满足，就跳出，等待另一个线程拿到另一把锁
// 但是效率没那么高