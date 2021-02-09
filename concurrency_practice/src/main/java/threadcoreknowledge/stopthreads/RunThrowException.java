package threadcoreknowledge.stopthreads;

/**
 * @Description:
 * @Author: sunzhiyu
 * @CreateDate: 2021/2/7 13:52
 */
public class RunThrowException {
    public void aVoid() throws Exception {
        throw new Exception();
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run()  {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
