package interrupt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.lang.Thread.sleep;

public class InterruptionInJava implements Runnable{

    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(1);
        service.submit(new InterruptionInJava(),"InterruptionInJava");
        sleep(1000);
        service.shutdownNow();


    }

    @Override
    public void run() {
        while(true){
            if(Thread.currentThread().isInterrupted()){
                System.out.println("Yes,I am interruted,but I am still running");

            }else{
                System.out.println("not yet interrupted");
            }
        }
    }
}