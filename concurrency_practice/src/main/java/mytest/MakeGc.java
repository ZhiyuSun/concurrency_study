package mytest;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

/**
 * @Description:
 * @Author: sunzhiyu
 * @CreateDate: 2021/2/23 20:09
 */
public class MakeGc {
    private static Random random = new Random();
    public static void main(String[] args) {
        // 当前毫秒时间戳
        long startMillis = System.currentTimeMillis();
        // 持续运行毫秒数; 可根据需要进行修改
        long timeoutMillis = TimeUnit.SECONDS.toMillis(1);
        // 结束时间戳
        long endMillis = startMillis + timeoutMillis;
        LongAdder counter = new LongAdder();
        System.out.println("正在执行...");
        // 缓存一部分对象; 进入老年代
        int cacheSize = 2000;
        Object[] cachedGarbage = new Object[cacheSize];
        // 在此时间范围内,持续循环
        while (System.currentTimeMillis() < endMillis) {
            int randomSize = random.nextInt(100*1024);
            String result = null;

            StringBuilder builder = new StringBuilder();
            String randomString = "randomString-Anything";
            while (builder.length() < randomSize) {
                builder.append(randomString);
                builder.append(randomSize);
            }
            result = builder.toString();
            counter.increment();
            int randomIndex = random.nextInt(cacheSize);
            if (randomIndex < cacheSize) {
                cachedGarbage[randomIndex] = result;
            }
        }
        System.out.println("执行结束!共生成对象次数:" + counter.longValue());
    }
}

// javac -encoding utf-8 MakeGc.java
// java -Xmx256m -Xms256m -XX:+PrintGCDetails -XX:+UseParallelGC -XX:+PrintGCDateStamps mytest.MakeGc