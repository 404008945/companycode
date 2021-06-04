package solution;

import java.util.LinkedList;

public class ReverseParentheses {
    public String reverseParentheses(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        LinkedList<Integer> stack = new LinkedList<>();

        for(int  i=0;i<stringBuilder.length();i++){
            if(stringBuilder.charAt(i) =='('){
                stack.push(i);
                continue;
            }
            if(stringBuilder.charAt(i) == ')'){
                int index  = stack.pop();
                stringBuilder.replace(index,i+1,new StringBuilder(stringBuilder.substring(index,i+1)).reverse().toString());
            }
        }
        StringBuilder res = new StringBuilder();
        for(int  i=0;i<stringBuilder.length();i++){
            if(stringBuilder.charAt(i) =='('||stringBuilder.charAt(i) ==')'){
                continue;
            }
            res.append(stringBuilder.charAt(i));
        }
        return stringBuilder.toString();
    }
}
