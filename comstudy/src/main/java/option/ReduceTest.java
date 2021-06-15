package option;

import com.google.common.collect.Lists;
import lombok.Data;
import objsize.Person;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
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

//        Map map =  Stream.of(
//                new Person("张三", 22, 175)
//                , new Person("李四", 22, 177)
//                , new Person("张三", 14, 165)
//                , new Person("李四", 15, 166)
//                , new Person("张三", 19, 182)
//        ).collect(Collectors.toMap(Person::getName,Person::getAge));

        //利用filter去重
     List l =  Stream.of(
                new Person("张三", 22, 175)
                , new Person("李四", 22, 177)
                , new Person("张三", 14, 165)
                , new Person("李四", 15, 166)
                , new Person("张三", 19, 182)
        ).filter(myfilter(new TreeSet<Person>((o1, o2) -> o1.getAge()-o2.getAge()))).collect(Collectors.toList());
        System.out.println(l);
        l.stream().collect(groupingBy(Person::getAge));
     //   System.out.println(s1);
        Stream<String> stream1 = Stream.of("a", "b", "c");
        Stream<String> stream2 = Stream.of("x", "y", "z");
        Stream.concat(stream1,stream2).forEach(ReduceTest::test);
        // 通过concat方法将两个流合并为一个新的流
//        List<ScoreBean> list= Lists.newArrayList(
//                new ScoreBean("张三",1)
//                ,new ScoreBean("李四",2)
//                ,new ScoreBean("王五",3)
//                ,new ScoreBean("小明",4)
//                ,new ScoreBean("小红",5));
////        Integer total=list.stream()
////                .reduce(
////                        Integer.valueOf(0)  /*初始值 identity*/
////                        ,(integer,scoreBean)->integer+scoreBean.getScore() /*累加计算 accumulator*/
////                        ,(integer1,integer2)->integer1+integer2 /*第三个参数 combiner*/
////                );
////        System.out.println(total);//结果：15
//     int nums1[] = {4,9,5};
//     int nums2[] = {9,4,9,8,4};
//     int []ans = intersect(nums1,nums2);
//        System.out.println(intersect(nums1,nums2));
        // 收集到 Set集合中
        Set<String> set = Stream.of("aa", "bb", "cc", "aa")
                .collect(Collectors.toSet());
        System.out.println(set);
        // 如果需要获取的类型为具体的实现，比如：ArrayList HashSet

        ArrayList<String> arrayList = Stream.of("aa", "bb", "cc", "aa")
                //.collect(Collectors.toCollection(() -> new ArrayList<>()));
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(arrayList);
        HashSet<String> hashSet = Stream.of("aa", "bb", "cc", "aa")
                .collect(Collectors.toCollection(HashSet::new));
        System.out.println(hashSet);
        String[] strings = Stream.of("aa", "bb", "cc", "aa")
                .toArray(String[]::new);
        System.out.println(Arrays.toString(strings));

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

    //利用fileter去重
    public static <T> Predicate<? super T> myfilter(TreeSet<T> set){
        //写一个局部对象传进lamda表达式
        return (o)-> set.add(o);
    }
    static void test(String a){

    }
}
