import java.io.*;
import java.util.*;

public class FormLargestNumber {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] arr = br.readLine().trim().split(" ");

            String ans = new Solution().printLargest(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

class Solution {
    String printLargest(String[] arr) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr, (a,b) -> (b+a).compareTo(a+b));
        for(int i=0; i<arr.length; i++){
            sb.append(arr[i]);
        }
    
        return sb.toString();
    }
}