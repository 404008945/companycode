package load;

import com.google.common.collect.Sets;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author pibigstar
 * @desc
 **/
public class MyClassLoaderTest {
    static {
        System.out.println("第一次加载");
    }
    public void printVersion() {
        System.out.println("版本号4");
    }
    public static void main(String[] args){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                // target/classes/com/pibgstar/demo/java/swap/
                String swapPath = MyClassLoader.class.getResource("").getPath();
                String className = "load.Test";
                // 创建自定义的类加载器，将路径和需要我们自己去加载的类名传递进去
                MyClassLoader myClassLoader = new MyClassLoader(swapPath, Sets.newHashSet(className));
                try {
                    //使用自定义的ClassLoader加载类，并调用printVersion方法。
                    myClassLoader.loadClass(className);//这样加载类会触发初始化吗
                    myClassLoader.loadClass(className,true);
                 //  Class.forName(className);
                    MyClassLoaderTest o = new MyClassLoaderTest();
                    o.getClass().getClassLoader().loadClass(className);
                  o.printVersion();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },0,2000);
    }
}
