package objsize;

import static java.lang.Thread.sleep;

public class ThreadDmp {
    class A{
        public synchronized void sayHello(){
            System.out.println("hello");
        }
    }
//死锁是如何产生的
    public static void main(String[] args) {
        ThreadDmp threadDmp = new ThreadDmp();
        A a = threadDmp.new A();
        A b = threadDmp.new A();
        new Thread(()->{
            a.sayHello();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            b.sayHello();
        },"线程1").start();

        new Thread(()->{
            b.sayHello();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a.sayHello();
        },"线程2").start();
    }
}
