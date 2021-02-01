package solution;

import java.util.*;

public class WordPattern {
    public static   boolean wordPattern(String pattern, String s) {
        String arr []  = s.split(" ");
        if(arr.length!=pattern.length()){
            return false;
        }
        Map<Character,String> map = new HashMap<>();

        Map<String,Character> map1 = new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            if(map.get(pattern.charAt(i)) == null){
                map.put(pattern.charAt(i),arr[i]);
            }else if(!map.get(pattern.charAt(i)).equals(arr[i])){
                return false;
            }
            if(map1.get(arr[i])==null){
                map1.put(arr[i],pattern.charAt(i));
            }else if(!map1.get(arr[i]).equals(pattern.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("aaaa","dog dog dog dog"));
    }
}
