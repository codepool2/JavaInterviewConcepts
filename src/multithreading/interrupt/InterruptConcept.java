package multithreading.interrupt;

public class InterruptConcept {


    public static void main(String[] args) {
//Here one thread can ask other thread to stop execution, by using Thread.interrupt, now it is on
// dveeloper to check if the thread is interrupted or not. If it is interrupted he can code  accdngly

        FuckingThread fuckingThread = new FuckingThread();

        Runnable fucking = () -> {

                fuckingThread.fuckingForLongerTime();

        };

        Thread hardFucker = new Thread(fucking, "long");

        Thread policeThread = new Thread(()->{
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            hardFucker.interrupt();
            if(hardFucker.isAlive()){
                System.out.println("As a police u saved her from hardFucker");
            }
        });


        hardFucker.start();
        policeThread.start();
    }


}
