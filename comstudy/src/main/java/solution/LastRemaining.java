package solution;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class LastRemaining {
    public static int lastRemaining(int n, int m) {
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        int count = 0;
        int index = -m;
        int  total =0;

       while (true){
           index = (index + m) % n;
           if(arr[index] == -1){
               continue;
           }
           if(total == n-1){
               break;
           }
           arr[index] = -1;

           total ++;
       }
       return Arrays.stream(arr).filter(it->it!=-1).findFirst().getAsInt();
    }

    public static void main(String[] args) {
        lastRemaining(5,3);

    }
}
