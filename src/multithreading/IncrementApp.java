package multithreading;

public class IncrementApp {


    public static void main(String[] args) throws InterruptedException {
        Incrementer incrementer = new Incrementer();

        Runnable runnable = () -> {

            for (int i = 1; i <= 100000; i++) {

                incrementer.incrementCounter();
                System.out.println(Thread.currentThread().getName() + "  " + i + " " + incrementer.count);
            }


        };

        Runnable runnable1 = () -> {

            for (int i = 1; i <= 100000; i++) {

                incrementer.incrementCounter();
                System.out.println(Thread.currentThread().getName() + "  " + i + " " + incrementer.count);

            }
        };

        //two threads working on same shared object, as thread 1 and thread2 are trying to access same object resource, As thread1 does the job
        //then the thread2 may get a chance, so the two threads may get chance.
        //If u use Thread1.join, then Thread2 wil wait for thread1 to finish

        Thread thread1 = new Thread(runnable, "thread1");
        Thread thread2 = new Thread(runnable1, "thread2");


        thread2.start();
        thread1.start();


    }
}
