package jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:
 * @Author: sunzhiyu
 * @CreateDate: 2021/2/13 23:09
 */
public class NoVolatile implements Runnable{
    volatile int a;
    AtomicInteger realA = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        Runnable r =  new NoVolatile();
        Thread thread1 = new Thread(r);
        Thread thread2 = new Thread(r);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(((NoVolatile) r).a);
        System.out.println(((NoVolatile) r).realA.get());
    }
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            a++;
            realA.incrementAndGet();
        }
    }
}

// 17562
//20000