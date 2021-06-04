package resort;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ReorderExample {
    int a = 0;
    boolean flag = false;
    public void writer() {
        a = 1;                   //1
        flag = true;             //2
    }
    public void reader() {
        if (flag) {                //3
            int i =  a * a;        //4
         //   System.out.println(i);
            if(i== 0){
                System.out.println("排序了");
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(8);
        for(int i=0;i<10000000;i++) {
            ReorderExample reorderExample = new ReorderExample();
            service.execute(() -> {
                reorderExample.writer();
            });
            service.execute(() -> {
                reorderExample.reader();
            });
        }
    }
}