package synchronizedknowledge;

/**
 * @Description: 访问同一个对象的不同的普通同步方法
 * @Author: sunzhiyu
 * @CreateDate: 2021/2/8 11:18
 */
public class SynchronizedDifferentMethod7 implements Runnable{
    static SynchronizedDifferentMethod7 instance = new SynchronizedDifferentMethod7();

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()){}
        System.out.println("finished");
    }


    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")){
            method1();
        } else {
            method2();
        }
    }

    public synchronized void method1() {
        System.out.println("我是加锁的方法，我叫"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

    public synchronized void method2() {
        System.out.println("我是加锁的方法，我叫"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }
}
