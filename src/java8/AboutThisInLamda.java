package java8;

public class AboutThisInLamda {


    int x_var = 1;

    public void m2(){

        Test test = new Test() {

            int x_var = 10;
            @Override
            public void m1() {
                System.out.println(this.x_var);
            }


        };

        test.m1();
    }

    public static void main(String[] args) {

        AboutThisInLamda aboutThisInLamda = new AboutThisInLamda();
        aboutThisInLamda.m2();
    }


}
