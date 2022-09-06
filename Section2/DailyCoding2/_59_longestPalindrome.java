package Section2.DailyCoding2;

import java.util.Arrays;

public class _59_longestPalindrome {
    public static void main(String[] args) {
        String str = "a";
        int result = longestPalindrome(str);
        System.out.println(result);
    }

    static int longestPalindrome(String str) {
        if(str.length() == 0) return 0;
        String[] arr = str.split("");

//        System.out.println(Arrays.toString(arr));
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            int len = findLong(arr,i);
            if(max < len){
                max = len;
            }
        }

        return max;
    }

    static int findLong(String[] arr, int idx){
        int len;
        int left;
        int right;
        if(idx != arr.length-1 && arr[idx].equals(arr[idx+1])){
            left = idx-1;
            right = idx+2;
            len = 2;
        }else{
            left = idx-1;
            right = idx+1;
            len = 1;
        }

        while(left >= 0 && right < arr.length){
            if(!arr[left].equals(arr[right])){
                break;
            }else{
                left--;
                right++;
                len+=2;
            }
        }

        return len;
    }
}
