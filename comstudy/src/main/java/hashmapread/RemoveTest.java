package hashmapread;

import java.util.*;

public class RemoveTest {

    public static void main(String[] args) {
        List<String> all = new ArrayList<String>();
        all.add("a");
        all.add("b");
        all.add("c");
        all.add("d");

        Iterator<String> iterator=all.iterator();//实例化迭代器
        while(iterator.hasNext()){
            String str=iterator.next();//读取当前集合数据元素
            if("b".equals(str)){
                iterator.remove();
            }else{
                System.out.println( str+" ");
            }
        }
        System.out.println("\n删除\"b\"之后的集合当中的数据为:"+all);
    }
}
