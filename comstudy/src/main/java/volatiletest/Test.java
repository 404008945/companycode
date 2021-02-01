package volatiletest;

import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class Test {
    static int  a = 0;
    public static void main(String[] args) {
        Executors.newFixedThreadPool(1).execute(()->{
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a=1;
            System.out.println(a);
        });
        Executors.newFixedThreadPool(1).execute(()->{
            System.out.println(a);
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(a);
        });
    }
}
