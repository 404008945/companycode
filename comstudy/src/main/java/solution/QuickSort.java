package solution;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = { 4,3,3,2};

        quickSort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }


    private static void quickSort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex) {
            return;
        }
        int left = leftIndex;
        int right = rightIndex;
        int key = arr[left]; //基准值
        while (left < right) {
            while (left < right && arr[right] >= key) {
                right--;
            }
            arr[left] = arr[right];

            while (left < right && arr[left] <= key) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = key;
        // 4 3 3 2
        // 2 3 3 2

        quickSort(arr,left+1,rightIndex);
        quickSort(arr,leftIndex,right-1);

    }
}
