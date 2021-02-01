package solution;

import java.util.PriorityQueue;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        for(Integer a:stones){
            queue.add(a);
        }
        while(queue.size()>1){
            Integer a1 = queue.poll();
            Integer a2 = queue.poll();
            queue.add(Math.abs(a1-a2));
        }
        if(queue.size() == 0){
            return 0;
        }
        return queue.poll();
    }
}
