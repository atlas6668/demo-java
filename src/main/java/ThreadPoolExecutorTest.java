import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by sunwenming on 2018/6/26.
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {
        long time = 0;
        for (;;) {
            int threads = 7;
            final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(threads, threads, 0L, TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<Runnable>());
            List<Future> futures = new ArrayList<Future>(threads);
            for (int i = 0; i < threads; i++) {
                Runnable runnable = new Runnable() {

                    public void run() {
//                        try {
//                            Thread.sleep(100);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                    }
                };
                Future future = threadPoolExecutor.submit(runnable);
                futures.add(future);
            }
            for (Future future : futures) {
                try {
                    future.get();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(threadPoolExecutor.getCompletedTaskCount());
            if (threadPoolExecutor.getActiveCount() > 0) {
                System.out.println(threadPoolExecutor.getActiveCount() + "======" + time);
                System.exit(0);
            }
            threadPoolExecutor.shutdown();
            time++;
        }
    }

}
