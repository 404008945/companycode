package solution;

import java.util.Arrays;

import static java.lang.Thread.sleep;

public class FindMaxForm  {
    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hello");
            }
        });
        t.start();
        t.join();
        System.out.println("world");
        t.start();

        synchronized (A.class){
            A.class.wait();
        }
    }
    static  class  A{


    }

}
