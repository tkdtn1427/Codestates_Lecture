package Section1.Java_Effective;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Thread_pool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(7);

        for(int i = 0; i < 10; i++){
            Runnable runnable = new Runnable() {

                @Override
                public void run() {
                    ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
                    //스레드풀 갯수 확인
                    int poolSize = threadPoolExecutor.getPoolSize();
                    //스레드 풀에 있는 해당 스레드이름 확인
                    String threadName = Thread.currentThread().getName();
                    System.out.println("스레드풀 갯수:" + poolSize + "스레드 이름: "+threadName);
                }
            };

            //스레드풀 작업 처리 요청
            executorService.execute(runnable);
            //executorService.submit(runnable);

            //콘솔 출력을 위해 main스레드에 10ms sleep을 걸어둠.
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        executorService.shutdown();
    }
}
