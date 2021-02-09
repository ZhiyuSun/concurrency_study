package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @Description: 展示wait和notify的基本用法
 * 1. 研究代码执行顺序 2. 证明wait释放锁
 * @Author: sunzhiyu
 * @CreateDate: 2021/2/9 11:07
 */
public class Wait {
    public static Object object = new Object();

    static class Thread1 extends Thread {

        @Override
        public void run() {
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + "开始执行了");
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程" + Thread.currentThread().getName() + "获取到了锁。");
            }
        }
    }

    static class Thread2 extends Thread {

        @Override
        public void run() {
            synchronized (object) {
                object.notify();
                System.out.println("线程" + Thread.currentThread().getName() + "调用了notify()");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        Thread.sleep(200);
        thread2.start();
    }
}

// 输出
// Thread-0开始执行了
// 线程Thread-1调用了notify()
// 线程Thread-0获取到了锁。

// 原理解析：
// 线程0通过wait释放掉了它的锁
// 线程1拿到锁，通过notify唤醒了线程0
// 线程1执行结束，释放锁
// 线程0获取到了锁，继续执行