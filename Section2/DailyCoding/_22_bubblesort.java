package Section2.DailyCoding;

import java.util.Arrays;

public class _22_bubblesort {
    public static void main(String[] args) {
        int[] output = bubbleSort(new int[]{2, 1, 3});
        System.out.println(Arrays.toString(output));
    }

//    static int[] bubbleSort(int[] arr) {
//        int temp;
//        for(int i=0; i<arr.length-1; i++){
//            int swap = 0;
//            for(int j=0; j<arr.length-1-i; j++){
//                if(arr[j] > arr[j+1]){
//                    swap++;
//                    temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//                }
//            }
//            if(swap == 0) break;
//        }
//        return arr;
//    }
//=====================================================================

    static int[] swap(int idx1, int idx2, int[] arr) {
        //두 변수를 바꾸는 방법
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;

        //XOR 연산을 활용한 방법
        //arr이 reference type이라 가능
//     arr[idx1] ^= arr[idx2];
//     arr[idx2] ^= arr[idx1];
//     arr[idx1] ^= arr[idx2];

        return arr;
    }
//--------------------------------------
//  // naive solution
//  public int[] bubbleSort(int[] arr) {
//    int arrLength = arr.length;

//    for(int i = 0; i < arrLength - 1; i++) {
//       //매 반복(iteration)마다 i번째로 큰 수가 마지막에서 i번째 위치하게 된다.
//       //이미 정렬된 요소는 고려할 필요가 없으므로, 'j < N - 1 - i'만 비교하면 된다.
//      for(int j = 0; j < arrLength - 1; j++) {
//        if(arr[j] > arr[j + 1]) {
//          arr = swap(j, j+1, arr);
//        }
//      }
//    }
//    return arr;
//  }
//-----------------------------------------
// optimized solution
    static int[] bubbleSort(int[] arr) {
        int arrLength = arr.length;

        for(int i = 0; i < arrLength; i++) {
            // swap 횟수를 기록한다.
            // 어떤 요소도 swap되지 않은 경우, 배열은 정렬된 상태이다.
            int swaps = 0;

            // 매 반복(iteration)마다 i번째로 큰 수가 마지막에서 i번째 위치하게 된다.
            // 이미 정렬된 요소는 고려할 필요가 없으므로, 'j < N - 1 - i'만 비교하면 된다.
            for(int j = 0; j < arrLength - 1; j++) {
                if(arr[j] > arr[j+1]) {
                    swaps++;
                    arr = swap(j, j+1, arr);
                }
            }
            if(swaps == 0) {
                break;
            }
        }
        return arr;
}

}


//XOR 연산을 활용한 방법
//arr이 reference type이라 가능
//     arr[idx1] ^= arr[idx2];
//     arr[idx2] ^= arr[idx1];
//     arr[idx1] ^= arr[idx2];