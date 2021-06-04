package hashmapread;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class TestHahMap {
    public static void main(String[] args) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        for(int i=0;i<8;i++){
            executorService.execute(()->{
                for(int j=0;j<1000;j++){
                    hashMap.put(UUID.randomUUID().toString(),j);
                }
            });
        }
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hashMap.entrySet();
        System.out.println(hashMap.size());
    }
}
