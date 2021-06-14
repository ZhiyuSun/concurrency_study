package mytest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: sunzhiyu
 * @CreateDate: 2021/2/22 15:25
 */
public class MakeOomHeap {
    static class OOMObject {
    }

    public static void main(String[] args) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();

        while(true) {
//            TimeUnit.MILLISECONDS.sleep(1);
            list.add(new OOMObject());
        }
    }
}

/// Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
//	at java.util.Arrays.copyOf(Arrays.java:3210)
//	at java.util.Arrays.copyOf(Arrays.java:3181)
//	at java.util.ArrayList.grow(ArrayList.java:267)
//	at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:241)
//	at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:233)
//	at java.util.ArrayList.add(ArrayList.java:464)
//	at mytest.MakeOom.main(MakeOom.java:20)

// 为了尽快制造oom,可以设置idea的vm options: -Xmx100m

// 参考资料：https://www.cnblogs.com/huangqingshi/p/13336648.html