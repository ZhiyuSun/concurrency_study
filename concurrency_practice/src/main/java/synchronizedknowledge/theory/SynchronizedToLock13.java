package synchronizedknowledge.theory;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: sunzhiyu
 * @CreateDate: 2021/2/8 16:00
 */
public class SynchronizedToLock13 {
    Lock lock = new ReentrantLock();

    public synchronized void method1() {
        System.out.println("我是Synchronized形式的锁");
    }

    public void method2() {
        lock.lock();
        try {
            System.out.println("我是lock形式的锁");
        } finally {
            lock.unlock();
        }
    }
    // 这两个方法等价

    public static void main(String[] args) {
        SynchronizedToLock13 s = new SynchronizedToLock13();
        s.method1();
        s.method2();
    }

}
