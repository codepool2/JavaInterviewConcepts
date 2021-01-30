package multithreading;

public class BasicsInThread {


    public static void main(String[] args) {


        Runnable runnable = () -> {


            System.out.println("thread " + Thread.currentThread().getName() + " entered");
            if (Thread.currentThread().getName().equals("thread1")) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("thread " + Thread.currentThread().getName() + " exiting");
        };


        Thread thread1 = new Thread(runnable, "thread1");
        Thread thread2 = new Thread(runnable, "thread2");


        thread2.start();
        thread1.start();

    }

}
