package refrence;

import java.lang.ref.WeakReference;

public class WeakRef {
    public static void main(String[] args) {
        String str=new String("abc");
        WeakReference<String> abcWeakRef = new WeakReference<String>(str);//此时一个强引用，一个弱引用都在引用这个对象
        str=null;
    }
}
