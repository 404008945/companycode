package psafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class Test {
     int val = 0;
     boolean lock = false;
    public void test(){
        synchronized (this) {
            while (lock ==true) {

            }

            lock = true;
        }
        val++;
        lock = false;
    }

    public static void main(String[] args) throws InterruptedException {
            Test test = new Test();
            ExecutorService executorService = Executors.newFixedThreadPool(32);

            for (int i = 0; i < 32; i++) {
                executorService.execute(() -> {
                    for (int j = 0; j < 1000; j++) {
                        test.test();
                    }
                });
            }
            sleep(5000);
            System.out.println(test.val);
            if(test.val%32000!=0){
                System.out.println("逮到了");
             //   break;
            }

        sleep(50000);
    }

}
