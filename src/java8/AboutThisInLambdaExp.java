package java8;

public class AboutThisInLambdaExp {

    int x_var = 1;

    public void m2(){

        Test test = ()-> {
            int x_var =999;
            System.out.println(x_var);
        };

        test.m1();
    }

    public static void main(String[] args) {

        AboutThisInLambdaExp aboutThisInLamda = new AboutThisInLambdaExp();
        aboutThisInLamda.m2();
    }
}
