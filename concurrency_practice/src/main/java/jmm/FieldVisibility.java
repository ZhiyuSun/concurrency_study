package jmm;

/**
 * @Description: 演示可见性带来的问题
 * @Author: sunzhiyu
 * @CreateDate: 2021/2/13 22:07
 */
public class FieldVisibility {
    volatile int a = 1;
    volatile int b = 2;

    private void change() {
        a = 3;
        b = a;
    }


    private void print() {
        System.out.println("b=" + b + ";a=" + a);
    }

    public static void main(String[] args) {
        while (true) {
            FieldVisibility test = new FieldVisibility();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.change();
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.print();
                }
            }).start();
        }

    }
}

// output
// 四种情况
// b=3,a=3
// b=2,a=3
// b=2,a=1

// 极少情况下发生：
// b=3,a=1