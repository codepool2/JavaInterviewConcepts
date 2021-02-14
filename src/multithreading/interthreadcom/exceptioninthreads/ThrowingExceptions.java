package multithreading.interthreadcom.exceptioninthreads;

public class ThrowingExceptions {


    public static void main(String[] args) throws InterruptedException {


        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            throw new RuntimeException();
        };

        Thread thread = new Thread(runnable, "Thread1");

        thread.start();

        Thread.sleep(6000);;
        System.out.println("safe exit");
    }
}
