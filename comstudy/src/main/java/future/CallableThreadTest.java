package future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableThreadTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        int taskNum = 10;		//	这里控制任务数量
        int threadNum = 2;		//	这是默认的线程数量
        threadNum = threadNum > taskNum ? taskNum : threadNum;

        final CountDownLatch latch = new CountDownLatch(taskNum);//线程数
        ExecutorService pool = Executors.newFixedThreadPool(threadNum);
            List<Future> list = new ArrayList();
            for (int i = 0;  i < taskNum; i++) {//提交任务
                Callable<String> c1 = new CallableThread(i, latch);
                Future<String> f1 = pool.submit(c1);
                list.add(f1);
        }
        latch.await();
        //所有任务已成功
        // 输出返回值
        List<String> ans = new ArrayList<String>();
        list.forEach(i-> {
            try {
                ans.add((String) i.get());
            } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    });
        System.out.println("list：" + ans);

    }

}