package objsize;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.openjdk.jol.info.ClassLayout;

public class HSDBTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("first");
        Obj o = new Obj(20, 175, false, "小明", "浙江杭洲", "男");
        System.out.println(o.getClass().toString());
        System.out.println(o.toString());
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        Thread.sleep(1000 * 3600);
        System.out.println(o);
    }

}
