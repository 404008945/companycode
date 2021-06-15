package solution;

//    2,3,6,1,9,8
public class MaxArea {
    //双指针法求解
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int maxArea = 0;
        while (l < r) {
            int h = Math.min(height[l],height[r]);
            maxArea = Math.max(maxArea,(r-l)*h);
            if (height[l] < height[r]) {
                l++;
                continue;
            } else {
                r--;
                continue;
            }
        }
        return maxArea;
    }
}
