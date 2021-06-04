package hashmapread;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkTest {
    public static void main(String[] args) {
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>(16,0.75f,true);
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
        map.get("hello");

        for(Map.Entry<String,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey());
        }

    }
}
