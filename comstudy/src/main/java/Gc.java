public class Gc {

    public static void main(String[] args) {

        byte[] a = new byte[3 * 1024 * 1024];
        byte[] b = new byte[2 * 1024 * 1024];
        byte[] c = new byte[3 * 1024 *  1024];
        byte[] d = new byte[2 * 1024 * 1024];
        System.out.println("first allocate");
        b=null;
        d=null;

        byte e[]  = new byte[4* 1024 * 1024];//与cms并发标记同时执行,讲道理现在应该Concurrent Mode Failure 为什么没有？
        System.out.println("second allocate");
    }
}
