package multithreading.interthreadcom.exceptioninthreads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableFuture {


    public static void main(String[] args) throws  InterruptedException {

        Callable<String> callable = () -> {

            Thread.sleep(2000);

            return "noisses";
        };

        Callable<String> stringCallable = () -> {

            Thread.sleep(2000);

            throw new RuntimeException();
        };
        List<Future<String>> futureList = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; i++) {

            if (i % 2 == 0) {

                futureList.add(executorService.submit(callable));
            } else {
               futureList.add(executorService.submit(stringCallable));
            }
        }

        executorService.shutdown();

         for(int i=0; i< futureList.size();i++){

             try {
                 System.out.println(futureList.get(i).get());
             } catch (ExecutionException e) {

                 System.out.println("got exception");
             }
         }



        System.out.println("happy exit");



    }
}
