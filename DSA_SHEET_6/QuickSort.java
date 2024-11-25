import java.util.Scanner;

public class QuickSort {
        static int partition(int[] arr, int low, int high){
            int pivot = arr[low];
            int i = low, j=high;
            while(i < j){
                while(arr[i] <= pivot && i<=high-1){
                    i++;
                }
                while(arr[j] > pivot && j>=low+1){
                    j--;
                }
                if(i < j){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                int temp = arr[low];
                arr[low] = arr[high];
                arr[j] = temp;
            }
            return j;
        }
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        quicksort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
}
public static int[] quicksort(int[] arr){
    qs(arr, 0, arr.length-1);
    return arr;
}

public static void qs(int[] arr, int low , int high){
        if(low < high){
            int pIndex = partition(arr, low, high);
            qs(arr, low, pIndex-1);
            qs(arr, pIndex+1, high);
        }
}
    
}
