import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

class MyRun implements Runnable {

    private long start;

    public MyRun() {
        this.start = System.currentTimeMillis();
    }

    public void run() {
        long time = System.currentTimeMillis() - start;
        System.out.println("--"+Thread.currentThread().getName()+"开始运行run0  time=="+time);
        time = System.currentTimeMillis() - start;
        System.out.println("======="+Thread.currentThread().getName()+"结束run0          time=="+time);
    }
}
class MyRun1 implements Runnable {

    private long start;

    public MyRun1() {
        this.start = System.currentTimeMillis();
    }


    public void run() {
        long time = System.currentTimeMillis() - start;
        System.out.println("--"+Thread.currentThread().getName()+"开始运行run1  time=="+time);
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        time = System.currentTimeMillis() - start;
        System.out.println("======="+Thread.currentThread().getName()+"结束run1          time=="+time);
    }
}


class MThreadFactory implements ThreadFactory {
    private int sequenceNumber = 0;


    public Thread newThread(Runnable r) {
        return new Thread(r, "线程"+(++sequenceNumber));
    }
}

public class ScheduledExecutorServiceTest {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(2,new MThreadFactory());
        MyRun run = new MyRun();
        MyRun1 run1 = new MyRun1();
        //等待队列同一时刻只能被一个人leader线程取等待队列中的数据也就是说，我在等待一个时间，其他线程是没办法取任务的，但是他还有一个算法，每次只能取等待时间最小的保证率不对出现多余等待的情况
        service.scheduleAtFixedRate(run, 0, 100, TimeUnit.MILLISECONDS);
        service.scheduleAtFixedRate(run1,0,1000,TimeUnit.MILLISECONDS);
    }
}