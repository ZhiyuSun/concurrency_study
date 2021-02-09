package threadcoreknowledge.createthreads;

/**
 * @Description: 用Runnable方式创建线程
 * @CreateDate: 2021/2/6 15:54
 */
public class RunnableStyle implements Runnable {
    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableStyle());
        thread.start();
    }

    public void run() {
        System.out.println("用Runnable接口实现线程");
    }
}
