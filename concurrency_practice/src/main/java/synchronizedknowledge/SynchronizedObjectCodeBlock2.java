package synchronizedknowledge;

/**
 * @Description: 对象锁示例1：代码块形式
 * this或者lock
 * @Author: sunzhiyu
 * @CreateDate: 2021/2/8 10:23
 */
public class SynchronizedObjectCodeBlock2 implements Runnable{

    static SynchronizedObjectCodeBlock2 instance = new SynchronizedObjectCodeBlock2();
    Object lock1 = new Object();
    Object lock2 = new Object();

    @Override
    public void run() {
        synchronized (lock1) {
            System.out.println("我是对象锁lock1的代码块形式，我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ "lock1运行结束");
        }

        synchronized (lock2) {
            System.out.println("我是对象锁lock2的代码块形式，我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ "lock2运行结束");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()){}
        System.out.println("finished");
    }
}
//输出：
// 我是对象锁的代码块形式，我叫Thread-0
//Thread-0运行结束
//我是对象锁的代码块形式，我叫Thread-1
//Thread-1运行结束
//finished


// lock替代this
//我是对象锁lock1的代码块形式，我叫Thread-0
//Thread-0lock1运行结束
//我是对象锁lock2的代码块形式，我叫Thread-0
//我是对象锁lock1的代码块形式，我叫Thread-1
//Thread-1lock1运行结束
//Thread-0lock2运行结束
//我是对象锁lock2的代码块形式，我叫Thread-1
//Thread-1lock2运行结束
//finished

// 可以在debugger里的frames和threads里进行调试，并且用expression的this.getState()