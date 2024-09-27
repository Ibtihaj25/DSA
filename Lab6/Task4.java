package Lab6;
import java.util.Arrays;

class TwoSum {
    public static boolean findTwoSum(int[] arr, int k) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == k) return true;
            else if (sum < k) left++;
            else right--;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 1, 6};
        int k = 10;
        System.out.println(findTwoSum(arr, k) ? "Yes" : "No");
    }
}