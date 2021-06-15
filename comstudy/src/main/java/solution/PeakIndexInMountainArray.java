package solution;

public class PeakIndexInMountainArray {
    public static int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        //根据mid判断位置
        while (left<=right){
            int mid = (left + right) / 2;
            if (mid != right && arr[mid] < arr[mid + 1]) {
                left = mid + 1;
                continue;
            }
            if (mid != left && arr[mid] < arr[mid - 1]) {
                right = mid - 1;
                continue;
            }
            return mid;
        }

        return  -1;
    }

    public static void main(String[] args) {
        peakIndexInMountainArray(new int[]{18,29,38,59,98,100,99,98,90});
    }
}
