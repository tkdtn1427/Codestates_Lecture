package Section2.Coding_test;
import java.util.*;


public class _3_simulation {
    public static void main(String[] args) {
        String operation = "DDRRRUDUDUD";
        int[][] board1 = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0}
        };
        List<String> list = new ArrayList<String>(Arrays.asList(operation.split("")));
        System.out.println(boardGame(board1,operation));
    }

//    static Integer boardGame(int[][] board, String operation) {
//        int result=0;
//        List<String> list = new ArrayList<String>(Arrays.asList(operation.split("")));
//        int[] horse = new int[]{0,0};
//
//        while(list.size() != 0){
//            String order = list.remove(0);
//            horse = select(horse,order);
//            System.out.println(Arrays.toString(horse));
//            if(horse[0] < 0 || horse[1] < 0 || horse[1] > board[0].length-1 || horse[0] > board.length-1){
//                return null;
//            }
//            result += board[horse[0]][horse[1]];
//        }
//
//        return result;
//    }
//
//    static int[] select(int[] horse, String str){
//        System.out.println(str);
//        switch(str){
//            case "U":
//                horse[0] -= 1;
//                break;
//            case "D":
//                horse[0] += 1;
//                break;
//            case "R":
//                horse[1] += 1;
//                break;
//            default:
//                horse[1] -= 1;
//                break;
//        }
//
//        return horse;
//    }

//==============================================================================
    static Integer boardGame(int[][] board, String operation) {
        HashMap<String, int[]> DIR = new HashMap<String, int[]>(){{
            put("U", new int[]{-1, 0});
            put("D", new int[]{1, 0});
            put("L", new int[]{0, -1});
            put("R", new int[]{0, 1});
        }};
            //보드의 길이를 선언합니다.
            int LEN = board.length;
            //시작 좌표와, 점수를 0으로 할당합니다.
            int Y = 0;
            int X = 0;
            int score = 0;

            //입력받은 operation을 char배열로 변환합니다.
            char[] chars = operation.toCharArray();

            //해당 배열만큼 반복합니다.
            for(int i = 0; i < chars.length; i++) {
                int dY = DIR.get(String.valueOf(chars[i]))[0];
                int dX = DIR.get(String.valueOf(chars[i]))[1];
                Y += dY;
                X += dX;
                //isValid 함수를 이용하여, 이동이 불가능한 경우 null을 반환합니다.
                if (!isValid(Y, X, LEN)) return null;
                //이동이 가능한 경우, 해당 보드의 값만큼 전체 점수에 더해줍니다.
                score += board[Y][X];
            }
            //전체 점수를 반환합니다.
            return score;
        }
            //이동이 가능한지 확인하여 boolean으로 결과를 반환하는 함수
            static boolean isValid(int y, int x, int LEN) {
                //최소값과, 최대값을 벗어나면 false, 가능하다면 true를 반환합니다.
                return 0 <= y && y < LEN && 0 <= x && x < LEN;
            }
}
