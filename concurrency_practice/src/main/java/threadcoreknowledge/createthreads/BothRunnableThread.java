package threadcoreknowledge.createthreads;

/**
 * @Description: 同时使用Runnable和Thread两种实现线程的方式
 * @CreateDate: 2021/2/6 16:21
 */
public class BothRunnableThread {
    public static void main(String[] args) {
        new Thread(new Runnable() {
                    public void run() {
                        System.out.println("我来自Runnable");
                    }
                }) {
            @Override
            public void run(){
                System.out.println("我来自Thread");
            }
        }.start();
    }
}

// 结果是我来自Thread
// 从面向对象的思想去思考
// 重写的run方法已经被“我来自Thread覆盖了”