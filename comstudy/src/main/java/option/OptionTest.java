package option;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;

public class OptionTest {

    public static void main(String[] args) {

//        HashMap map =  new HashMap();
//        // 如果没有值，默认值
//        Optional<String> emptyOptional = Optional.empty();
//        System.out.println("空Optional.orElse");
//        String orElse = emptyOptional.orElse(getDefault());
//        System.out.println("空Optional.orElseGet");
//        String orElseGet = emptyOptional.orElseGet(() -> getDefault());
//        System.out.println("空Optional.orElse结果："+orElse);
//        System.out.println("空Optional.orElseGet结果："+orElseGet);
//        System.out.println("--------------------------------");
//        // 如果没有值，默认值
//        Optional<String> stringOptional = Optional.of("hello");
//        System.out.println("有值Optional.orElse");
//        orElse = stringOptional.orElse(getDefault());
//        System.out.println("有值Optional.orElseGet");
//        orElseGet = stringOptional.orElseGet(() -> getDefault());
//        System.out.println("有值Optional.orElse结果："+orElse);
//        System.out.println("有值Optional.orElseGet结果："+orElseGet);
//
//        Stream.of("apple","banana","orange","waltermaleon","grape")
//                .map(String::isEmpty) //转成单词的长度 int
//                .collect(Collectors.toList());

//        List<String> list = Arrays.asList("tom", "jame", "jerry", "hello");
//        Stream<String> stream = list.stream();//泛型为流的基本单位
//        Stream<String[]> streamString = stream.map(s->s.split(""));
//        Stream<Stream<String>> map = streamString.map(Arrays::stream);
//
//        // List<Stream<String>> collect = map.collect(Collectors.toList());
//        // System.out.println(collect);
//
//        map.forEach(x->{
//            x.forEach(s->{
//                System.out.println(s);
//            });
//        });


//        List<String> list = Arrays.asList("tom", "jame", "jerry", "hello");
//        list.stream().flatMap(it-> Arrays.stream(it.split(""))).forEach(it-> System.out.println(it));
//        list.stream().map(it-> Arrays.stream(it.split(""))).forEach(
//                it->it.forEach(
//                        s-> System.out.println(s)
//                )
//        );
//
//
//        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
//        List<String> strs = Arrays.asList("232", "143", "333");
//        List<Integer> numbers2 = Arrays.asList(3, 4);
//        // flatMap升维度
//        List<int[]> pairs = numbers1.stream().flatMap(x -> numbers2.stream().map(y -> new int[] { x, y }))
//                .collect(Collectors.toList());
//        for (int[] pair : pairs) {
//            System.out.println(Arrays.toString(pair));
//        }
//
//        Stream.of(1,2,3,1,2,5,6,7,8,0,0,1,2,3,1)
//                .distinct() //去重
//                .forEach(e->System.out.println(e));
//
//        Stream.of(1,2,3,1,2,5,6,7,8,0,0,1,2,3,1).collect(Collectors.toList());

//
//        boolean result = Stream.of("aa","bb","cc","aa")
//                .anyMatch(e->e.equals("aa"));
//        System.out.println(result);


//        List<String> strings = Arrays.asList("a", "bb", "cc", "ddd","a");
//
//        Map<String, List<String>> result = strings.stream()
//                .collect(groupingBy(it->it));
//
//        System.out.println(result); // {1=[a], 2=[bb, cc], 3=[ddd]}
//        ArrayList<Integer> newList = new ArrayList<>();
//
//        ArrayList<Integer> accResult_ = Stream.of(2, 3, 4)
//                .reduce(newList,
//                        (acc, item) -> {
//                            acc.add(item);
//                            System.out.println("item: " + item);
//                            System.out.println("acc+ : " + acc);
//                            System.out.println("BiFunction");
//                            return acc;
//                        }, (acc, item) -> null);
//        System.out.println("accResult_: " + accResult_);
//
//
//        List<BigDecimal> list = new ArrayList<>();
//        BigDecimal a = new BigDecimal("10");
//        list.add(a);
//        BigDecimal b = new BigDecimal("20");
//        list.add(b);
//        BigDecimal c = new BigDecimal("30");
//        list.add(c);
//        BigDecimal d = new BigDecimal("-10");
//        list.add(d);
//
//        //BigDecimal.ZERO为0，以0为底数和流里的每一个元素相加
//        //求和
//        BigDecimal result = list.stream().reduce(BigDecimal.ZERO, BigDecimal::add);//结果为50
//        System.out.println(result);
//        //亦可写作
//        BigDecimal result1 = list.stream().reduce(BigDecimal.ZERO, (x,y) -> x.add(y));//结果为50
//        System.out.println(result1);
//
//        //求最大值
//        Optional<BigDecimal> max = list.stream().reduce(BigDecimal::max);//结果为30
//        System.out.println(max.get());
//
//        //求最小值
//        BigDecimal min = list.stream().reduce(new BigDecimal(-22),(x,y)->x.min(y));//结果为-10
//        System.out.println(min);
//
//        //各项相乘
//        Optional<BigDecimal> mu = list.stream().reduce(BigDecimal::multiply);//结果为-60000
//        System.out.println(mu.get());
//
//

        String[] arr ={"aa","ccc","sss"};
        System.out.println(Arrays.stream(arr).collect(joining()));
//
//
//
//        Stream<String> stream = list.stream();
//        Stream<String[]> streamString = stream.map(s->s.split(""));
//        Stream<String> map = streamString.flatMap(it-> Arrays.stream(it));
//        List<Map<Integer,String>> maps = new ArrayList<>();
//        Map<Integer,String> m = new HashMap<>();
//        m.put(1,"2");
//        m.put(2,"3");
//        m.put(3,"4");
//        m.put(4,"5");
//        maps.add(m);
//        //map把stream中单元数据 处理成stream
//
//        //想获取map中的所有值
//        List<Integer> ss = maps.stream().flatMap(it->it.keySet().stream()).collect(Collectors.toList());
//        List<Integer> vv = m.values().stream().map(String::length).collect(Collectors.toList());
//
//
//        map.forEach(x->{
//            System.out.println(x);
//        });
//

    }
    public static String getDefault() {
        System.out.println("   获取默认值中..run getDeafult method");
        return "hello";
    }
}
