package synchronizedknowledge.recursion;

/**
 * @Description: 可重入粒度测试：递归调用本方法
 * @Author: sunzhiyu
 * @CreateDate: 2021/2/8 15:33
 */
public class SynchronizeRecursion10 {
    int  a = 0;

    public static void main(String[] args) {
        SynchronizeRecursion10 synchronizeRecursion10 = new SynchronizeRecursion10();
        synchronizeRecursion10.method1();
    }

    private synchronized void method1(){
        System.out.println("这是method1, a=" + a);
        if (a==0){
            a++;
            method1();
        }
    }
}

// 输出
// 这是method1, a=0
//这是method1, a=1