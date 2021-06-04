package gctest;

public class GC1 {
    private static final int _1MB = 1024 * 1024;

    /*** VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8*/
    public static void testAllocation() {
     Boolean a = null;
     boolean f =a;
        System.out.println(f);
    }


    public static void main(String[] args) {
        testAllocation();
    }
}
