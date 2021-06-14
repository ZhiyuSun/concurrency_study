package threadcoreknowledge.uncaughtexception;

/**
 * @Description: 单线程，抛出，处理，有异常堆栈 多线程，子线程发生异常，会有什么不同？
 * @Author: sunzhiyu
 * @CreateDate: 2021/2/11 08:11
 */
public class ExceptionInChildThread implements Runnable {

    public static void main(String[] args) {
        new Thread(new ExceptionInChildThread()).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }

    @Override
    public void run() {
        throw new RuntimeException();
    }
}

// output
// 406
//Exception in thread "Thread-0" java.lang.RuntimeException
//	at threadcoreknowledge.uncaughtexception.ExceptionInChildThread.run(ExceptionInChildThread.java:19)
//	at java.lang.Thread.run(Thread.java:748)
//407
//408
//409
// 子线程的异常容易遗漏