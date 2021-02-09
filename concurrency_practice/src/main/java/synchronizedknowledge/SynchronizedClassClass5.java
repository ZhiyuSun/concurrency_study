package synchronizedknowledge;

/**
 * @Description: 类锁的第一种形式，static形式
 * @Author: sunzhiyu
 * @CreateDate: 2021/2/8 11:01
 */
public class SynchronizedClassClass5 implements Runnable{
    static SynchronizedClassClass5 instance1 = new SynchronizedClassClass5();
    static SynchronizedClassClass5 instance2 = new SynchronizedClassClass5();

    @Override
    public void run() {
        method();
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()){}
        System.out.println("finished");
    }

    public void method() {
        synchronized (SynchronizedClassClass5.class) {
//        synchronized (this) { // 反例
            System.out.println("我是类锁的第二种形式：synchronized(*.class)，我叫"+Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行结束");
        }
    }

}

// 输出
// 我是类锁的第二种形式：synchronized(*.class)，我叫Thread-0
//Thread-0运行结束
//我是类锁的第二种形式：synchronized(*.class)，我叫Thread-1
//Thread-1运行结束
//finished

