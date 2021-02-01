package solution;

import java.util.*;

public class Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                //求值
                int x = i-1;
                int y1= j;
                int y2= j-1;
                if(x<0||y1<0||y1>=ans.get(x).size()||y2>=ans.get(x).size()){
                    continue;
                }
                list.add(ans.get(x).get(y1)+ans.get(x).get(y2));
            }
            ans.add(list);
        }
        return ans;
    }

//             [1],
//             [1,1],
//             [1,2,1],
//             [1,3,3,1],
//             [1,4,6,4,1]
}
