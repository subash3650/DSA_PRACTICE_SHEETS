import java.io.*;
import java.util.*;


class Solution {

    List<Integer> kLargest(int arr[], int k) {
        List<Integer> list = new ArrayList<>();
        
        PriorityQueue<Integer> pr = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : arr){
            pr.add(i);
        }
        for(int i=0; i<k; i++) {
            list.add(pr.poll());
        }
        return list;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());
            Solution ob = new Solution();
            List<Integer> ans = ob.kLargest(arr, k);

            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println(); 
            System.out.println("~");
        }
    }
}
