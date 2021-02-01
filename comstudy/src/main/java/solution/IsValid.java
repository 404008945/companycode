package solution;

import java.util.LinkedList;

public class IsValid {
    public static boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for(int i=0;i<s.length();i++){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
                continue;
            }
            if(s.charAt(i) == ')'){
                if(stack.pop()!='('){
                    return false;
                }
                continue;
            }
            if(s.charAt(i) == '}'){
                if(stack.pop()!='{'){
                    return false;
                }
                continue;
            }
            if(s.charAt(i) == ']'){
                if(stack.pop()!='['){
                    return false;
                }
                continue;
            }
            stack.push(s.charAt(i));
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println( isValid("{[]}"));
    }
}
