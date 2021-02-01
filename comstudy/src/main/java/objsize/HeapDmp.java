package objsize;

import static java.lang.Thread.sleep;

public class HeapDmp {
    int b  = 10;
    public void  say(){

    }
    class A{
        int a[] = new int[1000];
    }
    public static void main(String[] args) {
        HeapDmp heapDmp = new HeapDmp();
        A []  a = new A[10000];
        System.out.println(heapDmp.new A());
        System.out.println(heapDmp.new A());
        for(int  i=0 ;i<a.length;i++){
            a[i] = heapDmp.new A();
        }
        try {
            sleep(1000*3600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
