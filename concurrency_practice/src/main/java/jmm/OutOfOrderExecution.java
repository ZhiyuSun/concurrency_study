package jmm;

import java.util.concurrent.CountDownLatch;

/**
 * @Description: 演示重排序的现象 “直到达到某个条件才停止”，测试小概率事件
 * @Author: sunzhiyu
 * @CreateDate: 2021/2/13 21:35
 */
public class OutOfOrderExecution {
    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for (; ; ) {
            i++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;

            CountDownLatch latch = new CountDownLatch(3);

            Thread one = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        latch.countDown();
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    a = 1;
                    x = b;
                }
            });
            Thread two = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        latch.countDown();
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    b = 1;
                    y = a;
                }
            });
            two.start();
            one.start();
            latch.countDown();
            one.join();
            two.join();

            String result = "第" + i + "次（" + x + "," + y + ")";
            if (x == 0 && y == 0) {
                System.out.println(result);
                break;
            } else {
                System.out.println(result);
            }
        }
    }
}

// 这4行diamante的执行顺序决定了最终x和y的结果，有三种情况
// x=0,y=1
// x=1,x=0
// x=1,y=1

// 但是由于重排序，也会输出x=0,y=0
// 上面的解决方法，给变量加volatile关键字