package Section2.DailyCoding;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _33_robotPath {

    public static void main(String[] args) {
        int[][] room = new int[][]{
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 0}
        };
        int[] src = new int[]{4, 2};
        int[] dst = new int[]{2, 2};

        int output = robotPath(room, src, dst);
        System.out.println(output);
    }

    static int robotPath(int[][] room, int[] src, int[] dst){

        recur(room,src, 1);

        return room[dst[0]][dst[1]]-1;
    }

    static void recur(int[][] room, int[] src, int count){
        int row = src[0];
        int col = src[1];

        if(row < 0 || row >= room.length || col < 0 || col >= room[0].length){
            return ;
        }

        if(room[row][col] == 0 || room[row][col] > count){
            room[row][col] = count;
        }else{
            return ;
        }

        recur(room, new int[]{row + 1, col},count+1); // 상
        recur(room, new int[]{row - 1, col} , count+1); // 하
        recur(room, new int[]{row, col - 1}  ,count+1); // 좌
        recur(room, new int[]{row, col + 1}, count+1); // 우
    }
//
//==================================================================================

//    static int robotPath(int[][] room, int[] src, int[] dst) {
//        // 로봇이 서 있는 위치를 1로 초기화하면 (다시 방문하지 않기 위해서),
//        // 바로 옆 통로는 2가 된다.
//        // 계산이 완료된 후에 최종값에 1을 빼주면 된다.
//        room = aux(room.length, room[0].length, src, 1, room);
//
//        return room[dst[0]][dst[1]] - 1;
//    }
//
//    static int[][] aux(int M, int N, int[] candi, int step, int[][] room) {
//        // 현재 위치
//        int row = candi[0];
//        int col = candi[1];
//
//        // 배열의 범위를 벗어난 경우
//        if (row < 0 || row >= M || col < 0 || col >= N) return room;
//
//        if (room[row][col] == 0 || room[row][col] > step) {
//            room[row][col] = step;
//        } else {
//            // 장애물(1)이거나 이미 최소 시간(1)으로 통과가 가능한 경우
//            return room;
//        }
//
//        // dfs로 4가지 방향에 대해 탐색을 한다.
//        // 완전탐색을 해야하므로 bfs나 dfs가 큰 차이가 없다.
//        // bfs의 경우 목적지에 도착하는 경우 탐색을 중단해도 되므로,
//        // 약간 더 효율적이다.
//        aux(M, N, new int[]{row + 1, col}, step + 1, room); // 상
//        aux(M, N, new int[]{row - 1, col}, step + 1, room); // 하
//        aux(M, N, new int[]{row, col - 1}, step + 1, room); // 좌
//        aux(M, N, new int[]{row, col + 1}, step + 1, room); // 우
//
//        return room;
//    }
}
