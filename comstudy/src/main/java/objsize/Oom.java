package objsize;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class Oom {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(1);
        service.execute(()->{
            try {
                for (int j = 0; j < 100; j++) {
                    List<String> list = new ArrayList<>();
                    for (int i = 0; i < Integer.MAX_VALUE; i++) {
//                    try {
//                        Thread.sleep(30);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                        list.add(UUID.randomUUID().toString());
                        System.out.println("thread name:" + Thread.currentThread().getName() + ",list size:" + list.size());

                    }
                }
            }catch (Error error){
                error.getMessage();
            }
        });

        sleep(15000);
        service.execute(()->{
            try {

            System.out.println("hello");
            }catch (Exception e){

            }
        });


    }
}
