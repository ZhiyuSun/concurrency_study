package threadcoreknowledge.stopthreads;

/**
 * @Description: 注意Thread.interrupted()方法的目标对象是“当前线程”，而不管本方法来自于哪个对象
 * @Author: sunzhiyu
 * @CreateDate: 2021/2/7 14:46
 */
public class RightWayInterrupted {
    public static void main(String[] args) throws InterruptedException {

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                }
            }
        });

        // 启动线程
        threadOne.start();
        //设置中断标志
        threadOne.interrupt();
        //获取中断标志
        System.out.println("isInterrupted: " + threadOne.isInterrupted());  // 自然返回true
        //获取中断标志并重置
        System.out.println("isInterrupted: " + threadOne.interrupted());  // false，main函数没有进行任何的中断。这个静态方法的作用对象是当前调用它的线程
        //获取中断标志并重直
        System.out.println("isInterrupted: " + Thread.interrupted()); // false
        //获取中断标志
        System.out.println("isInterrupted: " + threadOne.isInterrupted()); // true
        threadOne.join();
        System.out.println("Main thread is over.");
    }
}

