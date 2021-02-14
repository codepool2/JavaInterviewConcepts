package multithreading.interthreadcom.exceptioninthreads;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class AboutCallable {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(1);


        Callable<String> callable = () -> {


            System.out.println("in callable");
            Thread.sleep(5000);
            throw new Exception();

        };

        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            futures.add(executorService.submit(callable));
        }

        System.out.println(LocalTime.now());
        for(Future<String> future : futures){
            System.out.println(LocalTime.now());
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println("came here?");

        executorService.shutdown();
    }
}
