package multithreading.interrupt;

import java.time.LocalTime;

public class InterruptOnWaitingOrSleepingThread {

    //If interrupt is called on waiting or sleeping thread, then It will throw interruption  exception

    private Object object = new Object();

    public void interruptOnSleepMethod() throws InterruptedException {

        while (true) {
            System.out.println(LocalTime.now());
            Thread.sleep(2000);
        }

    }

    public void interruptOnWaitingThread() throws InterruptedException {

        for (int i = 0; i < 100; i++) {
            synchronized (object) {
                if (i == 50) {
                    System.out.println("Going into wait");
                    object.wait();
                }

            }

        }
    }


    public static void main(String[] args) {


        Thread sleepingthread = new Thread(() -> {
            InterruptOnWaitingOrSleepingThread interruptOnWaitingOrSleepingThread = new InterruptOnWaitingOrSleepingThread();
            try {
                interruptOnWaitingOrSleepingThread.interruptOnSleepMethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "sleepingThread1");

        Thread disturbingThreadOnSLeepingThread = new Thread(() -> {

            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            sleepingthread.interrupt();
        }, "disturbingSleepingThread");

        sleepingthread.start();
        disturbingThreadOnSLeepingThread.start();

        Thread waitingThread = new Thread(() -> {
            InterruptOnWaitingOrSleepingThread interruptOnWaitingOrSleepingThread = new InterruptOnWaitingOrSleepingThread();
            try {
                interruptOnWaitingOrSleepingThread.interruptOnWaitingThread();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "waitingThread");

        Thread disturbWaitingThread = new Thread(() -> {

            try {

                Thread.sleep(10000);
                System.out.println("Yeah, going to disturb........");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            waitingThread.interrupt();
        }, "disturbWaitingThread");

        waitingThread.start();
        disturbWaitingThread.start();
    }


}
