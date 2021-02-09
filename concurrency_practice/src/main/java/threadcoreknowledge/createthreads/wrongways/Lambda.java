package threadcoreknowledge.createthreads.wrongways;

/**
 * @Description: lambda表达式创建线程
 * @Author: sunzhiyu
 * @CreateDate: 2021/2/6 16:52
 */
public class Lambda {
    public static void main(String[] args) {
        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
    }
}
