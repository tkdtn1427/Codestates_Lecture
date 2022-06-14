package Section2.DailyCoding;

public class _14_superIncreasing {
    public static void main(String[] args) {
        boolean output = superIncreasing(new int[]{1, 3, 6, 13, 54});
        System.out.println(output);
    }

//    static boolean superIncreasing(int[] arr) {
//        // TODO:
//        int pre_sum = 0;
//
//        for(int i=0; i<arr.length-1; i++){
//            pre_sum += arr[i];
//            if(arr[i+1] <= pre_sum) return false;
//        }
//
//        return true;
//    }
//===============================================================================

// Other Solution
    static boolean superIncreasing(int[] arr) {
        if(arr.length == 0) return false;
        int sum = arr[0];

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] <= sum) {
                return false;
            }
            sum = sum + arr[i];
        }
        return true;
    }
}
