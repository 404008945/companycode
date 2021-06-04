package executors;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class Exxcutor {
    public static void main(String[] args) {
        //核心线程 1
        ExecutorService service = new ThreadPoolExecutor(1, 3,
                15L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        service.execute(()->{
            System.out.println("hello1");
            try {
                sleep(1000*3600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        service.execute(()->{
            System.out.println("hello2");

        });
        service.execute(()->{
            System.out.println("hello2");

        });

    }
}
