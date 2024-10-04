package Lab6;
class Sort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minInd = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minInd]) {
                    minInd = j;
                }
            }
            int temp = arr[minInd];
            arr[minInd] = arr[i];
            arr[i] = temp;
        }
    }
    public static void insertionSort(int[] arr) {
        int m = arr.length;
        for (int i = 1; i < m; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        selectionSort(arr);
        System.out.println("Selection Sorting: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        insertionSort(arr);
        System.out.println("Insertion Sorting: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}