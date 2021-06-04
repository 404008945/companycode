package daili.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

public class CglibProxyTest {

    public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        // 生成class类的路径
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E://tmp");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Student.class);
        enhancer.setCallback(new CglibProxy());

        Student student = (Student) enhancer.create();
        student.say();
    }
}