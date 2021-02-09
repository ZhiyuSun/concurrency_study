package threadcoreknowledge.startthread;

/**
 * @Description: 对比start和run两种启动线程的方式
 * @Author: sunzhiyu
 * @CreateDate: 2021/2/6 19:50
 */
public class StartAndRunMethod {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());

        };
        runnable.run(); // main

        new Thread(runnable).start(); // Thread-0
    }
}
