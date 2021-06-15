package option;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandC {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,4,3,5);
        list.stream().collect(Collectors.maxBy(Integer::max));
        //求最大值，使用reduce
        //如果不是static，参数需要加1个 为实例
        int a = list.parallelStream().reduce(0,Integer::max,Math::max);//combinder怎么写
        System.out.println(a);
    }
}
