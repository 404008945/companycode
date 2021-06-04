package iterator;

import java.util.*;

public class IterorTest {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        System.out.println("开始添加元素 size:" + list.size());

        for (int i = 0; i < 100; i++) {
            list.add(i + 1);
        }

        System.out.println("元素添加结束 size:" + list.size());

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next % 5 == 0) {
                iterator.remove();
            }
        }
        System.out.println("执行结束 size:" + list.size());
    }
}
