package Section2.DailyCoding;
import java.util.*;

public class _10_insertDash {
    public static void main(String[] args) {
        String output = insertDash("454793");
        System.out.println(output);
    }

//    static String insertDash(String str) {
//        // TODO:
//        if(str.length() == 0) return null;
//
//        String result = "";
//        String[] arr = str.split("");
//        for(int i=0; i<arr.length; i++){
//            if(i!=arr.length-1 &&Integer.valueOf(arr[i]) %2 == 1 && Integer.valueOf(arr[i+1]) %2 == 1){
//                arr[i] = arr[i]+"-";
//            }
//            result += arr[i];
//        }
//        return result;
//    }

//=======================================================================

    static String insertDash(String str) {
        if(str.length() == 0) {
            return null;
        }
        String result = "" + str.charAt(0);

        for(int i = 1; i < str.length(); i++) {
            int preNumber = Character.getNumericValue(str.charAt(i - 1)) % 2;
            int curNumber = Character.getNumericValue(str.charAt(i)) % 2;
            if(preNumber % 2 != 0 && curNumber % 2 != 0) {
                result = result + "-";
            }
            result = result + str.charAt(i);
        }
        return result;
    }
}
