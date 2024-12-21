package Practice;

import java.util.LinkedList;
import java.util.Queue;

public class Algorithms <T>{

    private static boolean isSorted = true;

    public static void bubbleSort(int[]array){
        for(int i = 0; i < array.length; i++){
            isSorted = true;
            for(int j = 0; j < array.length-1 -i; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    isSorted = false;     
                }         
            }
            if (isSorted) break;
        }
    }

    public static void insertionSort(int[]array){
        for(int i = 1; i < array.length; i++){
            int temp = array[i];
            int j = i - 1;
            while(j >= 0 && array[j] > temp){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = temp;
        }
    }

    public static void selectionSort(int[]array){
        for(int i = 0; i < array.length - 1; i++){
            int min = i;
            for(int j = i + 1; j < array.length; j++){
                if(array[j] < array[min]){
                    min = j;
                }
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }

    
    public static void heapSort(int[]array){
        for(int i = array.length/2 - 1; i >= 0; i--){
            heapify(array, array.length, i);
        }
        for(int i = array.length - 1; i >= 0; i--){
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }

    private static void heapify(int[]array, int size, int i){
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if(left < size && array[left] > array[largest]){
            largest = left;
        }
        if(right < size && array[right] > array[largest]){
            largest = right;
        }
        if(largest != i){
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapify(array, size, largest);
        }
    }

    public static void mergeSort(int[]array){
        if(array.length > 1){
            int mid = array.length / 2;
            int[]left = new int[mid];
            int[]right = new int[array.length - mid];
            for(int i = 0; i < mid; i++){
                left[i] = array[i];
            }
            for(int i = mid; i < array.length; i++){
                right[i - mid] = array[i];
            }
            mergeSort(left);
            mergeSort(right);
            merge(array, left, right);
        }
    }

    private static void merge(int[]array, int[]left, int[]right){
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < left.length && j < right.length){
            if(left[i] < right[j]){
                array[k] = left[i];
                i++;
                k++;
            }else{
                array[k] = right[j];
                j++;
                k++;
            }
        }
        while(i < left.length){
            array[k] = left[i];
            i++;
            k++;
        }
        while(j < right.length){
            array[k] = right[j];
            j++;
            k++;
        }
    }

    public static void quickSort(int[]array){
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[]array, int low, int high){
        if(low < high){
            int pivot = partition(array, low, high);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

    private static int partition(int[]array, int low, int high){
        int pivot = array[high];
        int i = low - 1;
        for(int j = low; j < high; j++){
            if(array[j] < pivot){
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
    public static int binarySearch(int[]array, int target){
        int low = 0;
        int high = array.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(array[mid] < target){
                low = mid + 1;
            }else if(array[mid] > target){
                high = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    public static int linearSearch(int[]array, int target){
        for(int i = 0; i < array.length; i++){
            if(array[i] == target){
                return i;
            }
        }
        return -1;
    }
    
    public static void printArray(int[]array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static int interpolationSearch(int[]array, int target){
        int low = 0;
        int high = array.length - 1;
        while(low <= high){
            int mid = low + ((high - low) * (target - array[low])) / (array[high] - array[low]);
            if(array[mid] < target){
                low = mid + 1;
            }else if(array[mid] > target){
                high = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static void BFS(int[][]graph, int start){
        boolean[]visited = new boolean[graph.length];
        Queue<Integer>queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int current = queue.remove();
            System.out.print(current + " ");
            for(int i = 0; i < graph[current].length; i++){
                if(graph[current][i] == 1 && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void DFS(int[][]graph, int start){
        boolean[]visited = new boolean[graph.length];
        DFSUtil(graph, start, visited);
    }
    private static void DFSUtil(int[][]graph, int start, boolean[]visited){
        visited[start] = true;
        System.out.print(start + " ");
        for(int i = 0; i < graph[start].length; i++){
            if(graph[start][i] == 1 && !visited[i]){
                DFSUtil(graph, i, visited);
            }
        }
    }
    public static void DFSRecursive(int[][]graph, int start){
        boolean[]visited = new boolean[graph.length];
        DFSRecursiveUtil(graph, start, visited);
    }
    private static void DFSRecursiveUtil(int[][]graph, int start, boolean[]visited){
        visited[start] = true;
        System.out.print(start + " ");
        for(int i = 0; i < graph[start].length; i++){
            if(graph[start][i] == 1 && !visited[i]){
                DFSRecursiveUtil(graph, i, visited);
            }
        }
    }  
    public static void DFSIterative(int[][]graph, int start){
        boolean[]visited = new boolean[graph.length];
        Queue<Integer>queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int current = queue.remove();
            System.out.print(current + " ");
            for(int i = 0; i < graph[current].length; i++){
                if(graph[current][i] == 1 && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    } 

    public static void DFSIterativeRecursive(int[][]graph, int start){
        boolean[]visited = new boolean[graph.length];
        DFSIterativeRecursiveUtil(graph, start, visited);
    }
    private static void DFSIterativeRecursiveUtil(int[][]graph, int start, boolean[]visited){
        visited[start] = true;
        System.out.print(start + " ");
        for(int i = 0; i < graph[start].length; i++){
            if(graph[start][i] == 1 && !visited[i]){
                DFSIterativeRecursiveUtil(graph, i, visited);
            }
        }
    }
    public static void bucketSort(int[]array){
        int max = array[0];
        for(int i = 1; i < array.length; i++){
            if(array[i] > max){
                max = array[i];
            }
        }
        int[]bucket = new int[max + 1];
        for(int i = 0; i < array.length; i++){
            bucket[array[i]]++;
        }
        int index = 0;
        for(int i = 0; i < bucket.length; i++){
            while(bucket[i] > 0){
                array[index++] = i;
                bucket[i]--;
            }
        }
    }
    public void mergeSortUsingItteration(int[] array){
        
    }

}
