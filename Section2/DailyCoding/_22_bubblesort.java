package Section2.DailyCoding;

import java.util.Arrays;

public class _22_bubblesort {
    public static void main(String[] args) {
        int[] output = bubbleSort(new int[]{43, 2, 1, 100, 100, 21});
        System.out.println(Arrays.toString(output));
    }

    static int[] bubbleSort(int[] arr) {
        int temp;
        for(int i=0; i<arr.length-1; i++){
            int swap = 0;
            for(int j=0; j<arr.length-1-i; j++){
                if(arr[j] > arr[j+1]){
                    swap++;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if(swap == 0) break;
        }
        return arr;
    }

}


//XOR 연산을 활용한 방법
//arr이 reference type이라 가능
//     arr[idx1] ^= arr[idx2];
//     arr[idx2] ^= arr[idx1];
//     arr[idx1] ^= arr[idx2];