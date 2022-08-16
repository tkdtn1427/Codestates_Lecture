package Section2.DailyCoding2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _55_gossipProtocol {
    public static void main(String[] args) {
        String[] village = new String[]{
                "0101", // 첫 번째 줄
                "0111",
                "0110",
                "0100"
        };
        int row = 1;
        int col = 2;
        int output = gossipProtocol(village, row, col);
        System.out.println(output);
    }

//    static int gossipProtocol(String[] village, int row, int col) {
//        int count=-1;
//        boolean find;
//        List<Integer[]> queue = new ArrayList<>();
//        queue.add(new Integer[]{row,col});
//        while (!queue.isEmpty()){
//            List<Integer[]> tmp = new ArrayList<>();
//            find = false;
//            for(int i=0; i<queue.size(); i++){
//                Integer[] temp = queue.get(i);
//                row = temp[0];
//                col = temp[1];
//                if(row >= 0 && row < village.length && col >=0 && col<village[0].length() && village[row].charAt(col) == '1'){
//                    StringBuilder sb = new StringBuilder(village[row]);
//                    sb.replace(col,col+1,"x");
//                    village[row] = sb.toString();
//                    find = true;
//                }else{
//                    continue;
//                }
//
//
//                tmp.add(new Integer[]{row-1,col});
//                tmp.add(new Integer[]{row,col+1});
//                tmp.add(new Integer[]{row+1,col});
//                tmp.add(new Integer[]{row,col-1});
//            }
//            for(String show : village) System.out.println(show);
//            System.out.println();
//            queue = tmp;
//            if(find == true) count++;
//        }
//        return count;
//    }
//


//=====================================================================================================================

    static int front = 0;
    static int rear = 0;
    static int[][] queue;

    static int gossipProtocol(String[] village, int row, int col) {
        // bfs 구현을 위해 큐를 선언한다.
        // enQueue, deQueue시마다 인덱싱을 다시 하지 않기 위해
        // 순환 큐(circular queue)로 구현한다.
        // queue의 가능한 최대 크기만큼 배열을 선언한다.
        // 문제의 특성에 따라 큐에는 좌표 평면의 한 점이 삽입되고, 한번 삽입된 요소는 두 번 다시 삽입되지 않는다.
        int R = village.length;
        int C = village[0].length();
        int[][] matrix = createMatrix(village);
        int[][] MOVES = new int[][]{
                {-1, 0},  // UP
                {1, 0},   // DOWN
                {0, 1},   // RIGHT
                {0, -1}   // LEFT
        };

        int MAX_SIZE = R * C;
        queue = new int[MAX_SIZE][];
        int cnt = 0;
        enQueue(queue, new int[]{row, col}, MAX_SIZE);

        // 소문이 퍼지는 데 걸리는 시간을 저장한다.
        matrix[row][col] = 0;
        while (isEmpty()) {
            // 큐의 가장 앞 자리의 좌표를 얻는다.
            int[] pos = deQueue(queue, MAX_SIZE);
            row = pos[0];
            col = pos[1];
            cnt = matrix[row][col];

            // 현재 지점을 기준으로 네 방향을 검토한다.
            for(int[] move : MOVES) {
                int rDiff = move[0];
                int cDiff = move[1];
                int nextRow = row + rDiff;
                int nextCol = col + cDiff;
                if(isValid(nextRow, nextCol, R, C) && matrix[nextRow][nextCol] == 1) {
                    enQueue(queue, new int[]{nextRow, nextCol}, MAX_SIZE);
                    matrix[nextRow][nextCol] = matrix[row][col]+ 1;
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        return cnt;
    }
    static void enQueue(int[][] queue, int[] pos, int MAX_SIZE) {
        // 실행 중에 큐가 가득차지는 않기 때문에 별도의 조건문을 작성할 필요가 없다.
        queue[rear] = pos;
        // 모듈러스 연산을 할 필요도 사실 없다.
        rear = (rear + 1) % MAX_SIZE;
    }
    static boolean isEmpty() {
        return front != rear;
    }

    static int[] deQueue(int[][] queue, int MAX_SIZE) {
        int[] pos = queue[front];
        front = (front + 1) % MAX_SIZE;
        return pos;
    }

    static boolean isValid(int row, int col, int R, int C) {
        return row >= 0 && row < R && col >= 0 && col < C;
    }

    static int[][] createMatrix(String[] village) {
        int[][] matrix = new int[village.length][];
        for(int i = 0; i < village.length; i++) {
            String str = village[i];
            int[] row = new int[str.length()];
            for(int j = 0; j < str.length(); j++) {
                row[j] = Character.getNumericValue(str.charAt(j));
            }
            matrix[i] = row;
        }
        return matrix;
    }
}
