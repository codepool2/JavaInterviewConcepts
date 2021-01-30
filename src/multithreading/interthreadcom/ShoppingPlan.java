package multithreading.interthreadcom;

import java.time.LocalTime;

public class ShoppingPlan {

    Object lock = new Object();
    Object lock2 = new Object();


    public synchronized void boyGettingReady() throws InterruptedException {

        System.out.println("Boy got ready and waiting for his girl to get ready");
        System.out.println(" Asking her r u ready at" + LocalTime.now());
        Thread.sleep(3000);
        System.out.println(" Asking her r u ready at" + LocalTime.now());
        System.out.println("she siad 3 more seconds");
        System.out.println("Boy told he is waiting and asked her notify him once she is ready");
        this.wait();
        System.out.println("Girl told him to come out as she is ready at " + LocalTime.now());
    }

    public synchronized void girlGettingReady() throws InterruptedException {

        System.out.println("Girl going to get ready  " + LocalTime.now());
        Thread.sleep(9_000);
        System.out.println("Notifying her boy that she is ready");
        this.notify();


    }

    public void boyGettingReadyWithObjectMonitors() throws InterruptedException {


        synchronized (lock) {
            System.out.println("Boy got ready and waiting for his girl to get ready");
            System.out.println(" Asking her r u ready at" + LocalTime.now());
            Thread.sleep(3000);
            System.out.println(" Asking her r u ready at" + LocalTime.now());
            System.out.println("she siad 3 more seconds");
            System.out.println("Boy told he is waiting and asked her notify him once she is ready");
            //  this.wait();  //If we this we will get a iilegaemonitor exception because wait can be called only on a object which has a lock
           // lock.wait();
            System.out.println("Girl told him to come out as she is ready and boy came out at " + LocalTime.now());
        }

    }

    public void girlGettingReadyWithObjectMonitors() throws InterruptedException {

        synchronized (lock) {
            System.out.println("Girl going to get ready  " + LocalTime.now());
            Thread.sleep(9_000);
            System.out.println("Notifying her boy that she is ready");
            lock.notify();
        }


    }

    public void girlGettingReadyWithObjectMonitor2() throws InterruptedException {

        synchronized (lock2) {
            System.out.println("Girl going to get ready  " + LocalTime.now());
            Thread.sleep(9_000);
            System.out.println("Notifying her boy that she is ready");
            //lock.notify(); //throws exception because a thready can notify only if it has lock on that thread.
        }


    }

    public static void main(String[] args) throws InterruptedException {

        ShoppingPlan shoppingPlan = new ShoppingPlan();

        // tesstingwaitOnSynch(shoppingPlan);
        //  testingWaitOnSYnchBlocks(shoppingPlan);
        testingWaitOn2DifferentLocks(shoppingPlan); //this should not have impact as 2 threads can be accessed concurrently

    }

    private static void testingWaitOn2DifferentLocks(ShoppingPlan shoppingPlan) throws InterruptedException {
        Thread boyThread = new Thread(() -> {
            try {
                shoppingPlan.boyGettingReadyWithObjectMonitors();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "boyThread");

        Thread girlThread = new Thread(() -> {
            try {
                shoppingPlan.girlGettingReadyWithObjectMonitor2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "girlThread");


        boyThread.start();

        Thread.sleep(0001);
        girlThread.start();

    }

    private static void testingWaitOnSYnchBlocks(ShoppingPlan shoppingPlan) throws InterruptedException {
        Thread boyThread = new Thread(() -> {
            try {
                shoppingPlan.boyGettingReadyWithObjectMonitors();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "boyThread");

        Thread girlThread = new Thread(() -> {
            try {
                shoppingPlan.girlGettingReadyWithObjectMonitors();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "girlThread");


        boyThread.start();

        Thread.sleep(0001);
        girlThread.start();

    }

    private static void tesstingwaitOnSynch(ShoppingPlan shoppingPlan) throws InterruptedException {
        Thread boyThread = new Thread(() -> {
            try {
                shoppingPlan.boyGettingReady();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "boyThread");

        Thread girlThread = new Thread(() -> {
            try {
                shoppingPlan.girlGettingReady();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "girlThread");


        boyThread.start();

        Thread.sleep(0001);
        girlThread.start();
    }
}
