package objsize;

import java.lang.ref.SoftReference;

public class GCDetailsAnalyze {

    public static void main(String[] args) {

        SoftReference<byte[]> softReference = new SoftReference<>(new byte[5 * 1024 * 1024]);
        System.out.println("first");
        System.gc();
        System.out.println("gc");
        byte[] bytes = new byte[6 * 1024 * 1024];
        System.out.println("second");

    }
}
