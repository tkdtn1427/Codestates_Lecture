package Section2.DailyCoding2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _58_jobAllocation {
    public static void main(String[] args) {
        int[] jobs = new int[]{10, 2, 3, 4, 16, 10, 10};
        int workersNum = 4;
        int output = jobAllocation(jobs, workersNum);
        System.out.println(output);
    }

    static int jobAllocation(int[] jobs, int workersNum){
        int[][] memo = new int[workersNum][];

        for(int i=0; i<workersNum; i++){
            int[] temp = new int[jobs.length];
            Arrays.fill(temp,-1);
            memo[i] = temp;
        }

        int prev = 0;
        for(int i=jobs.length-1; i>=workersNum-1; i--){
            prev += jobs[i];
            memo[workersNum-1][i] = prev;
        }

        int result = recur(jobs,0,0,workersNum-1,memo);

        for(int[] tmp : memo) System.out.println(Arrays.toString(tmp));

        return result;
    }

    static int recur(int[] jobs, int workeridx, int idx, int workersNum, int[][] memo){

        if(memo[workeridx][idx] != -1) return memo[workeridx][idx];

        int workload = 0;
        int min = Integer.MAX_VALUE;
        for(int i=idx; i<jobs.length-workersNum; i++){
            workload += jobs[i];
            int max = Math.max(workload,
                    recur(jobs,workeridx+1,i+1,workersNum-1,memo));

            min = Math.min(min,max);
        }
        memo[workeridx][idx] = min;
        return min;
    }

//=================================================================================



//    static int total;
//    static int jobAllocation(int[] jobs, int workersNum){
//        total = Integer.MAX_VALUE;
//        recur(jobs,workersNum,new ArrayList<>());
//
//        return total;
//    }
//
//    static void recur(int[] jobs, int workersNum, List<Integer> list){
//        if(workersNum == 1){
//            int remainsum = Arrays.stream(jobs).sum();
//            int temp = Math.max(remainsum, list.stream().mapToInt(x -> x).max().orElse(0));
//            if(total > temp) total = temp;
//            return ;
//        }
//
//        int workload = 0;
//        for(int i=0; i<=jobs.length-workersNum; i++){
//            workload += jobs[i];
//            list.add(workload);
//            recur(Arrays.copyOfRange(jobs,i+1,jobs.length),workersNum-1,list);
//            list.remove(list.size()-1);
//        }
//
//        return ;
//    }

//================================================================================



//  총 5개의 작업을 3명이서 작업한다고 가정한다.
//  첫번째 작업자는 최대 3개의 작업을 할 수 있다.
// (jobs, workersNum)으로 표기하면, (jobs는 작업량이 아닌 작업의 인덱스만 표기한다고 한다)
// 처음은 ([0, 1, 2, 3, 4], 3)인 상태이다.
//  1) 첫번째 작업자가 1개의 작업을 하고 나머지 작업을 2명이 작업
//    => ([1, 2, 3, 4], 2)
//  2) 첫번째 작업자가 2개의 작업을 하고 나머지 작업을 2명이 작업
//    => ([2, 3, 4], 2)
//  3) 첫번째 작업자가 3개의 작업을 하고 나머지 작업을 2명이 작업
//    => ([3, 4], 2)
// 아래 두 가지 경우를 통해, 문제가 중복되어 계산된다는 것을 알 수 있다.
//  1-1) 첫번째 작업자가 1개의 작업을 하고, 그 다음 작업자가 2개의 작업을 한 경우
//    => ([3, 4], 1)
//  2-1) 첫번째 작업자가 2개의 작업을 하고, 그 다음 작업자가 1개의 작업을 한 경우
//    => ([3, 4], 1)
// 메모이제이션을 통해 중복 계산을 피한다.
//    static int jobAllocation(int[] jobs, int workersNum){
//        // memo[i][j]는 i번째 worker가 j번째 job부터 작업한다고 할 때,
//        // 최대 작업량이 최소가 되는 분배에서의 최대 작업량을 저장한다.
//        // i, j 모두 인덱스이므로 0부터 시작
//        int[][] memo = new int[workersNum][];
//        for(int i = 0; i < workersNum; i++) {
//            int[] arr = new int[jobs.length];
//            Arrays.fill(arr, -1);
//            memo[i] = arr;
//        }
//        // 마지막 작업자는 남아있는 모든 작업을 다 해야하므로 쉽게 계산이 가능하다.
//        // 마지막 작업자는 최대 나머지 작업자의 수만큼을 제외한 일만 할 수 있다.
//        int workload = 0;
//        for (int i = jobs.length - 1; i >= workersNum - 1; i--) {
//            workload = workload + jobs[i];
//            memo[workersNum - 1][i] = workload;
//        }
//
//        return aux(0, 0, jobs, workersNum - 1, memo);
//    }
//
//    static int aux(int workerIdx, int jobIdx, int[] jobs, int left, int[][] memo) {
//        // 이미 계산한 적이 있는 경우, 다시 풀지 않는다
//        // 마지막 작업자의 작업량을 전부 계산했으므로, 탈출 조건을 굳이 작성하지 않아도 된다.
//        if (memo[workerIdx][jobIdx] != -1) return memo[workerIdx][jobIdx];
//
//        int workload = 0;
//        int min = Integer.MAX_VALUE;
//        for (int i = jobIdx; i < jobs.length - left; i++) {
//            workload = workload + jobs[i];
//            // 가장 많이 일하는 사람의 작업량을 구한다.
//            int hardest = Math.max(
//                    workload,
//                    aux(workerIdx + 1, i + 1, jobs, left - 1, memo)
//            );
//            // 그 작업량이 최소화되는 분배에서 최대 작업량을 구한다.
//            min = Math.min(min, hardest);
//        }
//        memo[workerIdx][jobIdx] = min;
//        return min;
//    };


}
