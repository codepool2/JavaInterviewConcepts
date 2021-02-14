package multithreading.interthreadcom.producerconsumerpattern;

import java.util.LinkedList;
import java.util.Queue;

public class Data {

    private Queue<Integer> queue = new LinkedList<>();


    public synchronized void putData() throws InterruptedException {

        System.out.println("producer in action");
        int n = 1;
        while (true) {
            System.out.println(Thread.currentThread().getName());

            queue.add(n);
            n++;
            this.notify();
            if (queue.size() >= 1) {

                this.wait();
            }
        }
    }

    public synchronized void getData() throws InterruptedException {

        System.out.println("consumer in action");
        while (true) {


            if (queue.isEmpty()) {
                this.wait();
            }
            System.out.println(queue.poll()+" size "+queue.size()+ "  " + Thread.currentThread().getName());
            this.notify();
        }
    }


    public static void main(String[] args) {

        Data data = new Data();

        Thread producer = new Thread(() -> {

            try {
                data.putData();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "producer");

        Thread consumer = new Thread(() -> {

            try {
                data.getData();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "consumer");

        producer.start();
        consumer.start();

    }
}
