package threadcoreknowledge.startthread;

/**
 * @Description: 演示不能两次调用start方法，否则会报错
 * @Author: sunzhiyu
 * @CreateDate: 2021/2/6 19:56
 */
public class CantStartTwice {
    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();
        thread.start();
    }
}
