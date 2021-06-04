package option;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class ReduceTest {
    @Data
    static class ScoreBean {
        private String name; //学生姓名
        private int score;   //分数，需要汇总该字段
        public ScoreBean(String name, int score) {
            this.name = name;
            this.score = score;
        }
        //get 和 set 方法省略
    }

    public static void main(String[] args) {
        List<ScoreBean> list= Lists.newArrayList(
                new ScoreBean("张三",1)
                ,new ScoreBean("李四",2)
                ,new ScoreBean("王五",3)
                ,new ScoreBean("小明",4)
                ,new ScoreBean("小红",5));
//        Integer total=list.stream()
//                .reduce(
//                        Integer.valueOf(0)  /*初始值 identity*/
//                        ,(integer,scoreBean)->integer+scoreBean.getScore() /*累加计算 accumulator*/
//                        ,(integer1,integer2)->integer1+integer2 /*第三个参数 combiner*/
//                );
//        System.out.println(total);//结果：15
     int nums1[] = {4,9,5};
     int nums2[] = {9,4,9,8,4};
     int []ans = intersect(nums1,nums2);
        System.out.println(intersect(nums1,nums2));

    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Long> nums2Map = Arrays.stream(nums2).boxed().collect(groupingBy(Integer::intValue, counting()));
        return Arrays.stream(nums1).boxed().collect(groupingBy(Integer::intValue, counting())).entrySet().stream().filter((it) -> {
            if (nums2Map.get(it.getKey()) == null) {
                return false;
            }
            long val = Math.min(nums2Map.get(it.getKey()), it.getValue());
            it.setValue(val);
            return true;
        }).reduce(new ArrayList<Integer>(), (m, n) -> {
            long c = n.getValue();
            while (c > 0) {
                c--;
                m.add(n.getKey());
            }
            return m;
        }, (o1, o2) -> null).stream().mapToInt(it -> it).toArray();
    }
}
