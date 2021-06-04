package oom;

import static java.lang.Thread.sleep;

public class StackOom {
    public static void main(String[] args) {
        while (true){
            new Thread(()->{
                long a = 100;
                System.out.println("thread exe");
                try {
                    sleep(1000*3600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
