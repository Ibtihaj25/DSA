package Lab6;

class IterativeMergeSort {
    public void mergeSort(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        for (int size = 1; size < n; size *= 2) {
            for (int leftStart = 0; leftStart < n - 1; leftStart += 2 * size) {
                int mid = Math.min(leftStart + size - 1, n - 1);
                int rightEnd = Math.min(leftStart + 2 * size - 1, n - 1);
                merge(arr, temp, leftStart, mid, rightEnd);
            }
        }
    }

    private void merge(int[] arr, int[] temp, int leftStart, int mid, int rightEnd) {
        int left = leftStart;
        int right = mid + 1;
        int index = leftStart;

        while (left <= mid && right <= rightEnd) {
            if (arr[left] <= arr[right]) {
                temp[index++] = arr[left++];
            } else {
                temp[index++] = arr[right++];
            }
        }
        while (left <= mid) {
            temp[index++] = arr[left++];
        }
        while (right <= rightEnd) {
            temp[index++] = arr[right++];
        }
        for (int i = leftStart; i <= rightEnd; i++) {
            arr[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        IterativeMergeSort ims = new IterativeMergeSort();
        ims.mergeSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}