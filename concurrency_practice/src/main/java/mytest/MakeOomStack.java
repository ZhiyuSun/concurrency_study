package mytest;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: sunzhiyu
 * @CreateDate: 2021/2/22 15:30
 */
public class MakeOomStack {
    public static void infiniteRun() {
        while(true) {
            Thread thread = new Thread(() -> {

                while (true) {
                    try {
                        TimeUnit.HOURS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        infiniteRun();
    }
}
