package Section2.DailyCoding2;

public class _43_spiralTravelsal {
    public static void main(String[] args) {
        Character[][] matrix = new Character[][]{
                {'T', 'y', 'r', 'i'},
                {'i', 's', 't', 'o'},
                {'n', 'r', 'e', 'n'},
                {'n', 'a', 'L', ' '},
        };
        String output = spiralTraversal(matrix);
        System.out.println(output);
    }

//    static String spiralTraversal(Character[][] matrix) {
//        int colstart = 0;
//        int collast = matrix[0].length-1;
//        int rowstart = 1;
//        int rowlast = matrix.length-1;
//
//        int cidx = 0;
//        int ridx = 0;
//
//        String result = "";
//        char move = 'r';
//
//
//        while(true){
//            if(move == 'r'){
//                for(int i=colstart ; i<=collast; i++){
//                    result += matrix[ridx][i];
//                }
//                cidx = collast;
//                collast -= 1;
//                move = 'd';
//            }else if(move == 'd'){
//                for(int i=rowstart; i<=rowlast; i++){
//                    result += matrix[i][cidx];
//                }
//                ridx = rowlast;
//                rowlast -= 1;
//                move ='l';
//            }else if(move == 'l'){
//                for(int i=collast; i>=colstart; i--){
//                    result += matrix[ridx][i];
//                }
//                cidx = colstart;
//                colstart += 1;
//                move = 'u';
//            }else{
//                for(int i=rowlast; i>=rowstart; i--){
//                    result += matrix[i][cidx];
//                }
//                ridx = rowstart;
//                rowstart += 1;
//                move = 'r';
//            }
//            if((rowstart > rowlast && (move =='u' || move =='d')) || (colstart > collast && (move == 'r' || move =='l'))){
//                break;
//            }
//        }
//
//        return result;
//    }

//=============================================================================================================

    static String spiralTraversal(Character[][] matrix) {
        int[] RIGHT = new int[]{0, 1};
        int[] DOWN = new int[]{1, 0};
        int[] LEFT = new int[]{0, -1};
        int[] UP = new int[]{-1, 0};
        // 각 방향을 위한 lookup table
        int[][] MOVES = new int[][]{
                RIGHT, DOWN, LEFT, UP
        };

        int M = matrix.length;
        int N = matrix[0].length;

        int cnt = 0;
        int row = 0, col = -1;
        int direction = 0;
        StringBuilder result = new StringBuilder();
		while (cnt < M * N) {
            int[] move = MOVES[direction];
            int rd = move[0], cd = move[1];

            row = row + rd;
            col = col + cd;
            while (isValid(row, col, M, N) && matrix[row][col] != null) {
                result.append(matrix[row][col]);
                matrix[row][col] = null;
                row = row + rd;
                col = col + cd;
                cnt++;
            }
        // row, col 이 행렬의 범위를 벗어났기 때문에,
        // 진행된 방향의 반대로 한 칸 이동한다.
            row = row - rd;
            col = col - cd;

            // 각 방향이 순환되기 때문에 모듈러 연산을 사용한다.
            direction = (direction + 1) % 4;
    }
		return result.toString();
}

    public static boolean isValid(int row, int col, int M, int N) {
        return (row >= 0 && row < M && col >= 0 && col < N);
    }


}
