package synchronizedknowledge.recursion;

/**
 * @Description: 可重入粒度测试：调用类内另外的方法
 * @Author: sunzhiyu
 * @CreateDate: 2021/2/8 15:33
 */
public class SynchronizeOtherMethod11 {

    public static void main(String[] args) {
        SynchronizeOtherMethod11 synchronizeRecursion11 = new SynchronizeOtherMethod11();
        synchronizeRecursion11.method1();
    }

    private synchronized void method1(){
        System.out.println("这是method1");
        method2();
    }

    private synchronized void method2(){
        System.out.println("这是method2");
    }

}

// 输出
// 这是method1
//这是method2