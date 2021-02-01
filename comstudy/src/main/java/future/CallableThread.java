package future;


import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

//	修改 Callable<?> 里的参数类型
public class CallableThread implements Callable<String> {

    int key;
    private String value;		// 	返回的参数类型
    private final CountDownLatch latch;

    public CallableThread(int key, CountDownLatch latch) {
        this.key = key;
        this.latch = latch;
    }

    public String call() throws Exception {
        try {
            //	处理业务。
            value = "处理完返回的值" + key;
            System.out.println("线程：" + Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            latch.countDown();
        }
        return value;

    }
}