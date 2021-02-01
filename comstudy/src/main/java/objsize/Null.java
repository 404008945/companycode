package objsize;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Null {

    //内部类
    static class  RunTest implements Runnable{

        @Override
        public void run() {
            Obj a = null;
            a.getAddr();
        }
    }
    public static void main(String[] args) {

        String test = null;
        int i = 0;
        while (true)
        {
            try
            {
                test.length();
            }
            catch (Exception e)
            {
                System.out.println("次数为:" + i++ + "，堆栈长度为:" + e.getStackTrace().length);
                //log.error("StackTrace is ",e);
                if (e.getStackTrace().length == 0)
                {
                    System.out.println("no StackTrace is "+ e);
                    break;
                }
            }
        }
    }
}
