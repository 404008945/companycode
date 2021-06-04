package solution;

import java.util.LinkedList;

public class JudgeCircle {
    public boolean judgeCircle(String moves) {
        int x =0 ;
        int y =0;
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i) == 'U')
            {
                y++;
            }
            if(moves.charAt(i) == 'D')
            {
                y--;
            }
            if(moves.charAt(i) == 'L')
            {
                x--;
            }

            if(moves.charAt(i) == 'R')
            {
                x++;
            }

        }
        return x==0&&y==0;
    }
}