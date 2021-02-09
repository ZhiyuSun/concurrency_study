package threadcoreknowledge.createthreads;

/**
 * @Description: 用Thread方式实现线程
 * @CreateDate: 2021/2/6 16:02
 */
public class ThreadStyle extends Thread{
    public static void main(String[] args) {
        new ThreadStyle().start();
    }

    @Override
    public void run(){
        System.out.println("用Thread类实现线程");
    }
}
