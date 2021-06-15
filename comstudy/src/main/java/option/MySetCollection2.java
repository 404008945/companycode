package option;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

// A set   T String
public class MySetCollection2<T> implements Collector<T, Set<T>, Map<T, T>> {

    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("suppliier invoked!");

        return () -> {
            // 查看中间容器有几个
            System.out.println("supplier ------------------");
            return new ConcurrentHashMap<T,T>().newKeySet();
        };
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accmulator invoked!");

        return (set, item)->{
            // 开启并发， 打印 set 有几率产生异常 ConcurrentModificationException
            // 异常原因在于，一个在遍历，一个在添加，导致异常
            System.out.println("accumulatro:"+ set + ", " +Thread.currentThread().getName());
            set.add(item);
        };
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner invoked!");

        return (set1, set2) ->{
            System.out.println("set1："+ set1);
            System.out.println("set2："+ set2);
            set1.addAll(set2);
            return set1;
        };
    }

    @Override
    public Function<Set<T>, Map<T, T>> finisher() {//转换结果类型
        System.out.println("finisher invoked!");

        return set -> {
            Map<T, T> map = new ConcurrentHashMap<>(set.size());
            set.forEach(item -> map.put(item, item));
            return map;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics invoked!");

        // 通过添加 CONCURRENT UNORDERED IDENTITY_FINISH 来看差异
        // Characteristics.CONCURRENT Characteristics.UNORDERED Characteristics.IDENTITY_FINISH
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.CONCURRENT));
    }

    public static void main(String[] args) {
        for(int i = 0; i< 100; i++){
            List<String> list = Arrays.asList("hello", "world", "welcome", "hello", "a", "b", "c", "d", "e", "f", "g");
            Set<String> set = new HashSet<>();
            set.addAll(list);
//        Map<String, String> map = set.parallelStream().collect(new MySetCollection2<>());
            // 并行流，与上面等价
            Map<String, String> map = set.stream().parallel().collect(new MySetCollection2<>());
            // 串行流
//        Map<String, String> map = set.stream().sequential().collect(new MySetCollection2<>());
            System.out.println(map);
        }
    }
}
