package Section2.Coding_test;

import java.util.ArrayList;
import java.util.Arrays;

public class _9_home_food {
    public static void main(String[] args) {
        ArrayList<String[]> output = missHouseMeal(new String[]{"eggroll", "kimchi", "fishSoup","z"});
        System.out.println();
        for(String[] arr : output) {
            System.out.println(Arrays.toString(arr));
        }



    }

    static ArrayList<String[]> missHouseMeal(String[] sideDishes) {
        Arrays.sort(sideDishes);
        ArrayList<String[]> result = new ArrayList<String[]>();
        boolean[] visited = new boolean[sideDishes.length];
        result.add(new String[]{});

        while (true){
            if(isvalid(visited)) break;
            find_(visited,result,sideDishes, sideDishes.length-1);
        }

        return result;
    }

    static boolean isvalid(boolean[] visited){
        for(boolean tmp : visited){
            if(tmp == false)
                return false;
        }

        return true;
    }

    static void add_value(boolean[] visited, ArrayList<String[]> result, String[] sideDishes){
        ArrayList<String> tmp = new ArrayList<String>();
        for(int i=0; i< visited.length; i++){
            if(visited[i] == false){
                tmp.add(sideDishes[i]);
            }
        }
        result.add(tmp.toArray(new String[0]));
    }

    static void find_(boolean[] visited, ArrayList<String[]> result, String[] sideDishes, int idx){
        if(visited[idx] == false){
            add_value(visited,result,sideDishes);
            visited[idx] = true;
        }else{
            find_(visited,result,sideDishes,idx-1);
            visited[idx] = false;
        }
    }



//========================================================================================================


//    static ArrayList<String[]> missHouseMeal(String[] sideDishes) {
//        //search 함수에서 사용할 빈 스택을 선언합니다.
//        Stack<String> stack = new Stack<>();
//
//        //결과를 담을 ArrayList를 선언합니다.
//        ArrayList<String[]> result = new ArrayList<>();
//
//        //재료들을 오름차순으로 정렬합니다.
//        Arrays.sort(sideDishes);
//
//        // 빈 스택과 0 번째 인덱스, 정렬된 재료로 구성된 배열, 결과를 담을 List를 인자로 받는 재귀 함수를 실행합니다.
//        result = search(stack, 0, sideDishes, result);
//
//        // 결과를 오름차순 순서로 정렬합니다.
//        result.sort((o1, o2) -> Arrays.toString(o1).compareTo(Arrays.toString(o2)));
//        //결과를 반환합니다.
//        return result;
//    }
//
//    // 모든 조합을 검사하는 재귀 함수를 작성합니다.
//    static ArrayList<String[]> search(Stack<String> stack, int idx, String[] sideDishes, ArrayList<String[]> result) {
//        // 재귀 함수이기 때문에 탈출 조건을 만듭니다.
//        if (idx >= sideDishes.length) {
//            // 만약, idx와 sideDishes의 길이가 같거나 크다면(마지막까지 검토한 경우) 스택을 배열로 변환한 후, 해당 스택을 result에 넣어줍니다.
//            String[] arr = stack.toArray(new String[stack.size()]);
//            result.add(arr);
//            return result;
//        } else {
//            // idx가 부분집합에 포함된 경우
//            stack.push(sideDishes[idx]);
//            search(stack, idx + 1, sideDishes, result);
//
//            // idx가 부분집합에 포함되지 않은 경우
//            stack.pop();
//            search(stack, idx + 1, sideDishes, result);
//        }
//        return result;
//    }
}