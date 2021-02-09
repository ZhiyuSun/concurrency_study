package synchronizedknowledge.recursion;

/**
 * @Description: 可重入粒度测试：调用父类的方法
 * @Author: sunzhiyu
 * @CreateDate: 2021/2/8 15:33
 */
public class SynchronizeSuperClass12 {

    public synchronized void doSomething() {
        System.out.println("我是父类方法");
    }
}

class TestClass extends SynchronizeSuperClass12{
    @Override
    public synchronized void doSomething(){
        System.out.println("我是子类方法");
        super.doSomething();
    }

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        testClass.doSomething();
    }
}


// 输出
// 我是子类方法
//我是父类方法