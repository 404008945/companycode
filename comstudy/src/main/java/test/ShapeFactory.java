package test;

import java.util.*;

public abstract class ShapeFactory {
    // 创建 “形状 ”实例的方法，
    protected abstract Shape create();
    // 然后是一个Map类型的静态变量，用来存放具体工厂的实现以及他们的ID号
    private static Map factories = new HashMap();

    //增加一个具体工厂的实现
    public static void addFactory(String id, ShapeFactory f) {
        factories.put(id, f);
    }

    public static Shape createShape(String id){
        if (!factories.containsKey(id)){
            try{
                String location = "test." + id +"$Factory";

                Class.forName(location);
            } catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException("Bad shape creation : " + id);
            }
        }
        return ((ShapeFactory)factories.get(id)).create();
    }
}
