package Section2.DailyCoding;
import java.lang.reflect.Array;
import java.util.*;

public class _31_powerSet {
    static ArrayList<String> result = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<String> output2 = powerSet("jump");
        System.out.println(output2);
    }
    static ArrayList<String> powerSet(String str) {
        result.clear();
        String[] temp = str.split("");
        Set<String> distinct_ = new HashSet<>(Arrays.asList(temp));
        String[] array_str = distinct_.toArray(new String[distinct_.size()]);
        Arrays.sort(array_str);

//        boolean[] isUse = new boolean[result.length];
//        System.out.println(Arrays.toString(result));
        result.add("");
        recur(new ArrayList<String>(),array_str,0);
        result.remove(result.size()-1);
        Collections.sort(result);
        return result;
    }

    static ArrayList<String> recur(ArrayList<String> sub_list, String[] array_str, int idx){
        if(idx == array_str.length){
            result.add(String.join("",sub_list));
            return sub_list;
        }
        sub_list.add(array_str[idx]);
        sub_list = recur(sub_list,array_str,idx+1);

        sub_list.remove(sub_list.size()-1);
        sub_list = recur(sub_list,array_str,idx+1);

        return sub_list;
    }

//================================================================================

//    static ArrayList<String> powerSet(String str) {
//
//        // 정렬
//        String deduplStr = deduplicated(str);
//        Stack<String> stack = new Stack<>();
//
//        ArrayList<String> result = new ArrayList<>();
//
//        result = pickOrNot(stack, 0, deduplStr, result);
//        // 오름차순으로 정렬
//        System.out.println(result);
//        return result;
//    };
//    // 중복 제거를 위한 메서드를 작성합니다.
//    static String deduplicated(String str) {
//        String result = "";
//        //indexOf 메서드를 통해 중복여부를 확인합니다.
//        for(int index = 0; index < str.length(); index++) {
//            if(str.indexOf(str.charAt(index)) == index) {
//                result += str.charAt(index);
//            }
//        }
//
//        String[] sorted = result.split("");
//        Arrays.sort(sorted);
//        result = String.join(",", sorted).replaceAll(",", "");
//        return result;
//    }
//    // 모든 조합을 검사하는 재귀 함수를 작성합니다.
//    static ArrayList<String> pickOrNot(Stack<String> stack, int idx, String subset, ArrayList<String> result) {
//        // 재귀 함수이기 때문에 탈출 조건을 만듭니다.
//        if(idx >= subset.length()) {
//            // 만약, idx와 sideDishes의 길이가 같거나 크다면(마지막까지 검토한 경우) 스택을 문자열로 변환한 후, 해당 스택을 result에 넣어줍니다.
//            result.add(stack.toString()
//                    .replaceAll("\\[", "")
//                    .replaceAll("]", "")
//                    .replaceAll(",", "")
//                    .replaceAll(" ", ""));
//            return result;
//        } else {
//            // idx가 부분집합에 포함된 경우
//            stack.push(Character.toString(subset.charAt(idx)));
//            pickOrNot(stack, idx + 1, subset, result);
//
//            // idx가 부분집합에 포함되지 않은 경우
//            stack.pop();
//            pickOrNot(stack, idx + 1, subset, result);
//        }
//        return result;
//    }
}

/*

        String[] test = "rewtqtt".split("");
        Set<String> test_ = new HashSet<>();
        for(String tt : test){
            test_.add(tt);
        }
        String result = String.join("",test_);
        System.out.println(result);
 */
