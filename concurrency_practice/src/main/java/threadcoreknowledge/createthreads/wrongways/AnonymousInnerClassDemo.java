package threadcoreknowledge.createthreads.wrongways;

/**
 * @Description: 匿名内部类的方式
 * @Author: sunzhiyu
 * @CreateDate: 2021/2/6 16:51
 */
public class AnonymousInnerClassDemo {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.start();
        new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
    }
}
