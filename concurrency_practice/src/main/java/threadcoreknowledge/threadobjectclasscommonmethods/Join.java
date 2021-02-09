package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @Description: 演示join，注意语句输出顺序，会变化。
 * @Author: sunzhiyu
 * @CreateDate: 2021/2/9 14:57
 */
public class Join {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "执行完毕");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "执行完毕");
            }
        });

        thread.start();
        thread2.start();
        System.out.println("开始等待子线程运行完毕");
        thread.join();
        thread2.join();
        System.out.println("所有子线程执行完毕");
    }
}

// output
// 开始等待子线程运行完毕
//Thread-0执行完毕
//Thread-1执行完毕
//所有子线程执行完毕