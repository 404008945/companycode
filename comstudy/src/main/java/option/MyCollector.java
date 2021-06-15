package option;

import lombok.Data;

import java.util.ArrayList;
import java.util.*;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MyCollector<T, A, R>    implements Collector<T, A, R> {
    private final Supplier<A> supplier;
    private final BiConsumer<A, T> accumulator;
    private final BinaryOperator<A> combiner;
    private final Function<A, R> finisher;
    private final Set<Characteristics> characteristics;

    MyCollector(Supplier<A> supplier,
                  BiConsumer<A, T> accumulator,
                  BinaryOperator<A> combiner,
                  Function<A,R> finisher,
                  Set<Characteristics> characteristics) {
        this.supplier = supplier;
        this.accumulator = accumulator;
        this.combiner = combiner;
        this.finisher = finisher;
        this.characteristics = characteristics;
    }

    MyCollector(Supplier<A> supplier,
                  BiConsumer<A, T> accumulator,
                  BinaryOperator<A> combiner,
                  Set<Characteristics> characteristics) {
        this(supplier, accumulator, combiner, castingIdentity(), characteristics);
    }

    @SuppressWarnings("unchecked")
    private static <I, R> Function<I, R> castingIdentity() {
        return i -> (R) i;
    }

    @Override
    public BiConsumer<A, T> accumulator() {
        return accumulator;
    }

    @Override
    public Supplier<A> supplier() {
        return supplier;
    }

    @Override
    public BinaryOperator<A> combiner() {
        return combiner;
    }

    @Override
    public Function<A, R> finisher() {
        return finisher;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return characteristics;
    }

    @Data
    static  class EntryMapper<T1,T2>{
        private T1 key;

        private T2 val;


    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for(int i =1 ;i<=10000;i++){
            list.add(i);
        }
        list = list.parallelStream().collect(MyCollector.toList());
        System.out.println(list.size());
        for(int i =0 ;i<10000;i++){
            System.out.println(list.get(i));
        }
    }


    public static <T>
    Collector<T, ?, List<T>> toList() {
        return new MyCollector<>((Supplier<List<T>>) ArrayList::new, (o1,o2)->{
            System.out.println(o2);
            System.out.println(Thread.currentThread());
            o1.add(o2);
        },
                (left, right) -> { left.addAll(right); return left; },
                Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED,Characteristics.CONCURRENT)));
    }
    public static <T1, T2>
    Collector<EntryMapper<T1, T2>, Map<T1, T2>, Map<T1, T2>> toMap() {
        return new MyCollector<EntryMapper<T1, T2>, Map<T1, T2>, Map<T1, T2>>((Supplier<Map<T1, T2>>) HashMap<T1, T2>::new, (o1, o2) -> o1.put(o2.getKey(), o2.getVal()),
                (left, right) -> {
                    left.putAll(right);
                    return left;
                },
                Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.IDENTITY_FINISH)));
    }
}
