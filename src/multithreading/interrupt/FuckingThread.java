package multithreading.interrupt;

public class FuckingThread {


    public void fuckingForLongerTime() {

        while(true){
            System.out.println("Fucking hard........ help me");
            if(Thread.currentThread().isInterrupted()){

                System.out.println("Thanks for helping . Bye for now");
                return;
            }
        }
    }

}
