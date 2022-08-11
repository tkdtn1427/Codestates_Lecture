package Section2.DailyCoding2;

import java.util.Arrays;

public class _53_rangeMinimum {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 11, 12, 3, 6, 7, 8, 9};
        int[][] ranges = new int[][]{
                {4, 7},
                {0, 2}
        };
        int[] mins = rangeMinimum(arr, ranges);
//        System.out.println(mins);
        System.out.println(Arrays.toString(mins));
    }

    static int[] rangeMinimum(int[] arr, int[][] ranges) {

        int[] result = new int[ranges.length];
        int idx =0;

        for(int i=0; i<ranges.length; i++){
            int start = ranges[i][0];
            int end = ranges[i][1];

            int[] temp = Arrays.copyOfRange(arr,start,end+1);
            int min = Arrays.stream(temp).min().orElse(0);
            result[idx++] = min;
        }

        return result;
    }
}
