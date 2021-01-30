package multithreading;

public class Incrementer {

     long count = 0;

 //using synch method
   /* public synchronized void incrementCounter() {
        this.count++;
    }

    public synchronized int getCounter() {
        int a = --this.count;
        return a;
    }*/

    public  void incrementCounter() {
        this.count++;
    }

   /* public  int getCounter() {
        int a = long--this.count;
        return a;
    }*/

}
