class Solution {    
    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    
    public static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quicksort(arr, low, pivot - 1);
            quicksort(arr, pivot + 1, high);
        }
    }
    
    public static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int index = low - 1;
        for (int i = low; i < high; i++) {
            if (arr[i] < pivot) {
                index++;
                swap(arr, i, index);
            }
        }
        swap(arr, index + 1, high);
        return index + 1;
    }
    
    public static int solution(int[] x, int[] y) {
        /* 
            ------------- O(nlogn) solution (avg) ------------- 
            has potential to reach O(n^2) on quick sort worst case,
            but space complexity was taken into consideration in
            comparison with merge sort which wouldve assured O(nlogn)
        */
        
        // sort x
        quicksort(x, 0, x.length - 1);
        
        // sort y
        quicksort(y, 0, y.length - 1);
        
        // obtain smaller length
        boolean xAdditional = false;
        int loopCond = 0;
        if (x.length > y.length) {
            loopCond = y.length;
            xAdditional = true;
        } else
            loopCond = x.length;
        
        //compare elements and find differing element
        for (int i = 0; i < loopCond; i++) {
            if (x[i] != y[i]) {
                if (xAdditional)
                    return x[i];
                else
                    return y[i];
            }
        }
        
        // returns last element if all elements previous matches
        if (xAdditional)
            return x[x.length - 1];
        else
            return y[y.length - 1];
    }
}