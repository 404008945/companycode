package objsize;

public class Notify {


    public static void main(String[] args) {
        ThreadDmp.A a = new  ThreadDmp().new A();
        synchronized (a){
            try {
                a.getClass().wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
