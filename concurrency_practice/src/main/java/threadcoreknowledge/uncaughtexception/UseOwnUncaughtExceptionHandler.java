package threadcoreknowledge.uncaughtexception;

/**
 * @Description: 使用刚才自己写的UncaughtExceptionHandler
 * @Author: sunzhiyu
 * @CreateDate: 2021/2/11 08:25
 */
public class UseOwnUncaughtExceptionHandler implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler("捕获器1"));

        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread-1").start();
        Thread.sleep(300);
        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread-2").start();
        Thread.sleep(300);
        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread-3").start();
        Thread.sleep(300);
        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread-4").start();
    }


    @Override
    public void run() {
        throw new RuntimeException();
    }
}

// output 使用自己的异常处理类
// 二月 11, 2021 8:26:36 上午 threadcoreknowledge.uncaughtexception.MyUncaughtExceptionHandler uncaughtException
//警告: 线程异常，终止啦MyThread-1
//捕获器1捕获了异常MyThread-1异常
//二月 11, 2021 8:26:37 上午 threadcoreknowledge.uncaughtexception.MyUncaughtExceptionHandler uncaughtException
//警告: 线程异常，终止啦MyThread-2
//捕获器1捕获了异常MyThread-2异常
//二月 11, 2021 8:26:37 上午 threadcoreknowledge.uncaughtexception.MyUncaughtExceptionHandler uncaughtException
//警告: 线程异常，终止啦MyThread-3
//捕获器1捕获了异常MyThread-3异常
//二月 11, 2021 8:26:37 上午 threadcoreknowledge.uncaughtexception.MyUncaughtExceptionHandler uncaughtException
//警告: 线程异常，终止啦MyThread-4
//捕获器1捕获了异常MyThread-4异常