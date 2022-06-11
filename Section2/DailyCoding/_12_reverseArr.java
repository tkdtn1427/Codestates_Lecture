package Section2.DailyCoding;
import java.util.*;

public class _12_reverseArr {
    public static void main(String[] args) {
        int[] output = reverseArr(new int[]{1,2,3});
        //System.out.println(Arrays.toString(output));

    }

//    static int[] reverseArr(int[] arr){
//        // TODO:
//        if(arr.length == 0) return arr;
//
//        int[] head = Arrays.copyOfRange(arr,arr.length-1,arr.length);
//        int[] tail = reverseArr(Arrays.copyOfRange(arr,0,arr.length-1));
//
//        int[] dest = new int[head.length + tail.length];
//        System.arraycopy(head,0,dest,0,head.length);
//        System.arraycopy(tail,0,dest,head.length,tail.length);
//
//        return dest;
//    }
//==================================================================================

    static int[] reverseArr(int[] arr){
        if(arr.length == 0) return new int[]{};
        int[] head = Arrays.copyOfRange(arr, arr.length-1, arr.length);
        int[] tail = reverseArr(Arrays.copyOfRange(arr, 0, arr.length-1));

        int[] dest = new int[head.length + tail.length];
        System.arraycopy(head, 0, dest, 0, head.length);
        System.arraycopy(tail, 0, dest, head.length, tail.length);
        return dest;
    }
}
