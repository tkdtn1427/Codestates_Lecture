package Section2.DailyCoding;

import java.util.Arrays;

//★ Not Solve a Q Alone
// Re Solve
public class _34_robotMatrix {
    static int[][] rotateMatrix(int[][] matrix, int K) {
        if (matrix == null){
            return matrix;
        }
        K = K%4;
        int[][] temp;
        temp = K % 2 == 1 ?
                new int[matrix[0].length][matrix.length] : new int[matrix.length][matrix[0].length];
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                if(K ==1){
                    temp[i][j] = matrix[temp[i].length-1-j][i];
                }else if(K ==2){
                    temp[temp.length-1-i][temp[i].length-1-j]= matrix[i][j];
                }else{
                    temp[i][j] = matrix[j][temp.length-1-i];
                }
            }
        }
        matrix = temp.clone();

        for(int m=0; m< matrix.length; m++) {
            System.out.println(Arrays.toString(matrix[m]));
        }
        System.out.println();
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        int K = 3;
        rotateMatrix(matrix,K);
    }
}

//9 5 1
//10 6 2
//11 7 3
//12 8 4
//
//12 11 10 9
//8 7 6 5
//4 3 2 1
//
//4 8 12
//3 7 11
//2 6 10
//1 5 9