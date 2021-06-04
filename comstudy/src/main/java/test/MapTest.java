package test;

import clone.RecycleTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class MapTest {
    static Map<Integer, String> map = new ConcurrentHashMap<>();
    public static void main(String[] args) {
        map.put(1, "232");
        map.put(2, "232");
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(() -> {
            map.entrySet().forEach(it -> {
                ttt(it.getKey());
            });
            System.out.println("hello world");
        }, 0, 1, TimeUnit.SECONDS);
    }

    public static void ttt(int key) {
        map.clear();
    }
}
