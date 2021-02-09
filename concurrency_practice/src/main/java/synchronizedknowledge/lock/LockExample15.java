package synchronizedknowledge.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 展示Lock的方法
 * @Author: sunzhiyu
 * @CreateDate: 2021/2/8 16:29
 */
public class LockExample15 {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
//        lock.lock();
        lock.unlock();
        lock.tryLock();
        lock.tryLock(1000, TimeUnit.SECONDS);
    }
}
