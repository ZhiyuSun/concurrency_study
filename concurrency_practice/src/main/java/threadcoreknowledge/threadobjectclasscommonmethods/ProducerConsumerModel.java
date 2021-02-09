package threadcoreknowledge.threadobjectclasscommonmethods;

import java.util.Date;
import java.util.LinkedList;

/**
 * @Description: 用wait/notify来实现生产者消费者模式
 * @Author: sunzhiyu
 * @CreateDate: 2021/2/9 11:38
 */
public class ProducerConsumerModel {
    public static void main(String[] args) {
        EventStorage eventStorage = new EventStorage();
        Producer producer = new Producer(eventStorage);
        Consumer consumer = new Consumer(eventStorage);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}

class Producer implements Runnable {

    private EventStorage storage;

    public Producer(
            EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.put();
        }
    }
}

class Consumer implements Runnable {

    private EventStorage storage;

    public Consumer(
            EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.take();
        }
    }
}

class EventStorage {

    private int maxSize;
    private LinkedList<Date> storage;

    public EventStorage() {
        maxSize = 10;
        storage = new LinkedList<>();
    }

    public synchronized void put() {
        while (storage.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.add(new Date());
        System.out.println("仓库里有了" + storage.size() + "个产品。");
        notify();
    }

    public synchronized void take() {
        while (storage.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("拿到了" + storage.poll() + "，现在仓库还剩下" + storage.size());
        notify();
    }
}

// 输出
// 仓库里有了1个产品。
//仓库里有了2个产品。
//仓库里有了3个产品。
//仓库里有了4个产品。
//仓库里有了5个产品。
//仓库里有了6个产品。
//仓库里有了7个产品。
//仓库里有了8个产品。
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下7
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下6
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下5
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下4
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下3
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下2
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下1
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下0
//仓库里有了1个产品。
//仓库里有了2个产品。
//仓库里有了3个产品。
//仓库里有了4个产品。
//仓库里有了5个产品。
//仓库里有了6个产品。
//仓库里有了7个产品。
//仓库里有了8个产品。
//仓库里有了9个产品。
//仓库里有了10个产品。
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下9
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下8
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下7
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下6
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下5
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下4
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下3
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下2
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下1
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下0
//仓库里有了1个产品。
//仓库里有了2个产品。
//仓库里有了3个产品。
//仓库里有了4个产品。
//仓库里有了5个产品。
//仓库里有了6个产品。
//仓库里有了7个产品。
//仓库里有了8个产品。
//仓库里有了9个产品。
//仓库里有了10个产品。
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下9
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下8
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下7
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下6
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下5
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下4
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下3
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下2
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下1
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下0
//仓库里有了1个产品。
//仓库里有了2个产品。
//仓库里有了3个产品。
//仓库里有了4个产品。
//仓库里有了5个产品。
//仓库里有了6个产品。
//仓库里有了7个产品。
//仓库里有了8个产品。
//仓库里有了9个产品。
//仓库里有了10个产品。
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下9
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下8
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下7
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下6
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下5
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下4
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下3
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下2
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下1
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下0
//仓库里有了1个产品。
//仓库里有了2个产品。
//仓库里有了3个产品。
//仓库里有了4个产品。
//仓库里有了5个产品。
//仓库里有了6个产品。
//仓库里有了7个产品。
//仓库里有了8个产品。
//仓库里有了9个产品。
//仓库里有了10个产品。
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下9
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下8
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下7
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下6
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下5
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下4
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下3
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下2
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下1
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下0
//仓库里有了1个产品。
//仓库里有了2个产品。
//仓库里有了3个产品。
//仓库里有了4个产品。
//仓库里有了5个产品。
//仓库里有了6个产品。
//仓库里有了7个产品。
//仓库里有了8个产品。
//仓库里有了9个产品。
//仓库里有了10个产品。
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下9
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下8
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下7
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下6
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下5
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下4
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下3
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下2
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下1
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下0
//仓库里有了1个产品。
//仓库里有了2个产品。
//仓库里有了3个产品。
//仓库里有了4个产品。
//仓库里有了5个产品。
//仓库里有了6个产品。
//仓库里有了7个产品。
//仓库里有了8个产品。
//仓库里有了9个产品。
//仓库里有了10个产品。
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下9
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下8
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下7
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下6
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下5
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下4
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下3
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下2
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下1
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下0
//仓库里有了1个产品。
//仓库里有了2个产品。
//仓库里有了3个产品。
//仓库里有了4个产品。
//仓库里有了5个产品。
//仓库里有了6个产品。
//仓库里有了7个产品。
//仓库里有了8个产品。
//仓库里有了9个产品。
//仓库里有了10个产品。
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下9
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下8
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下7
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下6
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下5
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下4
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下3
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下2
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下1
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下0
//仓库里有了1个产品。
//仓库里有了2个产品。
//仓库里有了3个产品。
//仓库里有了4个产品。
//仓库里有了5个产品。
//仓库里有了6个产品。
//仓库里有了7个产品。
//仓库里有了8个产品。
//仓库里有了9个产品。
//仓库里有了10个产品。
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下9
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下8
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下7
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下6
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下5
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下4
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下3
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下2
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下1
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下0
//仓库里有了1个产品。
//仓库里有了2个产品。
//仓库里有了3个产品。
//仓库里有了4个产品。
//仓库里有了5个产品。
//仓库里有了6个产品。
//仓库里有了7个产品。
//仓库里有了8个产品。
//仓库里有了9个产品。
//仓库里有了10个产品。
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下9
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下8
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下7
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下6
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下5
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下4
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下3
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下2
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下1
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下0
//仓库里有了1个产品。
//仓库里有了2个产品。
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下1
//拿到了Tue Feb 09 11:45:40 CST 2021，现在仓库还剩下0

// 可以交错着执行