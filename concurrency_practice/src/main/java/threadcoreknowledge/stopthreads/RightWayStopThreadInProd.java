package threadcoreknowledge.stopthreads;

/**
 * @Description: 最佳实践：catch了InterruptedExcetion之后的优先选择：在方法签名中抛出异常 那么在run()就会强制try/catch
 * @Author: sunzhiyu
 * @CreateDate: 2021/2/6 23:59
 */
public class RightWayStopThreadInProd implements Runnable{
    @Override
    public void run() {
        while (true && !Thread.currentThread().isInterrupted()) {
            System.out.println("go");
            // 强制try catch进行处理，不能再往上抛出了
            // 检查这个函数里是否有中断，处理完善的善后逻辑
            try {
                throwInMethod();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                //保存日志、停止程序
                System.out.println("保存日志");
                e.printStackTrace();
            }
        }
    }

    private void throwInMethod() throws InterruptedException {
        // 这里不能把异常给吞掉，要抛出，由顶层的调用方去处理
        Thread.sleep(2000);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
