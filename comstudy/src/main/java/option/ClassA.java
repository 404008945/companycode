package option;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class ClassA {

    String id;
    String realName;

    public ClassA(String id, String realName) {
        this.id = id;
        this.realName = realName;
    }

    @Override
    public String toString() {
        return "ClassA{" +
                "id='" + id + '\'' +
                ", realName='" + realName + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getRealName() {
        return realName;
    }



    public static void main(String[] args) {
        List<ClassA> aList = new ArrayList<>(Arrays.asList(
                new ClassA("1", "张三"),
                new ClassA("2", "李四"),
                new ClassA("3", "王五")
        ));
        List<ClassB> bList = new ArrayList<>(Arrays.asList(
                new ClassB("2", "李某"),
                new ClassB("3", "王某"),
                new ClassB("4", "赵某"),
                new ClassB("4", "小王")
        ));

        List<ClassB> result = bList.stream()
                .collect(
                        collectingAndThen(
                                toCollection(
                                        () -> new TreeSet<>(comparing(ClassB::getId))
                                ),
                                (t)->{
                                    return new ArrayList<>(t);
                                }
                        )
                );

//        System.out.println(result);
//        Map<String, Long> personGroups = bList.stream().
//                collect(Collectors.groupingBy(ClassB::getId,counting()));
//
//        Map<String, ClassB> hashMap =   bList.stream().collect(() -> new HashMap<>(),
//                (map ,p) ->map.put(p.getId(),p),(m ,n) -> {});
//        bList.parallelStream().reduce(new HashMap<>(),
//                (map ,p) ->{map.put(p.getId(),p)
//                ;  return map; },(m ,n) ->null);
//        System.out.println(personGroups);
//        System.out.println(hashMap);

        List<ClassB> bs =  bList.stream().filter(distinctByKey(it->it.getId())).collect(Collectors.toList());
        System.out.println(bs);
     // aList.stream().filter(it->bList.stream().map(obj->obj.id).anyMatch(obj->obj == it.id)).distinct().collect(Collectors.toList());

    }

    public int[] intersection(int[] nums1, int[] nums2) {
       return   Arrays.stream(nums1).filter(it-> Arrays.stream(nums2).anyMatch(obj->obj == it)).distinct().toArray();
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
}
