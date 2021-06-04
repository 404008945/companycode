package hashmapread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test2 {

    public static void main(String[] args) {
        ConcurrentHashMap<String,Integer> map = new ConcurrentHashMap<>();
        map.put("hello",1);
        map.put("hellofdf",1);
        map.put("hellodfds",1);
        map.put("hellosdfds",1);
        map.put("hellosfds",1);
        map.put("hellofdds",1);
        map.put("helloasds",1);
        map.put("hellot5t",1);
        map.put("helloreewh",1);
        map.put("hellortregr",1);
        map.put("hello321t5t",1);
        map.put("hello3543reewh",1);
        map.put("hello3543reew1h",1);
        map.put("hellottrttrtregr",1);//第13个会扩容
       for(Map.Entry<String,Integer>  entry:map.entrySet()){
           map.remove(entry.getKey());
           System.out.println(entry.getKey());
       }
        map.remove("hellortregr");



    }
}
