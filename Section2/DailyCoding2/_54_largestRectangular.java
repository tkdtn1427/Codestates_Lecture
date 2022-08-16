package Section2.DailyCoding2;

import java.util.Arrays;
import java.util.Stack;

public class _54_largestRectangular {
    public static void main(String[] args) {
        int[] histogram = new int[]{2, 1, 5, 6, 2, 3};
        int output = largestRectangularArea(histogram);
        System.out.println(output); // --> 8
    }

//    static int largestRectangularArea(int[] histogram) {
//        int result = histogram.length;
//
//        for(int i=0; i<histogram.length; i++){
//            final int ht = histogram[i];
//            int len = -1;
//            for(int j=i; j>=0; j--){
//                if(ht <= histogram[j]){
//                    len++;
//                }else{
//                    break;
//                }
//            }
//
//            for(int j=i; j< histogram.length; j++){
//                if( ht <= histogram[j]){
//                    len++;
//                }else{
//                    break;
//                }
//            }
//
//            if(result < ht*len) result = ht*len;
//        }
//
//        return result;
//    }

//================-=====================================================================
    static int largestRectangularArea(int[] histogram) {
        int maxArea = 0;
        int[] tempPLE = new int[histogram.length];
        int[] tempNLE = new int[histogram.length];
        Arrays.fill(tempPLE, -1);
        Arrays.fill(tempNLE, -1);

        int[] PLE = findPLE(tempPLE, histogram);
        int[] NLE = findNLE(tempNLE, histogram);
        for(int i = 0; i < histogram.length; i++) {
            int barsOnLeft = PLE[i] == -1 ? i : i - PLE[i] - 1;
            int barsOnRight = NLE[i] == -1 ? histogram.length - 1 - i : NLE[i] - i - 1;
            int width = barsOnLeft + barsOnRight + 1;
            maxArea = Math.max(maxArea, width * histogram[i]);
        }
        return maxArea;
}
    static int[] findPLE(int[] PLE, int[] histogram) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < histogram.length; i++) {
            while (stack.size() > 0 && histogram[stack.get(stack.size() - 1)] >= histogram[i]) {
                stack.pop();
            }
            if(stack.size() > 0) {
                PLE[i] = stack.get(stack.size() - 1);
            }
            stack.push(i);
        }
        return PLE;
    }

    static int[] findNLE(int[] NLE, int[] histogram) {
        Stack<Integer> stack = new Stack<>();
        for(int i = histogram.length - 1; i >= 0; i--) {
            while (stack.size() > 0 && histogram[stack.get(stack.size() - 1)] >= histogram[i]) {
                stack.pop();
            }
            if(stack.size() > 0) {
                NLE[i] = stack.get(stack.size() - 1);
            }
            stack.push(i);
        }
        return NLE;
    }


//===================================================================================

    // static int largestRectangularArea(int[] histogram) {
    //   int largest = 0;
    //   // 모든 연속된 부분 히스토그램을 고려한다.
    //   // 밑변의 길이를 부분 히스토그램의 길이로 고정하면, 높이는 가장 낮은 막대의 높이가 된다.
    //   for (int left = 0; left < histogram.length; left++) {
    //     // 길이가 1인 막대로 만들 수 있는 직사각형의 넓이는 막대의 높이와 같다.
    //     int min = histogram[left];
    //     for (int right = left; right < histogram.length; right++) {
    //       // left부터 right까지의 히스토그램의 막대 중 가장 낮은 막대의 높이를 구한다.
    //       if (histogram[right] < min) min = histogram[right];
    //       // 해당 구간(left ~ right)의 막대를 전부 포함해서 만들 수 있는 직사각형의 넓이를 구한다.
    //       int area = min * (right - left + 1);
    //       // 매번 구한 면적을 기존의 면적과 비교해 갱신한다.
    //       if (area > largest) largest = area;
    //     }
    //   }
}
