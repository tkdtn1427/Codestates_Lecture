package Section2.DailyCoding2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _56_sudoku {
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {0, 3, 0, 2, 6, 0, 7, 0, 1},
                {6, 8, 0, 0, 7, 0, 0, 9, 0},
                {1, 9, 0, 0, 0, 4, 5, 0, 0},
                {8, 2, 0, 1, 0, 0, 0, 4, 0},
                {0, 0, 4, 6, 0, 2, 9, 0, 0},
                {0, 5, 0, 0, 0, 3, 0, 2, 8},
                {0, 0, 9, 3, 0, 0, 0, 7, 4},
                {0, 4, 0, 0, 5, 0, 0, 3, 6},
                {7, 0, 3, 0, 1, 8, 0, 0, 0}
        };
        int[][] output = sudoku(board);
//        System.out.println(output);
        for(int[] tmp : board) System.out.println(Arrays.toString(tmp));
    }

    static int[][] sudoku(int[][] board) {
        boolean find = true;

        while (find==true) {
            find = false;
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[0].length; col++) {
                    if (board[row][col] == 0) {
                        find = true;
                        List<Integer> list = new ArrayList<>(List.of(0,1,2,3,4,5,6,7,8,9));
                        list = find(board, list, row, col);
                        if (list.size() == 1) {
                            board[row][col] = list.remove(0);
                        }
                    }
                }
            }
        }

        return board;
    }

    static List<Integer> find(int[][] board, List<Integer> list,int row, int col){
        for(int i=0; i<board.length; i++){
            int num1 = board[row][i];
            int num2 = board[i][col];
            if(list.contains(num1)){
                list.remove(list.indexOf(num1));
            }
            if(list.contains(num2)){
                list.remove(list.indexOf(num2));
            }
        }

        int box1 = row/3*3;
        int box2 = col/3*3;

        for(int i=box1; i<box1+3; i++){
            for(int j=box2; j<box2+3; j++){
                int num = board[i][j];
                if(list.contains(num)){
                    list.remove(list.indexOf(num));
                }
            }
        }

        return list;
    }
//================================================================================

//    static int[][] result;
//    static boolean[][] rowCheck, colCheck, squCheck;
//    static ArrayList<int[]> blanks;
//
//    static int[][] sudoku(int[][] board) {
//        // 결과를 담을 배열 선언
//        result = new int[9][9];
//        // 가로, 세로 , 3X3 방문여부를 확인할 배열을 선언
//        rowCheck = new boolean[9][10];
//        colCheck = new boolean[9][10];
//        squCheck = new boolean[9][10];
//        // 채워야 할 빈칸을 넣어줄 List를 선언
//        blanks = new ArrayList<>();
//
//        for(int row = 0; row < 9; row++) {
//            for(int col = 0; col < 9; col++) {
//                result[row][col] = board[row][col];
//                // 빈칸일 경우 List에 해당 row, col을 삽입
//                if(result[row][col] == 0) blanks.add(new int[]{row, col});
//                else {
//                    // 빈칸이 아닐 경우, 이미 방문했다고 방문여부를 체크
//                    rowCheck[row][result[row][col]] = true;
//                    colCheck[col][result[row][col]] = true;
//                    squCheck[(row / 3 * 3) + (col / 3)][result[row][col]] = true;
//                }
//            }
//        }
//        // 빈칸을 순회하며 맞는 숫자를 넣기 위한 메서드 실행
//        tracking(0);
//        return result;
//    }
//
//    static boolean tracking(int count) {
//        // 현재 List의 크기와 count가 같은 경우는 모든 빈칸을 다 채웠을 경우.
//        if(count == blanks.size()) return true;
//
//        int[] data = blanks.get(count);
//        int row = data[0];
//        int col = data[1];
//
//        // 빈칸에 1부터 9까지의 숫자를 모두 넣어보고
//        for(int i = 1; i <= 9; i++) {
//            // 해당 숫자가 가로, 세로, 3X3 구역에 이미 사용하고 있다면
//            if(rowCheck[row][i] | colCheck[col][i] || squCheck[row / 3 * 3 + (col / 3)][i]) continue;
//
//            // 포함되어 있지 않아서, 숫자를 넣을 수 있다면
//            rowCheck[row][i] = true;
//            colCheck[col][i] = true;
//            squCheck[row / 3 * 3 + (col / 3)][i] = true;
//            result[row][col] = i;
//
//            // 다음 빈칸으로 넘어간다
//            if(tracking(count + 1)) return true;
//
//            // 다시 원상복구 (이전의 결과가 이후의 결과에 미치는 영향을 지우기 위해서)
//            rowCheck[row][i] = false;
//            colCheck[col][i] = false;
//            squCheck[row / 3 * 3 + (col / 3)][i] = false;
//            result[row][col] = 0;
//        }
//        return false;
//    }
}
