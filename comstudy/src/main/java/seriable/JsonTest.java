package seriable;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.*;

public class JsonTest {
    @Data
    static class Stu{
        private int id;
        private HashSet<Integer> set =new HashSet<>();
    }

    public static void main(String[] args) {
        Stu stu =  new Stu();
        stu.setId(1);
        stu.getSet().addAll(Arrays.asList(54,46,22,16,3));
        System.out.println(stu);
        String str = JSON.toJSONString(stu);
        Stu stu1 = JSON.parseObject(str,Stu.class);
        System.out.println(stu1);

    }


}
