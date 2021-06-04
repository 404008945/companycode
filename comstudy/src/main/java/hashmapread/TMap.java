package hashmapread;

import java.util.Map;
import java.util.TreeMap;

public class TMap {

    public static void main(String[] args) {
        TreeMap<String,Integer> map = new TreeMap<>();
        map.put("hello",1);
        map.put("hellofdf",1);
        map.put("hellodfds",1);
        map.put("hellosdfds",1);
        map.put("hellosfds",1);
        map.put("hellofdds",1);
        map.put("hellot5t",1);
        map.put("helloasds",1);
        map.put("helloreewh",1);
        map.put("hellortregr",1);
        for(Map.Entry<String,Integer>  entry:map.entrySet()){

            System.out.println(entry.getKey());
        }
    }
}
