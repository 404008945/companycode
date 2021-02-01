package load;

public class JVMTest {
    public static void main(String[] args) {
        byte[] b=null;
        for(int i=0;i<5;i++) {
            System.out.println("开始分配   "+i);
            b = new byte[1024 * 1000];
        }
    }
}
